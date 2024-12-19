package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserListeEndpoint extends BaseApi
{
    String path = "/user/list";

    public Response request(String token)
    {
        return RestAssured.given()
                .header("Authorization","Bearer " + token)
                .get(path);
    }
}
