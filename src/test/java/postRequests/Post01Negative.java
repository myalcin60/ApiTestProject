package postRequests;

import baseURL.GoRestApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.GoRestAPiTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01Negative extends GoRestApiBaseURL {
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
               header("Authorization", "Bearer 8ff3960a4427145ab4ab4ba02f9e2e3bd783be46fd0265d639f10c9e070e9705")
               .post("/{usersPath}");

       response.prettyPrint();


       //Assertion
        //assertEquals(goRestAPiTestData.statusCodeForInvalidPost(), response.getStatusCode());

        response.then().assertThat().statusCode(422);

    }

}
