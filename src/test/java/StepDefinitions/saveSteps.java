package StepDefinitions;

import base.TestBase;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.articlePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class saveSteps {

    private articlePage articlePage;

    public saveSteps() {
        this.articlePage = new articlePage(TestBase.getDriver());
    }


    @Given("the user is on the searched article")
    public void theUserIsOnSearchedArticlePage() {
        try {
            articlePage.openSearchedArticlePage();
            Hooks._scenario.log(Status.PASS, "The user is on the search result page>");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is not on the search result page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

    @When("the user clicks the searched article")
    public void userClicksSearchedArticle() {
        System.out.println("Step executed: userClicksSearchedArticle");
        articlePage.clickArticle();
    }

    @When("the user clicks save button")
    public void userClicksSaveBtn() {
        articlePage.clickSaveBtn();
    }

    @When("skips clicking the save button")
    public void skipsClickingSaveButton() {
        // No action
        System.out.println("Skipped clicking the save button.");
    }

    @When("clicks on the account bar")
    public void clickAccountBar() {
        articlePage.clickAccountBtn();
    }
 @When("clicks on the saved bar")
    public void clickSavedBar() {
        articlePage.clickSavedBtn();
    }


    @Then("the user should see the saved article")
    public void seeSavedArticleMessage() {
        String article = articlePage.savedArticleFound();
        assertTrue(article.contains("Elon Musk changes his name to Kekius Maximus on X"));
    }

    @Then("the user should see a save error message")
    public void displaySearchError() {
        String message = articlePage.getSavingError();
        assertTrue(message.contains("You haven't saved anything yet"),
                "Expected message to contain 'You haven't saved anything yet', but got: " + message);
    }

//    @Then("the user should see an error message")
//    public void displaySearchError() {
//        String message = articlePage.getError();
//        assertTrue(message.contains("Sorry there are no results"));
//    }


}
