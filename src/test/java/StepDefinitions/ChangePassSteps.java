package StepDefinitions;

import base.TestBase;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.settingsPage;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangePassSteps {
    private settingsPage settingsPage;

    public ChangePassSteps() {
        this.settingsPage = new settingsPage(TestBase.getDriver());
    }


    @Given("the user in personal details page")
    public void theUserIsOnPersonalDetailsPage() {
        try {
            settingsPage.openSettingsPage();
            Hooks._scenario.log(Status.PASS, "The user is on the settings page>");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is not on the settings result page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

    @When("the user clicks on the edit password button")
    public void userClicksEditPassword() {
        System.out.println("Step executed: userClicksEditPassword");
        settingsPage.clickEditBtn();
    }

    @When("the user enters new password as {string}")
    public void userEntersNewPassword(String newPassword ) {
        settingsPage.enterNewPassword(newPassword);
    }

    @When("the user clicks on save and continue button")
    public void ClickingSaveButton() {
        // No action
        System.out.println("Step executed: userClicksSavePasswprdBtn");
        settingsPage.clickSaveAndContinueBtn();
    }
//    @Then("the user should see a successful password change message")
//    public void seePasswordChangedMessage() {
//        String article = articlePage.savedArticleFound();
//        assertTrue(article.contains("password changed"));
//    }
@When("the user clicks on show password")
public void ClickingShowPasswordButton() {
    System.out.println("Step executed: userClicksShowPassword");
    settingsPage.clickShowPassword();
}
    @Then("the user should see a password change error message")
    public void displayChangePasswordError() {
        String message = settingsPage.getChangeError();
        assertTrue(message.contains("Sorry, that's your old password. Please enter a different one."),
                "Expected message not found but found  " + message);
    }

    @Then("the user should see a successful password change message")
    public void theUserShouldSeeASuccessfulPasswordChangeMessage() {
        String message = settingsPage.getChangeSuccessMessage();
        assertTrue(message.contains("New password saved."),
                "Expected success message was not displayed. Actual message: " + message);
    }


}
