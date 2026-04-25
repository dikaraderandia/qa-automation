package com.dikara.test;

import com.dikara.api.UserAPI;
import com.dikara.dto.request.UserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class UserTest extends BaseTest {

    UserAPI userAPI = new UserAPI();


    @Test
    void getUsers (){

        Response response = userAPI.getUsers();
        response.then()
                .statusCode(200)
                .body("id", everyItem(notNullValue()))
                .body("name", everyItem(notNullValue()))
                .body("email", everyItem(notNullValue()))
                .body("phone", everyItem(notNullValue()))
                .body("address", everyItem(notNullValue()))
                .body("website", everyItem(notNullValue()))
                .body("company", everyItem(notNullValue()))
                .log().all();

    }

    @Test
    void getUserDetail (){

        Response response = userAPI.getUserDetail("1");
        response.then()
                .statusCode(200)
                .body("name", equalTo("Leanne Graham"))
                .body("username", equalTo("Bret"))
                .body("email", contains("@"))
                .body("id", equalTo(1))
                .body("address", notNullValue())
                .body("phone", notNullValue())
                .body("website", notNullValue())
                .body("company", notNullValue())
                .log().all();


    }

    @Test
    void createUser(){
        UserRequest user = new UserRequest("Derren", "balita");
        Response response = userAPI.createUser(user);
        response.then()
                .statusCode(201)
                .body("name", equalTo("Derren"))
                .body("job", equalTo("balita"))
                .body("id", notNullValue())
                .log().all();
    }
}
