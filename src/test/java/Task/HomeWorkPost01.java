package Task;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class HomeWorkPost01 extends JsonPlaceHolderBaseURL {
/*
     Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
          }
    When
        I send POST Request to the Url

    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Do your homework",
                                "completed": false,
                                "id": 201
                                }
*/
    @Test
    public void test(){
        //Set url
        specification.pathParam("todos","todos");
        //Set expexted data
        String expectedData = "{\n" +
                "             \"userId\": 55,\n" +
                "             \"title\": \"Tidy your room\",\n" +
                "             \"completed\": false\n" +
                "          }";
        HashMap<String,Object> expectedMap = JsonToJava.convertJsonToJavaObject(expectedData,HashMap.class);
        System.out.println("expectedMap = " + expectedMap);

        //Send request
        Response response = given(specification).body(expectedMap).contentType(ContentType.JSON).when().post("/{todos}");
        response.prettyPrint();

        // Do the assertion
            response.
                then().
                assertThat().
                body("userId", equalTo(55),
                        "title", equalTo("Tidy your room"), "completed", equalTo(false));

    }



}
