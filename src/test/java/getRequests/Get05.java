package getRequests;

import baseURL.TheMovieDBBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class Get05 extends TheMovieDBBaseURL {
    /*
    Given
            https://api.themoviedb.org/3/movie/popular

            api_key = 2eeebe74d17da380e718f9066997a62a    ---> query params

        When
              User Sends Request with GET Method
         Then
             Assert that Status Code is "200"
         And
             Assert that Content Type is "application/json"
         And
             Assert that among the ids there are
             646389
             536554
             640146.
     */
    @Test
    public void get05(){

        specification.pathParams("first", "movie", "second", "popular").
                queryParam("api_key", "4d12f0e702d4251ec9f4b92c1810b068");

       Response response= given().spec(specification).when().get("/{first}/{second}");
       response.prettyPrint();

       /*
       Assert that Status Code is "200"
         And
             Assert that Content Type is "application/json"
         And
             Assert that among the ids there are
             646389
             536554
             640146.
        */

        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("results.id", hasItems(634492, 693134, 693134));


    }
}
