package tests.search.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.base.tests.BaseTest;
import tests.search.requests.GetShoppingCartRequest;
import utils.Utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class GetShoppingCartTests extends BaseTest {

    GetShoppingCartRequest getShoppingCartRequest = new GetShoppingCartRequest();

    @Test
    @DisplayName("Body > 0")
    public void retuningJson() throws Exception{
        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @DisplayName("Body matches JSON")
    public void getJson() throws Exception{
        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .assertThat()
                .body(matchesJsonSchema(new File(Utils.getContractsBasePath("search", "cart"))));
    }

    @Test
    @DisplayName("Get Total Shipping")
    public void getTotalShipping() throws Exception{
        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("total_shipping", equalTo("2.00"));
    }

    @Test
    @DisplayName("Size = 6")
    public void sizeJson() throws Exception{
        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("size()", equalTo(6));
    }

    @Test
    @DisplayName("Get Color")
    public void getColors() throws Exception{

        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("color", hasItem("Black"));
    }

    @Test
    @DisplayName("Get Size")
    public void getSizes() throws Exception{

        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("size", hasItem("S"));
    }

    @Test
    @DisplayName("Get Sku")
    public void getSku() throws Exception{

        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("sku", hasItem("demo_2"));
    }

    @Test
    @DisplayName("Get Price")
    public void getPrice() throws Exception{

        getShoppingCartRequest.returnJson().then()
                .statusCode(200)
                .time(lessThan(2L), TimeUnit.SECONDS)
                .body("price", hasItem("16.51"));
    }
}
