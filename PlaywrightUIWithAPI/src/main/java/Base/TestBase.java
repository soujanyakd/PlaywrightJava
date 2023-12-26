package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.*;
import configurations.Chrome;
import lombok.Getter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestBase.CustomTestListener.class)
public class TestBase {

    Chrome browser;
    static ExtentReports extentReports;

    @Getter
    protected Page page;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result) {
        browser = new Chrome();
        this.page = browser.launchWebsite();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        browser.initializeTrace();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        browser.tearDownTrace();
        extentReports.flush();
        this.browser.tearDown();
    }

    public static class CustomTestListener implements ITestListener {

        @Override
        public void onTestSuccess(ITestResult result) {
            extentReports.createTest(result.getName()).log(Status.PASS, "Test passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            extentReports.createTest(result.getName()).fail(result.getThrowable());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            extentReports.createTest(result.getName()).skip(result.getThrowable());
        }

        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Test Suite Finished: " + context.getSuite().getName());
        }

        @Override
        public void onStart(ITestContext context) {
            System.out.println("Test Suite Started: " + context.getSuite().getName());
        }
    }
}
