package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class InitializeBankAccountTest {

    @Test
    public void postTest(){
        String endpoint = "https://6192a21bd3ae6d0017da8217.mockapi.io/Users";

        Response response;

        Map<String, String> Users = new HashMap<String, String>();
        Users.put("Name", "Jaramillo");
        Users.put("LasName", "Apellido de Jaramillo");
        Users.put("AccountNumber", "28471380");
        Users.put("Amount", "681.49");
        Users.put("TransactionType", "invoice");
        Users.put("Email", "Lamar6@yahoo.com");
        Users.put("Active", "false");
        Users.put("Country", "Indonesia");
        Users.put("Telephone", "(563) 449-1300 x50151");

//      When
        response = given().contentType("application/json").body(Users).when().post(endpoint);

//      Then
        response.prettyPrint();
    }
}
