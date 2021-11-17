package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.BankDataPOJO;


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

        for (int i = 1; i <= 10; i++) {
            if(checkEmail[i].getEmail().equals(checkEmail[i-1].getEmail())){
                System.out.println("there is a duplicate email account please change the email " + checkEmail[i].getEmail()+ " " + checkEmail[i-1].getEmail());
            } else {
                System.out.println("the post is ok to continue after checking the email");
            }
        }

    }
}


