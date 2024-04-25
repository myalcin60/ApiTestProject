package putRequests;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Put01 extends JsonPlaceHolderBaseURL {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 1,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
        When
            User sends PUT Request
	    Then
	   	   Status code is 200
	   	And
	   	  Response body is like below.
	   	    {
                 "userId": 1,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
            }
     */

    @Test
    public void put01(){

        specification.pathParams("todosPath", "todos", "idPath", "198");


        //Set the expected data
        /*
        {
            "userId": 1,
                "title": "CW FSQA API Tutorial",
                "completed": true
        }
        */

        HashMap<String, Object> reqBodyAndExpectedData= new HashMap<>();
        reqBodyAndExpectedData.put("userId", 1);
        reqBodyAndExpectedData.put("title", "CW FSQA API Tutorial");
        reqBodyAndExpectedData.put("completed", true);

        //Send the request

        Response response= given(specification)
                .contentType(ContentType.JSON)
                .body(reqBodyAndExpectedData)
                .when().put("/{todosPath}/{idPath}");
        response.prettyPrint();






    }




}
