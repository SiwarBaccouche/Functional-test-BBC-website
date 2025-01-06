package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public loginPage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() {
        driver.get("https://www.bbc.com/");
    }

    public void clickSignInLink() {
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[aria-label='Sign In']")
        ));
        signInLink.click();
    }
    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-identifier-input")));
        emailInput.sendKeys(email);
    }


    public void clickContinueBtn() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        continueBtn.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-input")));
        passwordInput.sendKeys(password);
    }

    public void signBtn() {
        WebElement signBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("submit-button")
        ));
        signBtn.click();
    }
    public boolean getYourAccountBtn() {
        try {
            WebElement accountBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("button.sc-5b3467da-7.cWmBDI")
            ));
            return accountBtn.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
//    public String getSuccessMessage() {
//        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("button[class='sc-5b3467da-7']"))
//        );
//        return successMsg.getText();
//    }


    public String getErrorMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='sb-form-message__content__text']")));
        return message.getText();
    }

    ;


}
