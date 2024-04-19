package Task;

import baseURL.GoRestApiBaseURL;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class Deneme_11 extends GoRestApiBaseURL {

       /*


        Given
            https://gorest.co.in/public/v2/users/6850043
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this

  {
    "id": 6849981,
    "name": "Harit Talwar VM",
    "email": "talwar_harit_vm@torp-okeefe.test",
    "gender": "male",
    "status": "inactive"
}

  */

    @Test
    public void test(){
        specification.pathParams("usersPath", "users", "idPath", "6849981");

        String expectedData= "{\n" +
                "    \"id\": 6849981,\n" +
                "    \"name\": \"Harit Talwar VM\",\n" +
                "    \"email\": \"talwar_harit_vm@torp-okeefe.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        HashMap<String, Object>  expectedDataMap= JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

        //Send the request

        Response response=  given().spec(specification).when().get("/{usersPath}/{idPath}");
        response.prettyPrint();
        //Do the Assertion
        HashMap<String, Object> actualDataMap=  JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

    }

}
