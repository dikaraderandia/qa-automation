package com.dikara.test;

import com.dikara.api.UserAPI;
import com.dikara.dto.request.UserRequest;
import com.dikara.spec.ResponseSpecBuilderUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class UserTest extends BaseTest {




    @Test
    void getUsers (){
        System.out.println("Thread: " + Thread.currentThread().getId());
        UserAPI userAPI = new UserAPI(getRequest());
        Response response = userAPI.getUsers();
        response.then().spec(ResponseSpecBuilderUtil.success200())
                .body("size()", greaterThan(0));
               // .log().all();

    }

    @Test
    void getUserDetail (){
        System.out.println("Thread: " + Thread.currentThread().getId());
        UserAPI userAPI = new UserAPI(getRequest());

        Response response = userAPI.getUserDetail("1");
        response.then()
                .spec(ResponseSpecBuilderUtil.userDetailSpec())
                .body("name", equalTo("Leanne Graham"))
                .body("username", equalTo("Bret"));
                //.log().all();


    }

    @Test
    void createUser(){
        System.out.println("Thread: " + Thread.currentThread().getId());
        UserAPI userAPI = new UserAPI(getRequest());
        UserRequest user = new UserRequest("Derren", "balita");
        Response response = userAPI.createUser(user);
        response.then()
                .spec(ResponseSpecBuilderUtil.success201())
                .body("name", equalTo("Derren"))
                .body("job", equalTo("balita"));
                //.log().all();
    }

    @Test(groups={"positive"})
    public void createUserTest (){
        System.out.println("Thread: " + Thread.currentThread().getId());
        UserAPI userAPI = new UserAPI(getRequest());
        UserRequest userRequest = new UserRequest("Charlie", "Baby Sitter");
        Response response = userAPI.createUser(userRequest);

        response.then()
                .spec(ResponseSpecBuilderUtil.success201());
    }

    @Test(groups={"positive"})
    public void getUsertest(){
        System.out.println("Thread: " + Thread.currentThread().getId());
        UserAPI userAPI = new UserAPI(getRequest());

        Response response =userAPI.getUsers();

        response.then().spec(ResponseSpecBuilderUtil.success200());

    }

    @Test
    public void testSimple(){
        System.out.println("Thread: " + Thread.currentThread().getId());
        System.out.println("BASE URI: " + RestAssured.baseURI);
        System.out.println("INI TEST SIMPLE");
    }


}
