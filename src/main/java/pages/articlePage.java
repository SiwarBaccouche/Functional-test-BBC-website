package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class articlePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public articlePage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openSearchedArticlePage() {
        driver.get("https://www.bbc.com/search?q=Elon%20Musk%20changes%20his%20name%20to%20Kekius%20Maximus%20on%20X&edgeauth=eyJhbGciOiAiSFMyNTYiLCAidHlwIjogIkpXVCJ9.eyJrZXkiOiAiZmFzdGx5LXVyaS10b2tlbi0xIiwiZXhwIjogMTczNjE5MzIxNSwibmJmIjogMTczNjE5Mjg1NSwicmVxdWVzdHVyaSI6ICIlMkZzZWFyY2glM0ZxJTNERWxvbiUyNTIwTXVzayUyNTIwY2hhbmdlcyUyNTIwaGlzJTI1MjBuYW1lJTI1MjB0byUyNTIwS2VraXVzJTI1MjBNYXhpbXVzJTI1MjBvbiUyNTIwWCJ9.8x9X3vOhVDEdB11MD6n-bPBrZNv9OAaLURZBH5ZBihg");
    }

    public void clickArticle() {
        WebElement articleCard = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-testid='newport-article']")
        ));
        articleCard.click();
    }

    public void clickSaveBtn() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='saveButton']")));
        saveBtn.click();
    }
    public void clickAccountBtn() {
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.sc-5b3467da-7.cWmBDI")));
        saveBtn.click();
    }

   public void clickSavedBtn() {
        WebElement savedBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-testid='external-anchor']")));
        savedBtn.click();
    }


    public String savedArticleFound() {
        WebElement savedArticlemessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[data-testid='card-headline']")));
        return savedArticlemessage.getText();
    };

    public String getSavingError() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='no-results']")));
        return message.getText();
    };
}

