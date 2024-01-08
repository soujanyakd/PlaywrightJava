package Base;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import lombok.Getter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class APITestBase {
    @Getter
    protected APIRequestContext apiRequestContext;

    Playwright playwright;

    @BeforeMethod
    public void intializeRequest() {
        playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        apiRequestContext = apiRequest.newContext();
    }

    @AfterMethod
    public void tearDown() {
        playwright.close();
    }
}
