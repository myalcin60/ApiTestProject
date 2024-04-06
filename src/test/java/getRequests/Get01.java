package getRequests;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Get01 {

    /*
        Till now, we have sent different http requests Postman for API testing having different documents.

        In the market, we generally use POSTMAN as a manual API test tool not for the automation.
        But as we have learned previously in our sessions, POSTMAN also can be used for API test automation.

        From now on, we will use RestAssured Library for API test automation process.

        To be able to do test, you need a document.
        We, as Test Engineers, can apply how to use http reqs and how to do our tests APIs.
        Besides, we can create test cases and scenarios by following documents. Just like we follow UI and create test cases
        and run those test cases in Selenium Web UI.

        Test Case:

         --> Expected Result  // TEST CASE
         ---> Actual Result      ====>>>>> I will get from response from API

        Gherkin Lang.

            Given ---> Pre-requisite of test
            When ---> Action
            Then ---> Assertion
            And  ---> shows that the effect of the previous action continues

     */

/*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        User sends GET Request
    Then
        Assert that Status Code is "200"
    And
        Assert that Content Type is in "application/json"
    And
        Assert that Status Line is "HTTP/1.1 200 OK"

     */

    /*
        We have 4 steps in API testing in general.

        1)We should identify/set the URL

        2)We should set the expected data. Expected data is provided by using documents for Test Cases.
        For now, we will ignore this step.

        3)Send Request --> SEND button in Postman

        4)Do Assertion
         */
    @Test

    public void userDataCheck(){
        // 1)We should identify/set the URL

        String URL= "https://restful-booker.herokuapp.com/booking/7";

        // 2)We should set the expected data. Expected data is provided by using documents for Test Cases.
        //For now, we will ignore this step.

        //3)Send Request --> SEND button in Postman
        /*Given
        https://restful-booker.herokuapp.com/booking/7
        When
        User sends GET Request*/
        Response response= given().when().get(URL);

        //Assert that Status Code is "200"
        response.then().assertThat().statusCode(200);

        //Assert that Content Type is in "application/json"

        response.then().assertThat().contentType("application/json");

        //Assert that Status Line is "HTTP/1.1 200 OK"

        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        response.prettyPrint(); //sout gibi

        //sadece status code yazdırmak icin
        System.out.println("Response" + response.getStatusCode());
        //cotent type yazdırmak
        System.out.println("Content type: " + response.getContentType());

        //response time yazdırmak
        System.out.println("Time: " + response.getTime());

        //headers yazdırmak içinæ
        System.out.println("Headers " + response.getHeaders());


    }


}