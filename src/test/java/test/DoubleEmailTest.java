package test;

import io.restassured.response.Response;
import org.testng.Assert;
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

        Response responseGet = given().when().get(endpoint);

        BankDataPOJO[] duplicateEmail = given().when().get(endpoint).as(BankDataPOJO[].class);

        for (int i = 1; i < duplicateEmail.length; i++) {
            for (int j = 0; j < duplicateEmail.length; j++) {

            }

        }


    }

}


//given

//when
//        Response response = given().when().get(endpoint);
//
//        response.then().extract().response();
//
//       // response.prettyPrint();
//
//        //then
//
//        EmptyEndPoint[] emptyEndPoint = response.getBody().as(EmptyEndPoint[].class);
//     System.out.println(emptyEndPoint);


//        EmptyEndPoint emptyEndPoint = response.getBody().as(EmptyEndPoint.class);
//        assertThat(emptyEndPoint.getId(), equalTo(id));


//        response.prettyPrint();

//        System.out.println(response.jsonPath().getString("Name"));