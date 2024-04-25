package trelloAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testdata.TrelloApiTestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class StepDefs {
    JsonPath jsonPath;
    public static String boardId;
    public static Response response;
    public static String listID;

    public static List<String> cardIDList= new ArrayList<>();


    public RequestSpecification specification;
    TrelloApiTestData trelloApiTestData = new TrelloApiTestData();

    @Given("Kullanıcı Trello icin Base URL set eder {string}")
    public void kullanıcı_Trello_icin_Base_URL_set_eder(String baseURL) {
        //https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'
        //Set the baseUrl
        specification = new RequestSpecBuilder().setBaseUri(baseURL).build();

    }

    @When("Kullanıcı board create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar {string},{string},{string},{string}")
    public void kullanıcı_board_create_edebilmek_icin_ilgili_url_e_POST_methodu_ve_ilgili_endpointler_ile_request_atar(String idPath, String id, String boardsPath, String boards) {

        //Set the endpoints, query parameters, required field= name
        specification.pathParams(idPath, id,
                        boardsPath, boards).contentType(ContentType.JSON).
                queryParams("name", trelloApiTestData.getName(),
                        "key", trelloApiTestData.getKey(), "token", trelloApiTestData.getToken());


        //Send the Request

        String idPathFormatted = String.format("{%s}", idPath);
        String boardsPathFormatted = String.format("{%s}", boardsPath);

        response = given(specification).when().post("/" + idPathFormatted + "/" + boardsPathFormatted + "/");

        response.prettyPrint();

    }

    @When("Kullanıcı board id yi alır")
    public void kullanıcı_board_id_yi_alır() {
        jsonPath = response.jsonPath();
        boardId = jsonPath.getString("id");
        System.out.println("boardId = " + boardId);  // boardId = 662925ea37b199837349dedf

    }

    @Then("Kullanıcı boad un basarili bir sekilde create edildigini dogrular")
    public void kullanıcı_boad_un_basarili_bir_sekilde_create_edildigini_dogrular() {
        response.then().assertThat().statusCode(200);
    }

    @When("Kullanıcı list create edebilmek icin ilgili url e POST methodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_list_create_edebilmek_icin_ilgili_url_e_POST_methodu_ile_request_atar(String idPath, String id, String listsPath, String lists) {
        //'https://api.trello.com/1/lists?name={name}&idBoard=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken'

        System.out.println("boardId = " + boardId);

        // set url
        specification.given().pathParams(idPath, id, listsPath, lists)
                .contentType(ContentType.JSON)
                .queryParams("name", trelloApiTestData.getListName(), "idBoard", boardId,
                        "key", trelloApiTestData.getKey(), "token", trelloApiTestData.getToken());

        //Send the Request
        response = given(specification).when().post("/{" + idPath + "}/" + "{" + listsPath + "}");
        response.prettyPrint();
    }

    @When("Kullanıcı list id yi alir")
    public void kullanıcı_list_id_yi_alir() {
        jsonPath = response.jsonPath();
        listID = response.jsonPath().get("id");
        System.out.println("listID = " + listID);

    }

    @Then("Kullanıcı listin basari ile create edidldigini verfiy eder")
    public void kullanıcı_listin_basari_ile_create_edidldigini_verfiy_eder() {

        response.then().assertThat().statusCode(200);
    }

    @When("Kullanıcı card ccreate edebilmek icin ilgili url e POST metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_card_ccreate_edebilmek_icin_ilgili_url_e_POST_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards) {

        // "https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken"
        specification.pathParams(idPath, id, cardsPath, cards)
                .contentType(ContentType.JSON)
                .queryParams("idList", listID, "key", trelloApiTestData.getKey(), "token", trelloApiTestData.getToken()
                        , "name", trelloApiTestData.getCardName());
        // send request
        response = given(specification).when().post("/{" + idPath + "}/" + "{" + cardsPath + "}");
        response.prettyPrint();


    }


    @When("Kullanıcı card is yi alir")
    public void kullanıcı_card_is_yi_alir() {
        jsonPath = response.jsonPath();
        cardIDList.add(jsonPath.getString("id"));
        System.out.println("cardIDList = " + cardIDList);


    }

    @Then("Kullanıcı vard create edildigini verify eder")
    public void kullanıcı_vard_create_edildigini_verify_eder() {
        response.then().assertThat().statusCode(200);

    }

    @When("Kullanıcı update islemi iicn ilgili url ePUT metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_update_islemi_iicn_ilgili_url_ePUT_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards) {
        //'https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken
        Random random = new Random();
       // random.nextInt(0,2);  // 0 dahil 2 degil ---> 0, 1
        int randomIndex =random.nextInt(cardIDList.size());  // 0 ile size arasinda deger doner

        specification.pathParams(idPath,id,cardsPath,cards,"cardIdPath",cardIDList.get(randomIndex))
                .contentType(ContentType.JSON)
                .queryParams("key",trelloApiTestData.getKey(),"token",trelloApiTestData.getToken()
                        ,"name",trelloApiTestData.getCardName_01());
        // send request
        response = given(specification).when().put("/{" + idPath + "}/" + "{" + cardsPath + "}/"+"{cardIdPath}");
        response.prettyPrint();
    }

    @Then("Kullanıcı basarili bir sekilde cardlardan birini update ettigini verify eder")
    public void kullanıcı_basarili_bir_sekilde_cardlardan_birini_update_ettigini_verify_eder() {
        response.then().assertThat().statusCode(200);

    }

    @When("Kullanıcı delete islemi yapabilmek icin ilgili url e DELETE metodu ile request atar {string},{string},{string},{string},{string},{int}")
    public void kullanıcı_delete_islemi_yapabilmek_icin_ilgili_url_e_DELETE_metodu_ile_request_atar(String idPath, String id, String cardsPath, String cards, String cardIdPath, Integer cardsId) {
    // "https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken"
        specification.pathParams(idPath,id,cardsPath,cards,cardIdPath,cardIDList.get(cardsId))
                .contentType(ContentType.JSON)
                .queryParams("key",trelloApiTestData.getKey(),"token",trelloApiTestData.getToken()
                        );
        // send request
        response = given(specification).when().delete("/{" + idPath + "}/" + "{" + cardsPath + "}/"+"{"+cardIdPath+"}");
        response.prettyPrint();

    }

    @Then("Kullanıcı basarili bir sekilde cardalrin delete edildigini verfiy eder")
    public void kullanıcı_basarili_bir_sekilde_cardalrin_delete_edildigini_verfiy_eder() {
        response.then().assertThat().statusCode(200);


    }

    @When("Kullanıcı board delete islemi icin ilgili url e DELETE metodu ile request atar {string},{string},{string},{string}")
    public void kullanıcı_board_delete_islemi_icin_ilgili_url_e_DELETE_metodu_ile_request_atar(String idPath, String id, String boardsPath, String boards) {
    //https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"
        specification.pathParams(idPath,id,boardsPath,boards,"boardIdPath",boardId)
                .contentType(ContentType.JSON)
                .queryParams("key",trelloApiTestData.getKey(),"token",trelloApiTestData.getToken()
                );
        // send request
        response = given(specification).when().delete("/{" + idPath + "}/"+"{" + boardsPath + "}/"+"{boardIdPath}");

    }

    @Then("Kullanıcı basarili bir sekilde boardun delete edildigini verfiy eder")
    public void kullanıcı_basarili_bir_sekilde_boardun_delete_edildigini_verfiy_eder() {
        response.then().assertThat().statusCode(200);

    }


}
