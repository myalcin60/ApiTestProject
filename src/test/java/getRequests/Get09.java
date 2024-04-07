package getRequests;

import baseURL.DummyRestApiBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;
import testdata.DummyRestApiTestData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Get09 extends DummyRestApiBaseURL {
    /*

        Given
	   	   https://dummy.restapiexample.com/api/v1/employees
	    When
           User Sends Request with GET Method
        Then
           Assert that Status Code is "200"
        And
           User verifies that the last employee's name is "Doris Wilder"
        And
           User verifies that employee 6's salary is 372000
        And
           User verifies that the ages of employees includes 21, 23 and 59

     */
    @Test

    public void get09(){
        //1-Set the URL

        specification.pathParam("employeePath", "employees");

        //2-Set the expected data --> Baska bir classta expected dataları setleyelim

        DummyRestApiTestData dummyRestApiTestData= new DummyRestApiTestData();
        List<Map<String, Object>> expectedData= dummyRestApiTestData.setUpTestData();

        System.out.println("expectedData = " + expectedData);

        System.out.println(" ");

        //Send the request

        Response response= given().spec(specification).when().get("/{employeePath}");
        response.prettyPrint();

        //Do the assertion

        response.then().statusCode((Integer) expectedData.get(0).get("StatusCode")).
                body("data[-1].employee_name", equalTo(expectedData.get(1).get("employee_name")),
                      "data[5].employee_salary", equalTo(expectedData.get(2).get("employee_salary")),
                        "data.employee_age", hasItems(
                                ((List)expectedData.get(3).get("EmployeeAges")).get(0),
                                ((List)expectedData.get(3).get("EmployeeAges")).get(1),
                                ((List)expectedData.get(3).get("EmployeeAges")).get(2)));





    }


}
