package StepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.TestBase;
import org.junit.jupiter.api.Assertions;
import pages.logoutPage;

public class LogoutSteps {
    private logoutPage logoutPage;

    public LogoutSteps() {
        this.logoutPage = new logoutPage(TestBase.getDriver());
    }

    @Given("the user in home page")
    public void theUserIsOnTheHomePage() {
        try {
            logoutPage.openLoggedinPage();
            Hooks._scenario.log(Status.PASS, "The user is on the home page");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is not on the home page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

    @When("the user clicks on the account button")
        public void theUserClicksOnTheAccountButton() {
            try {
            logoutPage.clickAccountBtn();
            Hooks._scenario.log(Status.PASS, "clicks on the account button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "fails to click on the account button");
            Hooks._scenario.log(Status.FAIL,e.getMessage());

        }
    }

    @When("the user clicks on the logout button")
    public void theUserClicksOnTheLogoutButton() {
        try {
            logoutPage.submitLogout();
            Hooks._scenario.log(Status.PASS, "clicks on the logout button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "clicks on the logout button");
            Hooks._scenario.log(Status.FAIL,e.getMessage());

        }
    }


    @Then("the user should see a successful logout message")
    public void userSeesSuccessfulLogoutMessage() {
        try {
            String successMessage = logoutPage.getSuccessMessage();
            Assertions.assertTrue(successMessage.contains("You've signed out, sorry to see you go."),
                    "Expected success message not found");
            Hooks._scenario.log(Status.PASS, "The user sees a successful logout message: " + successMessage);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should see a successful logout message");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }
}
