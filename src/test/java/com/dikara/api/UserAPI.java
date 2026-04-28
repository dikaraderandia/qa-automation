package com.dikara.api;

import com.dikara.dto.request.UserRequest;
import com.dikara.test.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserAPI  {

//    public UserAPI(){
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//    }

    private RequestSpecification request;


    public UserAPI(RequestSpecification request) {
        System.out.println("Masuk API, request: " + request);
        this.request = request;
    }

    public Response createUser (UserRequest user){
        //System.out.println("BASE URI DI API: " + request.spec(gi));
        return request
                .body(user)
                .post("/users");
    }

    public Response getUsers(){
        //System.out.println("BASE URI DI API: " + RestAssured.baseURI);
        return request
                .get("/users");
    }

    public Response getUserDetail(String id){
        return request
                .get("/users/" + id);
    }
}
