package com.api.test;

import com.api.util.APIResponseHandler;
import com.api.util.Requests;
import com.api.util.TestBase;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetAPITest extends TestBase {

    @Test
    public void getAPIRequestWithQueryParameterTest() {
        RequestOptions queryParameter = RequestOptions.create().setQueryParam("id", "5184385")
                .setQueryParam("status", "inactive");
        Requests requests = new Requests(getApiRequestContext());
        APIResponse apiResponse = requests.getRequest(Requests.USER_ENDPOINT, queryParameter, 200);
        Assert.assertEquals(APIResponseHandler.getResponse(apiResponse).findPath("name").asText(), "Damodara Marar LLD");
    }

    @Test
    public void getAPIRequestTest() {
        Requests requests = new Requests(getApiRequestContext());
        requests.getRequest(Requests.USER_ENDPOINT, 200);
    }
}
