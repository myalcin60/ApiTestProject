package putRequests;

import baseURL.RestFullBookerApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.BookingDatesPojo;
import pojoDatas.BookingPojo;

import static io.restassured.RestAssured.given;

public class Put02 extends RestFullBookerApiBaseURL {
    /*
        Given
	        1) https://restful-booker.herokuapp.com/booking/1284
	        2) {
                    "firstname" : "Ilyas",
                    "lastname" : "Salman",
                    "totalprice" : 4000,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2022-01-01",
                        "checkout" : "2023-01-01"
                                      },
                    "additionalneeds" : "API and Appium"
                }
        3) User as Auth. firstly should send request to Cookie in Headers and then to Basic Auth to have token

            Authorization ==>>  Basic YWRtaW46cGFzc3dvcmQxMjM=

            Cookie =>>> token=001832eb39ba0ca

        When
	 		User sends PUT Request
	    Then
	   	   Assert that Status code is 200
	   	And
	   	  Assert that Response body pattern is like below.
	   	    {
                "firstname" : "Ilyas",
                "lastname" : "Salman",
                "totalprice" : 4000,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2022-01-01",
                    "checkout" : "2023-01-01"
                },
                "additionalneeds" : "API and Appium"
            }
     */

    @Test
    public void put02(){

        //Set the URL
        specification.pathParams("bookingPath", "booking", "idPath", "376");

        //Set the expected data

        BookingDatesPojo bookingDatesPojo= new BookingDatesPojo("2022-01-01", "2023-01-01");

        BookingPojo bookingPojo= new BookingPojo("Ilyas", "Salman", 4000, true, bookingDatesPojo, "API and Appium");

        Response response= given(specification).
                body(bookingPojo).
                contentType(ContentType.JSON).
                when().
                auth().basic("Authorization","YWRtaW46cGFzc3dvcmQxMjM=").
                header("Cookie", "token=f9be94af8faf3df").
                put("/{bookingPath}/{idPath}");

        response.prettyPrint();
       int statusCode= response.statusCode();

        System.out.println("statusCode = " + statusCode);


        //401  ----->> Unauth.     -----------------    When no value is found for Aut.
        //403 ------>> Forbidden    - - -- - -- - --    Some value exist as Token or related with Auth generating method but it may be wrong or expired

    }




}
