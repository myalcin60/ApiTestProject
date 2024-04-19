package postRequests;

import baseURL.PetStoreApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.PetStoreUserPojo;
import utilities.JsonToJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostPetStore extends PetStoreApiBaseURL {
    /*
    given
    https://petstore.swagger.io/v2/pet
    and
    send  post request as request body :
[
  {
    "id": 0,
    "username": "ALi",
    "firstName": "veli",
    "lastName": "veli",
    "email": "veli@gmail",
    "password": "veli123",
    "phone": "123456789",
    "userStatus": 10
  }
]

     */


    @Test
    public void test(){
        // set url
        specification.pathParams("user","user","post","createWithList");
        //Set expected data
        PetStoreUserPojo user =new PetStoreUserPojo(0,
                "VALi",
                "veli",
                "veli",
                "veli@gmail",
                "veli123",
                "123456789",
                10);
        List<PetStoreUserPojo> expectedData = new ArrayList<>();
        expectedData.add(user);
        System.out.println("expectedData = " + expectedData);

        // Send request
        Response response = given(specification)
                .contentType(ContentType.JSON)
                .body(expectedData)
                .when()
                .post("/{user}/{post}");
        response.prettyPrint();

    }

}
