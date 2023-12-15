package com.api.test;

import com.api.util.JsonFileHandler;
import com.api.util.Requests;
import com.api.util.TestBase;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pojoResource.CreateUser;

import java.util.HashMap;
import java.util.Map;

public class PostAPITest extends TestBase {

    @Test
    public void postAPIRequestTest() {
        Map<String, Object> postData = new HashMap<>();
        postData.put("name", "automation Test");
        postData.put("email", "automationTest1273@test.com");
        postData.put("gender", "female");
        postData.put("status", "inactive");
        Requests requests = new Requests(getApiRequestContext());
        requests.postRequest(Requests.USER_ENDPOINT, postData, 201);
    }

    @Test
    public void postAPIRequestUsingStringTest() {
      /*  String payload = "{\n" +
                "  \"name\" : \"automation Test\",\n" +
                "  \"email\" : \"automationTest5460@test.com\",\n" +
                "  \"gender\" : \"female\",\n" +
                "  \"status\" : \"inactive\"\n" +
                "}";*/
        JSONObject payload = JsonFileHandler.convertJsonFileToJsonObject("createUser.json");
        payload.put("name", "Automation");
        payload.put("email", "automation@gmail.com");

        Requests requests = new Requests(getApiRequestContext());
        requests.postRequest(Requests.USER_ENDPOINT, payload.toString(), 201);
    }

    @Test
    public void postAPIRequestUsingJsonTest() {
        CreateUser createUser = CreateUser.getInstance();
        createUser.setName("automation Test1");
        createUser.setEmail("automationTest54ty0@test.com");
        createUser.setGender("male");
        createUser.setStatus("active");

        Requests requests = new Requests(getApiRequestContext());
        requests.postRequest(Requests.USER_ENDPOINT, createUser, 201);
    }
}
