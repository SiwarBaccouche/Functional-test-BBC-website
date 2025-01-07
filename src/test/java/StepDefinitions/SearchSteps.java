package StepDefinitions;

import base.TestBase;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.searchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSteps {
private searchPage searchPage;

    public SearchSteps() {
        this.searchPage = new searchPage(TestBase.getDriver());
    }


    @Given("the user is on home page")
    public void theUserIsOnHomePage() {
        try {
            searchPage.openLoggedPage();
            Hooks._scenario.log(Status.PASS, "The user is on the home page");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is not on the home page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

    @When("the user clicks the search icon")
    public void userClicksSearchIcon() {
        System.out.println("Step executed: userClicksSearchIcon");
        searchPage.clickSearchIcon();
    }

    @When("the user enters a title as {string}")
    public void userEnterTitle(String title) {
        searchPage.enterArticleTitle(title);
    }

    @When("clicks on the search button")
    public void clickSearchBtn() {
        searchPage.clickSearchBtn();
    }


    @Then("the user should see the searched article")
    public void seeSArticleMessage() {
        String article = searchPage.articleFound();
        assertTrue(article.contains("Elon Musk changes his name to Kekius Maximus on X"));
    }

    @Then("the user should see an error message")
    public void displaySearchError() {
        String message = searchPage.getError();
        assertTrue(message.contains("Sorry there are no results"));
    }


}
