package endpoints;

import io.restassured.RestAssured;

public class BaseApi {
    public BaseApi()
    {
        // URL ou BaseURI         String da URL
        RestAssured.baseURI="http://bug-api.dev.hill";
    }
}
