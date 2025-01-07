package StepDefinitions;


import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.loginPage;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private loginPage loginPage;

    public LoginSteps() {
        this.loginPage = new loginPage(TestBase.getDriver());
    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginPage.openLoginPage();
    }

    @When("the user clicks the Sign In link")
    public void userClicksSignInLink() {
        System.out.println("Step executed: userClicksSignInLink");
        loginPage.clickSignInLink();
    }

    @When("the user enters an email as {string}")
    public void userEntersEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("clicks on the continue button")
    public void clickContinueBtn() {
        loginPage.clickContinueBtn();
    }


    @When("the user enters a password as {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("clicks on the next button")
    public void userClicksSignInButton() {
        loginPage.signBtn();
    }

    @When("clicks on the return button")
    public void userClicksReturnButton() {
        loginPage.getYourAccountBtn();
    }

    @Then("the user should see your account button")
    public void userSeesAccountBtn() {
        boolean accountbtn = loginPage.getYourAccountBtn();
        Assertions.assertTrue(accountbtn,
                "Error Login in");
    }

    @Then("the user should see error message")
    public void displayErrorMessage() {
        String message = loginPage.getErrorMessage();
        assertTrue(message.contains("We don't recognise that email"));
    }

  @Then("the user should see password error message")
    public void displaypasswordErrorMessage() {
        String message = loginPage.getErrorMessage();
        assertTrue(message.contains("That password isn’t right. You can"));
    }


}
