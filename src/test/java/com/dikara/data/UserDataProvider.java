package com.dikara.data;

import com.dikara.dto.request.UserRequest;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name= "userData")
    public Object[][] userData() {
       return new Object[][]{
        { new UserRequest("Dikara", "QA"), 201 },
        { new UserRequest("Rizka", ""), 201 }, // API tetap 201
        { new UserRequest("", "Teknik Sipil"), 201 }
    };
    }
}
