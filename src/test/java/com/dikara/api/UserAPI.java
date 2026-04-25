package com.dikara.api;

import com.dikara.dto.request.UserRequest;
import com.dikara.test.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI  {



    public Response createUser (UserRequest user){
        System.out.println(RestAssured.baseURI);
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users");
    }

    public Response getUsers(){
        return given()
                .when()
                .get("/users");
    }

    public Response getUserDetail(String id){
        return given()
                .when()
                .get("/users/"+id);
    }
}
