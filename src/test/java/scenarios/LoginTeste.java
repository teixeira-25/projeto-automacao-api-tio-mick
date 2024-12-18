package scenarios;

import endpoints.LoginEndpiont;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class LoginTeste
{
    LoginEndpiont endpiont = new LoginEndpiont();

    @Test
    public void teste01()
    {
        Response response = endpiont.request("eve.holt@reqres.in", "cityslicka");
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());

        String bodyString = response.body().asString();

        JSONObject obj = new JSONObject(bodyString);

        String token = obj.getString("token");
        System.out.println(token);
    }
}
