package scenarios;

import endpoints.TokenEndpoint;
import endpoints.UserListeEndpoint;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class BugAPITeste
{
    //Criando um objeto TokenEndpoint
    TokenEndpoint tokenEndpoint = new TokenEndpoint();
    UserListeEndpoint usersEndpoint = new UserListeEndpoint();

    // Variaveis de teste
    String token;

    @Test
    public void teste_gerar_token()
    {
        //Criando um objeto Response usando o objeto do TokenEndpoint criado
        Response response = tokenEndpoint.request("root@local.dev", "root");

        //Transformando o payload da response em string
        String bodyString = response.body().asString();

        //Manipulando essa String do Jason em um objeto
        JSONObject obj = new JSONObject(bodyString);

        token = obj.getString("access_token");
        System.out.println(token);

        //Validando se o status é o correto
        Assert.assertEquals(202,response.statusCode());
    }

    @Test
    public void teste_listar_usuarios()
    {
        this.teste_gerar_token();
        Response response = usersEndpoint.request(token);
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());
    }
}