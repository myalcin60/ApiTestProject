package getRequests;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends JsonPlaceHolderBaseURL {
           /*
       Given
             https://jsonplaceholder.typicode.com/users --> resources different
         When
              User Sends Request with GET Method
         Then
             Assert that Status Code is "200"
         And
             Assert that Content Type is "application/json"
         And
             Assert that the data length is 10.
     */
    @Test
    public void get04(){
        //Set the Url
        specification.pathParam("usersPath", "users");

        //Set the expected data(ignored)

        //Send the Request

       Response response= given().spec(specification).when().get("/{usersPath}");
       response.prettyPrint();

        //Get the response and do assertion
        //Assert that Status Code is "200" && Assert that Content Type is "application/json"

        //Hard Assertion code exception verdigi anda durur ve sonraki kodları okumaz (assertThat() --> RestAssured Lib)
        //SoftAssertion code exception verse bile devam eden kodları calıstırmaya devam eder. Softassertion icin softassert class dan bir object olusturmamız gereklidir.
        //SoftAssert softAssert= new SoftAssert();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.hasSize(10));

        //application/json; charset=utf-8

       // Assert that the data length is 10.






    }
}
