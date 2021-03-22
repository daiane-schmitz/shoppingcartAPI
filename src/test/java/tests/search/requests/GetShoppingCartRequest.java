package tests.search.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetShoppingCartRequest {


    public Response returnJson(){
        return given()
                .header("Content-Type", "application/json")
                .get()
                .prettyPeek();
    }

}
