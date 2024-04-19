package Task;

import baseURL.SwapiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomeworkGet1 extends SwapiBaseUrl {
     /*

    Given
	   	     https://swapi.dev/api/vehicles/7
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
{
    "name": "X-34 landspeeder",
    "model": "X-34 landspeeder",
    "manufacturer": "SoroSuub Corporation",
    "cost_in_credits": "10550",
    "length": "3.4 ",
    "max_atmosphering_speed": "250",
    "crew": "1",
    "passengers": "1",
    "cargo_capacity": "5",
    "consumables": "unknown",
    "vehicle_class": "repulsorcraft",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/"
    ],
    "created": "2014-12-10T16:13:52.586000Z",
    "edited": "2014-12-20T21:30:21.668000Z",
    "url": "https://swapi.dev/api/vehicles/7/"
}


     */

    @Test
    public void test(){
        // set url
        specification.pathParams("vehicle","vehicles","id" ,"7");

        // set expected data

        String expectedData ="{\n" +
                "    \"name\": \"X-34 landspeeder\",\n" +
                "    \"model\": \"X-34 landspeeder\",\n" +
                "    \"manufacturer\": \"SoroSuub Corporation\",\n" +
                "    \"cost_in_credits\": \"10550\",\n" +
                "    \"length\": \"3.4 \",\n" +
                "    \"max_atmosphering_speed\": \"250\",\n" +
                "    \"crew\": \"1\",\n" +
                "    \"passengers\": \"1\",\n" +
                "    \"cargo_capacity\": \"5\",\n" +
                "    \"consumables\": \"unknown\",\n" +
                "    \"vehicle_class\": \"repulsorcraft\",\n" +
                "    \"pilots\": [],\n" +
                "    \"films\": [\n" +
                "        \"https://swapi.dev/api/films/1/\"\n" +
                "    ],\n" +
                "    \"created\": \"2014-12-10T16:13:52.586000Z\",\n" +
                "    \"edited\": \"2014-12-20T21:30:21.668000Z\",\n" +
                "    \"url\": \"https://swapi.dev/api/vehicles/7/\"\n" +
                "}";
        HashMap<String,Object> expectedResult= JsonToJava.convertJsonToJavaObject(expectedData,HashMap.class);

        //Send request
        Response response = given().spec(specification).when().get("/{vehicle}/{id}");
        response.prettyPrint();
        HashMap<String,Object> actualResult= response.as(HashMap.class);

        // To do assert
        response.then().assertThat().statusCode(200);
        assertEquals(expectedResult,actualResult);
    }

}



