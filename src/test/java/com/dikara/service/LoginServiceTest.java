package com.dikara.service;

import com.dikara.dto.response.LoginResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {



    @Test
    void testLoginResponse (){

        String token = "7b7159d1-01a1-4a25-b997-a3700c109554";
        int statusCode = 200;
        String userId = "1234";

        if (token.isEmpty() && statusCode != 200 && userId.isEmpty()){
            System.out.println("TEST FAILED");
        } else {
            System.out.println("TEST PASSED");
        }

    }


    @Test
    void testLoginNegativeResponse (){

        int statusCode = 401;
        String message = "Invalid credentials";

        if (statusCode == 401 && message.equals("Invalid credentials")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


    }


    @Test
    void testLoginPasswordEmptyResponse (){

        LoginResponse loginResponse = new LoginResponse(400, "password required");

        int expectedStatusCode = 400;
        String expectedMessage = "password required";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());


    }


    @Test
    void testLoginEmailEmptyResponse (){

        LoginResponse loginResponse = new LoginResponse(400, "email required");

        int expectedStatusCode = 400;
        String expectedMessage = "email required";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());


    }

    @Test
    void testLoginEmailRegistered (){
        LoginResponse loginResponse = new LoginResponse(401, "email is not registered");

        int expectedStatusCode = 401;
        String expectedMessage = "email is not registered";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());
    }


    @Test
    void testLoginFieldPasswordNotExisted (){
        LoginResponse loginResponse = new LoginResponse(400, "password required");

        int expectedStatusCode = 400;
        String expectedMessage = "password required";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());
    }


    @Test
    void testLoginFieldPasswordIsNull (){
        LoginResponse loginResponse = new LoginResponse(400, "password required");

        int expectedStatusCode = 400;
        String expectedMessage = "password required";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());
    }



    @Test
    void testLoginWrongEmailFormat (){
        LoginResponse loginResponse = new LoginResponse(400, "wrong email format");

        int expectedStatusCode = 400;
        String expectedMessage = "wrong email format";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());
    }


    @Test
    void testLoginWrongPassword (){
        LoginResponse loginResponse = new LoginResponse(400, "wrong email format");

        int expectedStatusCode = 400;
        String expectedMessage = "invalid credentials";

        Assertions.assertEquals(expectedStatusCode, loginResponse.getStatusCode());
        Assertions.assertEquals(expectedMessage, loginResponse.getMessage());
    }


}
