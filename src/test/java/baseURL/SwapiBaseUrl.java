package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class SwapiBaseUrl {

    protected RequestSpecification specification;

    @Before

    public void seUpBaseURL(){

        specification= new RequestSpecBuilder().setBaseUri("https://swapi.dev/api").build();


    }
}
