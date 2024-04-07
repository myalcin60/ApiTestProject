package testdata;

import java.util.HashMap;

public class JsonPlaceHolderTestData {
    /*
    Given
	   	     https://jsonplaceholder.typicode.com/todos/2
        When
            User Sends Request with GET Method
        Then
            Assert that Status Code is "200"
        And
            Assert that the Server is cloudflare in the Header
        And
            Verify that the response body is like this


          {
            "userId": 1,
            "id": 2,
            "title": "quis ut nam facilis et officia qui",
            "completed": false
          }
 */
    public static HashMap<String,Object> expectedDataMap = new HashMap<>();
    public HashMap setUpDataTodos(){
        expectedDataMap= new HashMap<>();
        expectedDataMap.put("StatusCode",200);
        expectedDataMap.put("Server","cloudflare");
        expectedDataMap.put( "userId", 1.0);
        expectedDataMap.put("id", 2.0);
        expectedDataMap.put("title", "quis ut nam facilis et officia qui");
        expectedDataMap.put( "completed", false);

        return expectedDataMap;

    }
}
