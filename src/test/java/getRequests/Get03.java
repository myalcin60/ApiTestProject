package getRequests;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 extends JsonPlaceHolderBaseURL {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
             User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Assert that Content Type is "application/json"
        And
            Verify that the title is “quis ut nam facilis et officia qui”.,
        And
            Verify that “completed” is false.
        And
            Verify that “userId” is 1

     */

    //1 Step: Set the URL
    //2 Step: Set the expected data(ignored)
    //3 Step: Send the Request
    //4 Step: Do the Assertion

    @Test
    public  void get03(){

//    Given
//    https://jsonplaceholder.typicode.com/todos/2
        specification.pathParams("firstPath","todos", "secondPath", "2");


//    User Sends Request with GET Method

       Response response= given().spec(specification).when().get("/{firstPath}/{secondPath}");
       response.prettyPrint();

        //    Assert that Status Code is "200"
        //    Assert that Content Type is "application/json"
        response.then().assertThat().statusCode(200).contentType("application/json");


        //    Verify that the title is “quis ut nam facilis et officia qui”.,
        //    Verify that “completed” is false.
        //    Verify that “userId” is 1
        //1.yol
      /*  response.
                then().
                assertThat().
                body("title", Matchers.equalTo("quis ut nam facilis et officia qui"),
                        "completed", Matchers.equalTo(false), "userId", Matchers.equalTo(1));
      */

        //2.yol
        response.
                then().
                assertThat().
                body("title", equalTo("quis ut nam facilis et officia qui"),
                        "completed", equalTo(false), "userId", equalTo(1));




    }

}
