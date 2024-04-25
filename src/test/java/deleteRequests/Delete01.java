package deleteRequests;

import baseURL.RestFullBookerApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete01 extends RestFullBookerApiBaseURL {

    /*
       Given
            1)https://restful-booker.herokuapp.com/booking/1
            2) Send token=001832eb39ba0ca with Cookie in HEader as Auth
        When
                User sends request with Delete
        And
                Status code is 201
        Then
                Verify that "Created" is written in the response body.


        We can delete the data when we post it to the booking using POST.
{

delete_bookingID: [1,5,7,8]
}
 */
    @Test
    public void delete01(){

        specification.pathParams("bookingPath", "booking", "idPath", "1478");

        //Set the expected data ignore edilecek cunku gonderilecek bir data kalıbına ihityac yok..

        //Send the request

        Response response= given(specification).
                contentType(ContentType.JSON).
                auth().
                basic("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
                header("Cookie", "token=e04a59808b60a45").
                delete("/{bookingPath}/{idPath}");


        response.prettyPrint();

        response.then().statusCode(201);

         String responseMessage= response.asString();

         assertEquals("Created", responseMessage);


    }


}
