package apitest;

import Base.APITestBase;
import apiutils.Requests;
import org.testng.annotations.Test;
import pojoresource.UpdateUser;

import java.util.HashMap;
import java.util.Map;

public class UpdateAPITest extends APITestBase {

    @Test
    public void putAPIRequestUsingStringTest() {
        String putPayload = "{\n" +
                "  \"id\" : \"5705944\",\n" +
                "  \"name\" : \"Automation\",\n" +
                "  \"email\" : \"automation128@gmail.com\",\n" +
                "  \"gender\" : \"female\",\n" +
                "  \"status\" : \"active\"\n" +
                "}";
        Requests requests = new Requests(getApiRequestContext());
        requests.putRequest(Requests.USER_ENDPOINT + "/5705944" , putPayload, 200);
    }

    @Test
    public void putAPIRequestUsingJsonTest() {
        UpdateUser updateUser = UpdateUser.getInstance();
        updateUser.setId("5705944");
        updateUser.setName("automation Test1");
        updateUser.setEmail("automation128@gmail.com");
        updateUser.setGender("male");
        updateUser.setStatus("active");

        Requests requests = new Requests(getApiRequestContext());
        requests.putRequest(Requests.USER_ENDPOINT + "/5705944", updateUser, 200);
    }

    @Test
    public void putAPIRequestTest() {
        Map<String, Object> putData = new HashMap<>();
        putData.put("id", "5705944");
        putData.put("name", "automation Test");
        putData.put("email", "automationTest123@test.com");
        putData.put("gender", "female");
        putData.put("status", "inactive");
        Requests requests = new Requests(getApiRequestContext());
        requests.putRequest(Requests.USER_ENDPOINT + "/5705944", putData, 200);
    }

    @Test
    public void patchAPIRequestTest() {
        Map<String, Object> patchData = new HashMap<>();
        patchData.put("email", "automationTest155@test.com");
        patchData.put("gender", "male");
        Requests requests = new Requests(getApiRequestContext());
        requests.patchRequest(Requests.USER_ENDPOINT + "/5705944", patchData, 200);
    }

    @Test
    public void deleteAPIRequestTest() {
        Requests requests = new Requests(getApiRequestContext());
        requests.deleteRequest(Requests.USER_ENDPOINT + "/5706107", 204);
    }
}
