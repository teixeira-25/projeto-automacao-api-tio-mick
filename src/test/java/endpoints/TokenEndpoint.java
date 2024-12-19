package endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenEndpoint extends BaseApi
{
    //Colocando a URI/API em uma String
    String path = "/token";

    //Os parametros estao para facilitar o uso de diferentes emails e senhas
    public Response request(String email, String password)
    {
        // Transformando o payload de request em String
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