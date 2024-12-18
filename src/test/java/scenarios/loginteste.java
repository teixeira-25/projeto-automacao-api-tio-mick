package scenarios;

import endpoints.LoginEndpiont;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class loginteste
{
    LoginEndpiont endpiont = new LoginEndpiont();

    @Test
    public void teste01()
    {
        Response response = endpiont.request("eve.holt@reqres.in", "cityslicka");
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());
    }
}
