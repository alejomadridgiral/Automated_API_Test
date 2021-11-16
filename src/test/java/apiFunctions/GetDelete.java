package apiFunctions;

import pojo.BankDataPOJO;

import static io.restassured.RestAssured.given;

public class GetDelete {

    String endpoint = "https://6192a21bd3ae6d0017da8217.mockapi.io/Users";

    public void isEmptyThenDelete() {

        BankDataPOJO[] emptyEndPoint = given().when().get(endpoint).as(BankDataPOJO[].class);
        System.out.println(emptyEndPoint.length);

        if (emptyEndPoint.length == 0) {
            System.out.println("place test");
        } else {
            for (int i = 1; i < emptyEndPoint.length; i++) {
                given().when().delete(emptyEndPoint[i].getId());
//            Assert.assertEquals(emptyEndPoint.length, 0);
            }
        }

    }

}