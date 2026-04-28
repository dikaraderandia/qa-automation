package com.dikara.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpecBuilderUtil {

    public  static ResponseSpecification success200(){

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("id", notNullValue())
                .build();

    }


    public  static ResponseSpecification success201(){

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectBody("id", notNullValue())
                .expectBody("name", notNullValue())
                .expectBody("job", notNullValue())
                .build();

    }

    public static ResponseSpecification userDetailSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("name", notNullValue())
                .expectBody("username", notNullValue())
                .expectBody("email", containsString("@"))
                .expectBody("address", notNullValue())
                .expectBody("phone", notNullValue())
                .expectBody("website", notNullValue())
                .expectBody("company", notNullValue())
                .build();
    }
}
