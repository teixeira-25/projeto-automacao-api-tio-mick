package scenarios;

import endpoints.TokenEndpoint;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class TokenTeste
{

    //Criando um objeto TokenEndpoint

    TokenEndpoint endpoint = new TokenEndpoint();

    @Test
    public void Teste02()
    {

        //Criando um objeto Response usando o objeto do TokenEndpoint criado

        Response response = endpoint.request("root@local.dev", "root");

        //Transformando o payload da response em string

        String bodyString = response.body().asString();

        //Manipulando essa String do Jason em um objeto

        JSONObject obj = new JSONObject(bodyString);

        String token = obj.getString("access_token");
        System.out.println(token);

        //Validando se o status é o correto

        Assert.assertEquals(202,response.statusCode());

    }
}