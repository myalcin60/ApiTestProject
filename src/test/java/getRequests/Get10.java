package getRequests;

import baseURL.ZippopotamBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.ZippopatamPlacesPojo;
import pojoDatas.ZippopotamPojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends ZippopotamBaseURL {
     /*
        Given
            http://api.zippopotam.us/TR/34010
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this


    {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "Turkey",
    "places": [
              {
                "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
              }
              ]
    }
*/

    @Test
    public void get10(){

        specification.pathParams("countryPath", "TR",
                "postalCode", "34010");

        //Set the expected data

        ZippopatamPlacesPojo zippopatamPlaces= new ZippopatamPlacesPojo("Maltepe Mah.", "32.3609","İstanbul", "34", "40.1589");
        ZippopotamPojos zippopotam= new ZippopotamPojos("34010", "Turkey", "TR", zippopatamPlaces);

        System.out.println("zippopotam = " + zippopotam);

        //Send the request
        Response response=  given().spec(specification).when().get("/{countryPath}/{postalCode}");
        response.prettyPrint();

        //Do the assertion --> Deserialization --> JSON kullanarak
        
        Map<String, Object> actualData= response.as(HashMap.class);

        System.out.println("actualData = " + actualData);

        assertEquals(zippopotam.getPostCode(), actualData.get("post code"));
        assertEquals(zippopotam.getCountry(), actualData.get("country"));
        assertEquals(zippopotam.getCountryAbbreviation(), actualData.get("country abbreviation"));
        assertEquals(zippopotam.getZippopatamPlacesPojo().getPlaceName(), (((Map)((List)actualData.get("places")).get(0)).get("place name")));
        assertEquals(zippopotam.getZippopatamPlacesPojo().getLongitude(), (((Map)((List)actualData.get("places")).get(0)).get("longitude")));
        assertEquals(zippopotam.getZippopatamPlacesPojo().getState(), (((Map)((List)actualData.get("places")).get(0)).get("state")));
        assertEquals(zippopotam.getZippopatamPlacesPojo().getStateAbbreviation(), (((Map)((List)actualData.get("places")).get(0)).get("state abbreviation")));
        assertEquals(zippopotam.getZippopatamPlacesPojo().getLatitude(), (((Map)((List)actualData.get("places")).get(0)).get("latitude")));

        
        

    }
}
