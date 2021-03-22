package tests.base.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "http://5d9cc58566d00400145c9ed4.mockapi.io/shopping_cart";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
