package postRequests;

import baseURL.RestFullBookerApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.BookingDatesPojo;
import pojoDatas.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends RestFullBookerApiBaseURL {

    /*
    Given
        1) https://restful-booker.herokuapp.com/booking
        2) {
                "firstname": "Cuneyt",
                "lastname": "Arkin",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Extra pillows please"
            }
    When
        I send POST Request to the Url
    Then
        Status code is 200
        And response body should be like {
                                            "bookingid": 2243,
                                            "booking":{
                                                        "firstname": "Jane",
                                                        "lastname": "Doe",
                                                        "totalprice": 111,
                                                        "depositpaid": true,
                                                        "bookingdates": {
                                                            "checkin": "2018-01-01",
                                                            "checkout": "2019-01-01"
                                                        },
                                                        "additionalneeds": "Extra pillows please"
                                                    }
                                             }
 */

    @Test

    public void post03(){
        //Set the URL --> booking

        specification.pathParam("bookingPath", "booking");

        //Set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");

        BookingPojo bookingPojo= new BookingPojo("Cuneyt", "Arkin",111, true, bookingDatesPojo, "Extra pillows please");

         //Send the request

        Response response= given(specification).
                contentType("application/json").
                when().
                body(bookingPojo).
                post("/{bookingPath}");
        response.prettyPrint();

        //Do the assertion

        JsonPath jsonPath=response.jsonPath();

        response.then().assertThat().statusCode(200);
       assertEquals(bookingPojo.getFirstname(), jsonPath.getString("booking.firstname"));
        assertEquals(bookingPojo.getLastname(), jsonPath.getString("booking.lastname"));
        assertEquals(bookingPojo.getTotalprice(), jsonPath.getInt("booking.totalprice"));
        assertEquals(bookingPojo.isDepositpaid(), jsonPath.getBoolean("booking.depositpaid"));
        assertEquals(bookingDatesPojo.getCheckin(), jsonPath.getString("booking.bookingdates.checkin"));
        assertEquals(bookingDatesPojo.getCheckout(), jsonPath.getString("booking.bookingdates.checkout"));
        assertEquals(bookingPojo.getAdditionalneeds(), jsonPath.getString("booking.additionalneeds"));


    }

}
