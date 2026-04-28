package com.dikara.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

//    @BeforeAll
//    static void BaseTest(){
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//    }

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        System.out.println("Setup API");
    }
}
