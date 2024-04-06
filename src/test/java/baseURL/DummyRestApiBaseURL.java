package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseURL {

    protected RequestSpecification specification;

    @Before

    public void seUpBaseURL(){

        specification= new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/public/api/v1").build();


    }
}
