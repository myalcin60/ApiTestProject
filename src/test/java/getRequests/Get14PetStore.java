package getRequests;

import baseURL.PetStoreApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.PetStoreUserPojo;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get14PetStore extends PetStoreApiBaseURL {
    /*
    {
  "id": 9223372036854762000,
  "username": "VALi",
  "firstName": "veli",
  "lastName": "veli",
  "email": "veli@gmail",
  "password": "veli123",
  "phone": "123456789",
  "userStatus": 10
}
     */
    @Test
    public void testGet(){
        //set url
        specification.pathParams("user","user","name","VALi");
        //set expected dta

        PetStoreUserPojo expected =new PetStoreUserPojo(0,
                "VALi",
                "veli",
                "veli",
                "veli@gmail",
                "veli123",
                "123456789",
                10);
        System.out.println("expected = " + expected);
        //send request
        Response response =given(specification).when().get("/{user}/{name}");
        response.prettyPrint();
        PetStoreUserPojo actual = response.as(PetStoreUserPojo.class);
        // Do the assertion
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getUsername(), actual.getUsername());


    }


}
