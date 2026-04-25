package com.dikara;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class LoginTestRedAssured {



    @Test
    void getData (){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .log().all()
                .when()
                .then()
                .log().all()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue());

    }



    @Test
    void getDataResponse (){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

      Response response = given()
                .when()
                .get("/users");



        response
                .then()
                .statusCode(200)
                .body("size()", equalTo(10));


      int statusCode = response.getStatusCode();

        System.out.println(statusCode);

        Assertions.assertEquals(200, statusCode);


        String name = response.jsonPath().getString("[0].username");

        System.out.println(name);

        Assertions.assertEquals("Bret", name);

    }

    @Test
    void postData(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .contentType("application/json")
                .body("{\"name\":\"Dikara\",\"job\":\"QA Engineer\"}")
                .when()
                .post("/users");

        response.then().statusCode(201)
                .body("name", equalTo("Dikara") )
                .body("job", equalTo("QA Engineer"))
                .body("id", notNullValue())
                .log().all();

        String id = response.jsonPath().getString("id");

        Assertions.assertNotNull(id);

    }

}
