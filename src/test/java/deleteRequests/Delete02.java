package deleteRequests;

import baseURL.DummyRestApiBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testdata.DummyRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseURL {
     /*
    Given
            1)https://dummy.restapiexample.com/api/v1/delete/2840

        When
	 	    User sends Delete request
	 	Then
		 	Verify that Status code is 200
		 And
		    Response body in

		    {
    "status": "success",
    "data": "719",
    "message": "Successfully! Record has been deleted"
}

     */

    @Test
    public void delete02(){

        specification.pathParams("deletePath", "delete", "idPath", "2840");

        //Set the expected data

        DummyRestApiTestData dummyRestApiTestData= new DummyRestApiTestData();
       HashMap<String, Object> expectedDeleteData= dummyRestApiTestData.setUpdeleteData("success","2840", "Successfully! Record has been deleted");

        //Send the request

       Response response =given(specification).when().delete("/{deletePath}/{idPath}");

       response.prettyPrint();

       response.then().assertThat().statusCode(200);

       JsonPath jsonPath= response.jsonPath();

       assertEquals(expectedDeleteData.get("status"), jsonPath.getString("status"));
       assertEquals(expectedDeleteData.get("data"), jsonPath.getString("data"));
       assertEquals(expectedDeleteData.get("message"), jsonPath.getString("message"));




    }
}
