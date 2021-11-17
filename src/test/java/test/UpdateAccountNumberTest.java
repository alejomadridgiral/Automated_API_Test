package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.BankDataPOJO;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateAccountNumberTest {

    /**
     * @Test4 > Add a test to update an existing AccountNumber
     *
     *
     * @autor Alejandro Madrid
     */

    @Test
    @Parameters({"endpoint"})
    public void updateTest(String endpoint){

        Response updateAccount;

        BankDataPOJO setUpdateAccount = new BankDataPOJO();
        setUpdateAccount.setAccountNumber("66587043663");

        updateAccount = given().contentType(ContentType.JSON).body(setUpdateAccount).when().put(endpoint + "/" + 1);

        updateAccount.then().assertThat().statusCode(200);

        updateAccount.prettyPrint();

    }
}

//      Given
//        String endpoint = "https://6192a21bd3ae6d0017da8217.mockapi.io/Users/6";
//
//        Response response;
//        Map<String, String> Users = new HashMap<String, String>();
//        Users.put("Name", "Giraldillo");
//        Users.put("LasName", "Apellido de Jaramillo");
//        Users.put("AccountNumber", "28471380");
//        Users.put("Amount", "681.49");
//        Users.put("TransactionType", "invoice");
//        Users.put("Email", "Lamar6@yahoo.com");
//        Users.put("Active", "false");
//        Users.put("Country", "Indonesia");
//        Users.put("Telephone", "(563) 449-1300 x50151");
//
//        //When
//        response = given().contentType("application/json").body(Users).when().put(endpoint);
//
////      Then
//
//
//
//        response.prettyPrint();
//
////        response.then().assertThat().statusCode(200);