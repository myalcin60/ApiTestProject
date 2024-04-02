package get01;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
        Till now, we have sent different http requests Postman for API testing having different documents.

        In the market, we generally use POSTMAN as a manual API test tool not for the automation.
        But as we have learned previously in our sessions, POSTMAN also can be used for API test automation.

        From now on, we will use RestAssured Library for API test automation process.

        To be ale to do test, you need a document.
        We, as Test Engineers, can apply how to use http reqs and how to to do our tests APIs.
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
        String url = "https://restful-booker.herokuapp.com/booking/7";

        //3)Send Request --> SEND button in Postman
        /*
    Given
        https://restful-booker.herokuapp.com/booking/7
    When
        User sends GET Request     */

       Response response = given().when().get(url);
       /*Then
        Assert that Status Code is "200"
        */
        response.then().assertThat().statusCode(200);

        // And
        //Assert that Content Type is in "application/json"
        response.then().assertThat().contentType("application/json");
//        And
//        Assert that Status Line is "HTTP/1.1 200 OK"

        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        // tum sonucu gormek icin json modunda yazdirmak
        response.prettyPrint();

        // sadece status code yazdirmak icin
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        // content type yazdiralim
        System.out.println("response.getContentType() = " + response.getContentType());

        // response time yazdir
        System.out.println("response.getTime() = " + response.getTime());
        // headers lari yazdirmak icin
        System.out.println("response.getHeaders() = " + response.getHeaders());


    }


}
