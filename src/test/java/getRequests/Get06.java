package getRequests;

import baseURL.DummyRestApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends DummyRestApiBaseURL {

     /*

     Given
        https://dummy.restapiexample.com/public/api/v1/employees
       When
           User Sends Request with GET Method
       Then
           Assert that Status Code is "200"
       And
           Print employee_age greater than 55 to the console.
       And
           Assert that there are 8.
       And
             Write the IDs greater than 17 to the console.
             Assert that there are 7 ids greater than 17.
       And
             Print those whose salary is less than 100,000 to the console.
             Assert that Doris Wilder is one of them.
       */

    @Test
    public void get06(){
        //Set the URL
        specification.pathParam("employeePath", "employees");

        //Set the expected data (ignored)

        //Send the request

       Response response= given().spec(specification).when().get("/{employeePath}");

       response.prettyPrint();

       //Do the assertion
       // Assert that Status Code is "200"
       // Print employee_age greater than 55 to the console.
       // Assert that there are 8.

        response.then().statusCode(200);

        JsonPath jsonPath= response.jsonPath();   // jSon path aradaki data formatini duzenliyor.
        /*
        SERIALIZATION ---> to convert Java object to JSON file.
         */

        // 1. yol
        List<Integer> employeeAgeList= jsonPath.getList("data.employee_age");
        System.out.println("employeeAgeList = " + employeeAgeList);

        int counter=0;
        for (Integer w: employeeAgeList){

            if(w>55){
                System.out.println(w);
                counter ++;
            }
        }
        assertEquals(8, counter);


        // 2. yol


        /*
        Write the IDs greater than 17 to the console.
                Assert that there are 7 ids greater than 17.              
         */

        List<Integer> idList= jsonPath.getList("data.findAll{(it.id)>17}.id");
        System.out.println("idList = " + idList);


        assertEquals(7, idList.size());
        
        /*
        Print those whose salary is less than 100,000 to the console.
        Assert that Doris Wilder is one of them.
        */
        
        List<Integer> salaryList= jsonPath.getList("data.findAll{(it.employee_salary)<100000}.employee_name");
        System.out.println("salaryList = " + salaryList);

        assertTrue(salaryList.contains("Doris Wilder"));

        
        
    }

}
