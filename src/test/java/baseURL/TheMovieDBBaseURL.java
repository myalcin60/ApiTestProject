package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TheMovieDBBaseURL {

    protected RequestSpecification specification;

    @Before

    public void seUpBaseURL(){

        specification= new RequestSpecBuilder().setBaseUri("https://api.themoviedb.org/3").build();


    }
}
