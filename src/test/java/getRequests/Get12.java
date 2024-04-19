package getRequests;

import baseURL.GoRestApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.GoRestApiPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends GoRestApiBaseURL {

    /*


        Given
            https://gorest.co.in/public/v2/users/6850007

        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Verify that the response body is like this

 {
    "id": 6850007,
    "name": "Pres. Bhaves Mehra",
    "email": "pres_bhaves_mehra@vonrueden.example",
    "gender": "female",
    "status": "active"
}

     */
    
    @Test
    public void  get12(){
        
        specification.pathParams("usersPath", "users", "idPath", "6850007");
        GoRestApiPojo goRestApiPojoObj= new GoRestApiPojo(6850007, "Pres. Bhaves Mehra", "pres_bhaves_mehra@vonrueden.example", "female","active" );
        System.out.println("goRestApiPojoObj = " + goRestApiPojoObj);

        Response response= given().spec(specification).when().get("/{usersPath}/{idPath}");
        response.prettyPrint();
        
        GoRestApiPojo actualDataPojo= response.as(GoRestApiPojo.class);
        System.out.println("actualDataPojo = " + actualDataPojo);

        assertEquals(goRestApiPojoObj.getId(), actualDataPojo.getId());
        assertEquals(goRestApiPojoObj.getEmail(), actualDataPojo.getEmail());
        assertEquals(goRestApiPojoObj.getName(), actualDataPojo.getName());
        assertEquals(goRestApiPojoObj.getGender(), actualDataPojo.getGender());
        assertEquals(goRestApiPojoObj.getStatus(), actualDataPojo.getStatus());


        
    }
    


}
