package test;

import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import pojo.BankDataPOJO;

import static io.restassured.RestAssured.*;

public class EndPointEmptyTest {

    /**
     * @Test1 > Verify the Endpoint is empty (If it has any data use the DELETE request to clean and
     * leave it empty)
     * @autor Alejandro Madrid
     */

    @Test
    @Parameters({"endpoint"})
    public void deleteTest(String endpoint) {

        Response responseGet = given().when().get(endpoint);

        BankDataPOJO[] endPointGet = given().when().get(endpoint).as(BankDataPOJO[].class);
        System.out.println("the endpoint length is: " + endPointGet.length);

        if (endPointGet.length != 0) {
            for (int i = 0; i < endPointGet.length; i++) {
                given().when().delete(endpoint + "/" + endPointGet[i].getId());
                System.out.println("id " + endPointGet[i].getId() +" has been deleted: ");
            }
        } else {
            Assert.assertEquals(endPointGet.length, 0);
            responseGet.then().assertThat().statusCode(200);
        }
    }
}


//        Assert.assertEquals(emptyEndPoint.length, 0);


//        System.out.println(emptyEndPoint[0].getName());
//        Assert.assertEquals(emptyEndPoint[0].getName(), "Maria");

//        //when
//        Response response = given().when().delete(endpoint);
//
//        response.then().extract().response();
//
//        //then
//        response.prettyPrint();

//        response.then().assertThat().statusCode(404);
