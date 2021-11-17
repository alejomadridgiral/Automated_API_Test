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

        /**
         * Step 1 create 10 ramdom data
         */


        for (int i = 1; i <= 10 ; i++) {
            BankDataPOJO fakeData = new BankDataPOJO();
            Response responsePost;
            responsePost = given().contentType(ContentType.JSON).body(fakeData).when().post(endpoint);
            responsePost.then().assertThat().statusCode(201);
        }

        Response response = given().when().get(endpoint);
        response.prettyPrint();

        /**
         *
         * verification for avoiding duplicate email accounts
         *
         */

        BankDataPOJO[] checkEmail = given().when().get(endpoint).as(BankDataPOJO[].class);

        for (int i = 1; i < 10; i++) {
            if(checkEmail[i].getEmail() == checkEmail[i-1].getEmail()){
                System.out.println("there is a duplicate email account please change the email " + checkEmail[i].getEmail()+ " " + checkEmail[i-1].getEmail());
            } else {
                System.out.println("the post is ok, please continue");
            }
        }

    }
}

//    BankDataPOJO fakerData = new BankDataPOJO();

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

//        BankDataPOJO[] fakeData = given().when().get(endpoint).as(BankDataPOJO[].class);
//
////        for (int i = 1; i <= 10 ; i++) {
////
////            if(fakeData[i].getEmail() != fakeData[i-1].getEmail()){
////                given().contentType(ContentType.JSON).body(fakeData[i]).when().post(endpoint);
////            } else {
////                System.out.println("Please check your email as it is duplicate");
////            }
////
////
////        }

//
//        public static BankDataPOJO checkEmail(){
//            for (int i = 1; i <= 10 ; i++) {
//
//                if(fakerData.getEmail() != fakerData.getEmail())
//                    given().contentType(ContentType.JSON).body(fakerData).when().post(endpoint);
//
//            }
////
//        }
////
