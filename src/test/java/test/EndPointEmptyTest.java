package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;
import pojo.BankDataPOJO;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class EndPointEmptyTest {

    @Test
    public void deleteTest(){
        //given
        String endpoint = "https://6192a21bd3ae6d0017da8217.mockapi.io/Users/7";
        String endpoint1 = "https://6192a21bd3ae6d0017da8217.mockapi.io/Users";

        System.out.println(endpoint1.isEmpty());
        //when
        Response response = given().when().delete(endpoint);

        response.then().extract().response();

        //then
        response.prettyPrint();

        response.then().assertThat().statusCode(404);

    }

}
