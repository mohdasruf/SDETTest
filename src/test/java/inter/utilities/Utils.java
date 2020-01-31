package inter.utilities;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Utils {
    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;
    public static RequestSpecification request;

    //Sets Base URI
    public static void setBaseURI() {
        baseURI = "https://jsonplaceholder.typicode.com/";
        request = RestAssured.given();
    }

    //Created search query path
    public static void createSearchQueryPath(String searchTerm, String param, String paramValue) {
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }

    public static void request() {
        request = given();
    }
}