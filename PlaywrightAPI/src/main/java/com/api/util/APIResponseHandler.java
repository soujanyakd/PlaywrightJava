package com.api.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;

import java.io.IOException;

public class APIResponseHandler {

    public static JsonNode getResponse(APIResponse apiResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse;
        try {
            jsonResponse = objectMapper.readTree(apiResponse.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonResponse;
    }

    public static void prettyPrint(APIResponse apiResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
            System.out.println(jsonResponse.toPrettyString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
