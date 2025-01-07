package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class searchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public searchPage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoggedPage() {
        driver.get("https://www.bbc.com/");
    }

    public void clickSearchIcon() {
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[aria-label='Search BBC']")
        ));
        signInLink.click();
    }
    public void enterArticleTitle(String title) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='search-input-field']")));
        titleInput.sendKeys(title);
    }


    public void clickSearchBtn() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='search-input-search-button']")));
        searchBtn.click();
    }

    public String articleFound() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[data-testid='card-headline']")));
        return message.getText();
    };

    public String getError() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='sc-ccbf3b7e-4 gtQofG']")));
        return message.getText();
    };
}

