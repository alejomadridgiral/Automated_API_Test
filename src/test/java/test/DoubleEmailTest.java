package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BankDataPOJO;

import static io.restassured.RestAssured.given;

public class DoubleEmailTest {

    /**
     *
     *
     *
     *
     */

    @Test
    public void getTest(){
        //given
        String endpoint = "https://6192a21bd3ae6d0017da8217.mockapi.io/Users";

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
    }

}
