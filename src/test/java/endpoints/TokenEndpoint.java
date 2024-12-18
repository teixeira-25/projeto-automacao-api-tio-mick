package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenEndpoint
{
    String path = "/token";

    public Response request(String email, String password)
    {
        RestAssured.baseURI="http://bug-api.dev.hill";
        String payload = "{\n" +
                "\t\"email\": \"" + email + "\",\n" +
                "\t\"password\": \"" + password + "\"\n" +
                "}";

        return RestAssured.given()
                .header("Content-Type","application/json")
                .body(payload)
                .post(path);
    }
}
