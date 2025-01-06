package StepDefinitions;


import ExtentReport.ExtentManager;
import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
    private ExtentReports extentReport = ExtentManager.getInstance();
    public static ExtentTest _scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        TestBase.setUp();
        _scenario = extentReport.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                String screenshotPath = TestBase.captureScreenshot(scenario.getName());
                if (!screenshotPath.isEmpty()) {
                    _scenario.fail("Scenario Failed",
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } else {
                    _scenario.fail("Scenario Failed: Screenshot not captured");
                }
            } else {
                _scenario.pass("Scenario Passed");
            }
        } catch (Exception e) {
            _scenario.fail("Error in afterScenario: " + e.getMessage());
        } finally {
            extentReport.flush();
        }
        // TestBase.tearDown();
    }
}
