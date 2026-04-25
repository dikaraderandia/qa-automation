package com.dikara.test;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void BaseTest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
