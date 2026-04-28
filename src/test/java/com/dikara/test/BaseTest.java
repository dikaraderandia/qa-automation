package com.dikara.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;
//import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

//    @BeforeAll
//    static void BaseTest(){
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//    }

    //protected RequestSpecification request;

    String baseUrl = "https://jsonplaceholder.typicode.com";

//    @BeforeMethod
//    public void setup() {
//        request = given()
//                .spec(new RequestSpecBuilder()
//                        .setBaseUri(baseUrl)
//                        .setContentType("application/json")
//                        .build());
//
//        System.out.println("BASE URI: " + baseUrl);
//      //  request.log().all();
//    }



        protected RequestSpecification getRequest() {
            return given()
                    .spec(new RequestSpecBuilder()
                            .setBaseUri("https://jsonplaceholder.typicode.com")
                            .setContentType("application/json")
                            .build());
        }

}
