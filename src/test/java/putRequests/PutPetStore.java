package putRequests;

import baseURL.PetStoreApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojoDatas.PetStoreUserPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class PutPetStore extends PetStoreApiBaseURL {
    @Test
    public void testPut() {
        //set url
        specification.pathParams("user", "user", "name", "VALi");
        //set expected dta

        PetStoreUserPojo expected = new PetStoreUserPojo(0,
                "ELA",
                "veli",
                "veli",
                "ela@gmail",
                "veli123",
                "123456789",
                10);
        System.out.println("expected = " + expected);
        //send request
        Response response =given(specification)
                .contentType(ContentType.JSON)
                .body(expected)
                .when().put("/{user}/{name}");
        response.prettyPrint();

        //do the assertion
        response.then().assertThat().statusCode(200)
                .body("code",equalTo(200),"type",equalTo("unknown"));

    }
}
