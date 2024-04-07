package Task;

import baseURL.SwapiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Homework3  extends SwapiBaseUrl {
        /*

    Given
	   	     https://swapi.dev/api/vehicles/4
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
   {
    "name": "Sand Crawler",
    "model": "Digger Crawler",
    "manufacturer": "Corellia Mining Corporation",
    "cost_in_credits": "150000",
    "length": "36.8 ",
    "max_atmosphering_speed": "30",
    "crew": "46",
    "passengers": "30",
    "cargo_capacity": "50000",
    "consumables": "2 months",
    "vehicle_class": "wheeled",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/5/"
    ],
    "created": "2014-12-10T15:36:25.724000Z",
    "edited": "2014-12-20T21:30:21.661000Z",
    "url": "https://swapi.dev/api/vehicles/4/"
}

     */
    /*
     1-Set the URL
     2-Set the expected data
     3-Send the request
     4-Do the assertion
     */


    @Test
    public void get07(){
        //1-Set the URL

        specification.pathParams("vehiclesPath", "vehicles",
                "idPath", "4");

        // 2-Set the expected data --> Her zaman iceriden (en gomulu data yapısından) olusturarak
        /*
        "films": [
                        "https://swapi.dev/api/films/1/",
                        "https://swapi.dev/api/films/5/"
                    ],
         */
        List<String> filmsList= new ArrayList<>();
        filmsList.add("https://swapi.dev/api/films/1/");
        filmsList.add("https://swapi.dev/api/films/5/");

        //"pilots": [],

        List<String> pilotsList= new ArrayList<>();
        System.out.println("pilotsList = " + pilotsList);

        /*
            "name": "Sand Crawler",
            "model": "Digger Crawler",
            "manufacturer": "Corellia Mining Corporation",
            "cost_in_credits": "150000",
            "length": "36.8 ",
            "max_atmosphering_speed": "30",
            "crew": "46",
            "passengers": "30",
            "cargo_capacity": "50000",
            "consumables": "2 months",
            "vehicle_class": "wheeled",
            "created": "2014-12-10T15:36:25.724000Z",
            "edited": "2014-12-20T21:30:21.661000Z",
            "url": "https://swapi.dev/api/vehicles/4/"
         */
        Map<String, Object> expectedDataMap= new HashMap<>();
        expectedDataMap.put("name", "Sand Crawler");
        expectedDataMap.put("model", "Digger Crawler");
        expectedDataMap.put("manufacturer", "Corellia Mining Corporation");
        expectedDataMap.put( "cost_in_credits", "150000");
        expectedDataMap.put( "length", "36.8 ");
        expectedDataMap.put( "max_atmosphering_speed", "30");
        expectedDataMap.put("crew", "46");
        expectedDataMap.put("passengers", "30");
        expectedDataMap.put("cargo_capacity", "50000");
        expectedDataMap.put("consumables", "2 months");
        expectedDataMap.put("vehicle_class", "wheeled");
        expectedDataMap.put("pilots", pilotsList);
        expectedDataMap.put("films", filmsList);
        expectedDataMap.put("created", "2014-12-10T15:36:25.724000Z");
        expectedDataMap.put("edited", "2014-12-20T21:30:21.661000Z");
        expectedDataMap.put("url", "https://swapi.dev/api/vehicles/4/");

        System.out.println("expectedDataMap = " + expectedDataMap);


        //3-Send the request

        Response response= given().spec(specification).when().get("/{vehiclesPath}/{idPath}");
        response.prettyPrint();

        //4-Do the assertion
               // 1.way:
/*
        response.then().assertThat().statusCode(200).
                body("name", equalTo(expectedDataMap.get("name")),
                "model", equalTo(expectedDataMap.get("model")), "manufacturer",
                equalTo(expectedDataMap.get("manufacturer")),
                "cost_in_credits", equalTo(expectedDataMap.get("cost_in_credits")),
                "length", equalTo(expectedDataMap.get("length")),
                "max_atmosphering_speed", equalTo(expectedDataMap.get("max_atmosphering_speed")),
                "crew", equalTo(expectedDataMap.get("crew")),
                "passengers", equalTo(expectedDataMap.get("passengers")),
                "cargo_capacity", equalTo(expectedDataMap.get("cargo_capacity")),
                "consumables", equalTo(expectedDataMap.get("consumables")),
                "vehicle_class", equalTo(expectedDataMap.get("vehicle_class")),
                "pilots", equalTo(expectedDataMap.get("pilots")),
                "films", equalTo(expectedDataMap.get("films")),
                "created", equalTo(expectedDataMap.get("created")),
                "edited", equalTo(expectedDataMap.get("edited")),
                "url", equalTo(expectedDataMap.get("url")));

 */

        //2. way:

        Map<String, Object> actualData= response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedDataMap, actualData);

    }
}
