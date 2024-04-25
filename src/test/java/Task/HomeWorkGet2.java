package Task;

import baseURL.DummyRestApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;

public class HomeWorkGet2 extends DummyRestApiBaseURL {
/*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And
     */

    @Test
    public void test(){
      // Set url
      specification.pathParams("employe","employees") ;

      //Set expected data
      // Send request
        Response response= given().spec(specification).when().get("/{employe}");
        response.prettyPrint();
        //To do assert

        //Status Code un "200" olduğunu Assert et
        response.then().assertThat().statusCode(200);

        //employee_age i 55'ten büyük olanları konsola yazdırınız.
        //		     8 tane olduğunu assert ediniz.

        JsonPath jsonPath = response.jsonPath();

        List<Integer> age = jsonPath.getList("data.findAll{(it.employee_age)>55}.employee_age");
        System.out.println("age > 55 = " + age);

        //id si 17 den büyük olanları konsola yazdırınız
        //            7 tane olduğunu assert ediniz.
        List<Integer> id = jsonPath.getList("data.findAll{(it.id)>17}.id");
        System.out.println("id > 17 = " + id);
        assertTrue(id.size()==7);

//        salary si 100.000'den az olanları konsola yazdırınız.
//        Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        List<Integer> salary = jsonPath.getList("data.findAll{(it.employee_salary)<100000}.employee_name");
        System.out.println("salary = " + salary);
        assertTrue(salary.contains("Doris Wilder"));


    }
}

