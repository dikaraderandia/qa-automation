package com.dikara.test;

import com.dikara.api.UserAPI;
import com.dikara.data.UserDataProvider;
import com.dikara.dto.request.UserRequest;
import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DataDrivenTest extends BaseTest {

    UserAPI userAPI = new UserAPI();

//    @DataProvider(name = "userData")
//    public Object[][] userData() {
//        return new Object[][]{
//                { new UserRequest("Dikara", "QA"), 201 },
//                { new UserRequest("Rizka", ""), 201 }, // API tetap 201
//                { new UserRequest("", "Teknik Sipil"), 201 }
//        };
//    }


   @Test (dataProvider = "userData", dataProviderClass = UserDataProvider.class)
        public void createUserDataDriven(UserRequest user, int expectedStatus){

            Response response = userAPI.createUser(user);

            response.then().statusCode(expectedStatus)
                    .body("id", notNullValue());

        System.out.println("Tested: " + user.getName() + " | " + user.getJob());

        }


    @Test
    void createMultipleUsers(){



        UserRequest [] users = {
                new UserRequest("Dika","QA"),
                new UserRequest("Derren", "Teknik Sipil"),
                new UserRequest("Rizka", "IT Governance")
        };

        for (UserRequest userReq: users){
            Response response = userAPI.createUser(userReq);
            response.then()
                    .statusCode(201)
                    .body("name", equalTo(userReq.getName()))
                    .body("job", equalTo(userReq.getJob()))
                    .body("id", notNullValue())
                    .log().all();

            System.out.println("Created User: "+ userReq.getName());
        }

    }

    @Test
    void createMultipleUsersNegativeCaseAdjustmentScenario(){
        UserRequest[] users = {
                new UserRequest("Dikara", "QA"),
                new UserRequest("Rizka", ""),
                new UserRequest("", "Teknik Sipil")
        };

        for (UserRequest user: users){
            Response response = userAPI.createUser(user);


                response.then()
                        .statusCode(201)
                        .body("id", notNullValue());

                response.then()
                        .body("name", equalTo(user.getName()))
                        .body("job", equalTo(user.getJob()))
                        .body("id", notNullValue());

            System.out.println("Tested User: "+ user.getName());
        }


    }


    @Test
    void createMultipleUsersNegativeCase(){
        UserRequest[] users = {
                new UserRequest("Dikara", "QA"),
                new UserRequest("Rizka", ""),
                new UserRequest("", "Teknik Sipil")
        };

        for (UserRequest user: users){
            Response response = userAPI.createUser(user);

            if (user.getName().isEmpty()||user.getJob().isEmpty()){
                int resp = response.getStatusCode();

                Assert.assertEquals(400, resp);
            }

            else{
                response.then().statusCode(201);
            }

            System.out.println("Tested User: "+ user.getName());
        }


    }
}
