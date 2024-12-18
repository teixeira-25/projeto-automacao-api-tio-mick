package scenarios;

import endpoints.TokenEndpoint;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class TokenTeste
{
    TokenEndpoint endpoint = new TokenEndpoint();

    @Test
    public void Teste02()
    {
        Response response = endpoint.request("root@local.dev", "root");
//        System.out.println(response.statusCode());
//        System.out.println(response.getBody().asString());
//        Assert.assertEquals(202,response.statusCode());

        String bodyString = response.body().asString();

        JSONObject obj = new JSONObject(bodyString);

        String token = obj.getString("access_token");
        System.out.println(token);

    }
}