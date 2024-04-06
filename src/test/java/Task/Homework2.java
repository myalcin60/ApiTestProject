package Task;

import baseURL.DummyRestApiBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework2 extends DummyRestApiBaseURL {
     /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
*/

    @Test
    public  void getDummy(){
       specification.pathParams("first","employee","second","1");
        Response response = given().spec(specification).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200)
                .body("status",equalTo("success"),
                        "data.id",equalTo(1),
                        "data.employee_name",equalTo("Tiger Nixon"),
                        "data.employee_salary",equalTo(320800),
                        "data.employee_age",equalTo(61),
                        "data.profile_image",equalTo(""),
                        "message",equalTo("Successfully! Record has been fetched."));
    }
}
