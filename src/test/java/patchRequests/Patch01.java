package patchRequests;

import baseURL.RestFullBookerApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends RestFullBookerApiBaseURL {
    /*
     Given
	        1) https://restful-booker.herokuapp.com/booking/702
	        2) {
                "firstname" : "Drake",
                "lastname" : "CW"
                }
3) For Auth --> In Header, Basic YWRtaW46cGFzc3dvcmQxMjM=

        When
	 		User sends PATCH Req
	    Then
	   	   Status code is 200
	   	And
	   	   Assert that firstname and lastName in Response body have changed.
               {
                "firstname": "Drake",
                "lastname": "CW",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                                    "checkin": "2018-01-01",
                                    "checkout": "2019-01-01"
                                },
                "additionalneeds": "Breakfast"
               }
     */


    @Test
    public void patch01(){

        //Set the URL ---> booking/376

        specification.pathParams("bookingPath", "booking", "idPath", "958");

        //Set the expected data

        File file= new File("src/test/java/testdata/testdata.json");
       Map expectedDataAndReqBody= JsonToJava.convertJsonToJavaObject(file, Map.class);
//       HashMap <String, Object> expected =JsonToJava.convertJsonToJavaObject(file, HashMap.class);

       //Send the request

       Response response= given(specification).
                contentType(ContentType.JSON).
                body(expectedDataAndReqBody).
                when().
                header("Cookie", "token=19fc7e17f6bb93c").
               patch("/{bookingPath}/{idPath}");

       response.prettyPrint();

       //Assertion

        Map<String, Object> actualDataMap= response.as(Map.class);


        assertEquals(expectedDataAndReqBody.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataAndReqBody.get("lastname"), actualDataMap.get("lastname"));

        HashMap<String,Object> actual = response.as(HashMap.class);

//        assertEquals(expected.get("firstname"), actual.get("firstname"));
//        assertEquals(expected.get("lastname"), actual.get("lastname"));



    }
}
