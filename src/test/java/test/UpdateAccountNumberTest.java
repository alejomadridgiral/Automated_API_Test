package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.BankDataPOJO;

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
