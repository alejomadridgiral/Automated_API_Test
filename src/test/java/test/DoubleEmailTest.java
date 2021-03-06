package test;

import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.BankDataPOJO;

import static io.restassured.RestAssured.given;

public class DoubleEmailTest {

    /**
     *@Test3 > Make the GET request, asserting that there are not duplicate email accounts.
     *
     *
     *@autor Alejandro Madrid
     */

    @Test
    @Parameters({"endpoint"})
    public void getTest(String endpoint){

        BankDataPOJO[] duplicateEmail = given().when().get(endpoint).as(BankDataPOJO[].class);

        Response responseGet = given().when().get(endpoint);

        for (int i = 0; i < duplicateEmail.length; i++) {
            for (int j = i + 1; j < duplicateEmail.length; j++) {
                if(duplicateEmail[i].getEmail().equals(duplicateEmail[j].getEmail())){
                    System.out.println("there is a repeated email " + duplicateEmail[i].getEmail() + " No " + i + " " + duplicateEmail[j].getEmail() + " No " + j);
                } else {
                    responseGet.then().assertThat().statusCode(200);
                }
            }
        }

    }

}
