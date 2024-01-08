package apiutils;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;

import java.util.Map;

import static apiutils.APIResponseHandler.prettyPrint;

public class Requests {
    private APIRequestContext apiRequestContext;

    public Requests(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
    }

    RequestOptions postRequestOptions = RequestOptions.create()
            .setHeader("Content-Type", "application/json")
            .setHeader("Authorization", "Bearer 4e9f4925f7ebdebde3754b226b7ca5d81457888fbd31d447598470993edae622");

    RequestOptions putRequestOptions = RequestOptions.create()
            .setHeader("Content-Type", "application/json")
            .setHeader("Authorization", "Bearer 4e9f4925f7ebdebde3754b226b7ca5d81457888fbd31d447598470993edae622");

    RequestOptions patchRequestOptions = RequestOptions.create()
            .setHeader("Content-Type", "application/json")
            .setHeader("Authorization", "Bearer 4e9f4925f7ebdebde3754b226b7ca5d81457888fbd31d447598470993edae622");

    RequestOptions deleteRequestOptions = RequestOptions.create()
            .setHeader("Content-Type", "application/json")
            .setHeader("Authorization", "Bearer 4e9f4925f7ebdebde3754b226b7ca5d81457888fbd31d447598470993edae622");

    public static final String BASE_URL = "https://gorest.co.in/public/v2/";
    public static final String USER_ENDPOINT = "users";

    public APIResponse getRequest(String endpoint, int statusCode) {
        APIResponse apiResponse = apiRequestContext.get(BASE_URL + endpoint);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse getRequest(String endpoint, RequestOptions queryParameter, int statusCode) {
        APIResponse apiResponse = apiRequestContext.get(BASE_URL + endpoint, queryParameter);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse postRequest(String endpoint, Map<String, Object> payload, int statusCode) {
        APIResponse apiResponse = apiRequestContext.post(BASE_URL + endpoint, postRequestOptions.setData(payload));
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse postRequest(String endpoint, String payload, int statusCode) {
        APIResponse apiResponse = apiRequestContext.post(BASE_URL + endpoint, postRequestOptions.setData(payload));
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse postRequest(String endpoint, Object payload, int statusCode) {
        APIResponse apiResponse = apiRequestContext.post(BASE_URL + endpoint, postRequestOptions.setData(payload));
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse putRequest(String endpoint, Object payload, int statusCode) {
        APIResponse apiResponse = apiRequestContext.put(BASE_URL + endpoint, putRequestOptions.setData(payload));
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse putRequest(String endpoint, String payload, int statusCode) {
        APIResponse apiResponse = apiRequestContext.put(BASE_URL + endpoint, putRequestOptions.setData(payload));
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse patchRequest(String endpoint, Object payload, int statusCode) {
        APIResponse apiResponse = apiRequestContext.patch(BASE_URL + endpoint, patchRequestOptions.setData(payload));
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }

    public APIResponse deleteRequest(String endpoint, int statusCode) {
        APIResponse apiResponse = apiRequestContext.delete(BASE_URL + endpoint, deleteRequestOptions);
        prettyPrint(apiResponse);
        Assert.assertEquals(apiResponse.status(), statusCode);
        return apiResponse;
    }
}
