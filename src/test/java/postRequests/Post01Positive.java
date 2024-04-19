package postRequests;

import baseURL.GoRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Test;
import pojoDatas.GoRestApiPojo;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post01Positive extends GoRestApiBaseURL {

    //"Bearer e6ce7f456f99c9da72a06c2b71b4d71f4f9fbd2bae81541cdbbde7a561e41edd"

      /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    And
        Kullanıcı Request Body'i gonderir;
         {
        "name": "Durgeshwari Agarwal DVM",
        "email": "durgeshwari_agarwal_dvm@christiansen.gmail.com", --> Request Body/ Expected Data
        "gender": "female",
        "status": "active"
      }
    Then
        Status Code un "201" olduğunu Assert et
    Then
        Response un gonderilen data formatıyla aynı oldugunu assert ediniz

   */

    @Test
    public void post01Positive(){
        //Set the URL
        specification.pathParam("usersPath", "users");

        //Set the expected data

        GoRestApiPojo goRestApiPojo= new GoRestApiPojo(1, "Emel SAYIN", "emelsayn@EMELmail.com", "female", "active");

        //Send the request

        Response response= given(specification).
                body(goRestApiPojo).
                contentType(ContentType.JSON).
                when().header("Authorization", "Bearer e6ce7f456f99c9da72a06c2b71b4d71f4f9fbd2bae81541cdbbde7a561e41edd").
                post("/{usersPath}");

        response.prettyPrint();

        response.then().statusCode(201);


        //Do the assertion

       HashMap<String, String> actualDataMap= response.as(HashMap.class);

       assertEquals(goRestApiPojo.getName(), actualDataMap.get("name"));
       assertEquals(goRestApiPojo.getStatus(), actualDataMap.get("status"));
       assertEquals(goRestApiPojo.getGender(), actualDataMap.get("gender"));
       assertEquals(goRestApiPojo.getEmail(), actualDataMap.get("email"));
      // assertEquals(goRestApiPojo.getId(), actualDataMap.get("id"));


    }



}
