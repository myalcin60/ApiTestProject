package Task;

import baseURL.RestfulBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.assertTrue;

public class Homework1 extends RestfulBaseURL {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.


 */

    @Test
    public void getBooking(){
        specification.pathParam("booking", "booking");
        Response response = given().spec(specification).when().get("/{booking}");

        response.prettyPrint();

        response.then().statusCode(200);
        String responseBodyStr= response.asString();
        assertTrue(responseBodyStr.contains("bookingid"));

    }
}
