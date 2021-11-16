package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.BankDataPOJO;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class InitializeBankAccountTest {

    @Test
    @Parameters({"endpoint"})
    public void postTest(String endpoint){

        /**
         * @Test2 > Initialize the POJO with 10 random data (Use the minimal Requirements). Also, make
         * a code verification for avoiding duplicate email accounts. Then, perform the POST request.
         *
         * @autor Alejandro Madrid
         */

        BankDataPOJO fakerData = new BankDataPOJO();

        for (int i = 1; i <= 10 ; i++) {

            given().contentType(ContentType.JSON).body(fakerData).when().post(endpoint);

            //            for (int j = 0; j < fakerData; j++) {

//            }
        }

        Response response = given().when().get(endpoint);
        response.prettyPrint();
    }
}

//        Response response;
//
//        Map<String, String> Users = new HashMap<String, String>();
//        Users.put("Name", "Jaramillo");
//        Users.put("LasName", "Apellido de Jaramillo");
//        Users.put("AccountNumber", "28471380");
//        Users.put("Amount", "681.49");
//        Users.put("TransactionType", "invoice");
//        Users.put("Email", "Lamar6@yahoo.com");
//        Users.put("Active", "false");
//        Users.put("Country", "Indonesia");
//        Users.put("Telephone", "(563) 449-1300 x50151");
//
////      When
//        response = given().contentType("application/json").body(Users).when().post(endpoint);
//
////      Then
//        response.prettyPrint();