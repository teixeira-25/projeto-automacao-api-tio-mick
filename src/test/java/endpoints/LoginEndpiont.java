package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndpiont
{
    String path = "/api/login";

    public Response request(String email, String password)
    {
        RestAssured.baseURI = "https://reqres.in";
        String payload = "{\n" +
                "    \"email\": \""+ email +"\",\n" +
                "    \"password\": \""+ password +"\"\n" +
                "}";
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(path);
    }
}
