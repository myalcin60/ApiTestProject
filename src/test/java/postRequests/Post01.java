package postRequests;

import baseURL.GoRestApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.GoRestAPiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends GoRestApiBaseURL {
    /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et

   */

    @Test
    public void post01(){
        //Set the URL

        specification.pathParam("usersPath", "users");

        //Set the expected data
        GoRestAPiTestData goRestAPiTestData= new GoRestAPiTestData();
        System.out.println("goRestAPiTestData = " + goRestAPiTestData.statusCodeForInvalidPost());

        //Send the request

       Response response= given().
               spec(specification).
               when().
               header("Authorization", "Bearer aff7ca20349b0a8167ad95cc31b6d31ae15c30b072f57268a1e14b87c223ae67")
               .post("/{usersPath}");

       response.prettyPrint();


       //Assertion
        //assertEquals(goRestAPiTestData.statusCodeForInvalidPost(), response.getStatusCode());

        response.then().assertThat().statusCode(422);

    }
}
