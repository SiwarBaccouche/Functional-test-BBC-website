package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class settingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public settingsPage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openSettingsPage() {
        driver.get("https://account.bbc.com/account/settings/");
    }

    public void clickEditBtn() {
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));

        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[aria-label='Edit Password']")
        ));
        editBtn.click();
    }
    public void enterNewPassword(String newPassword) {
        WebElement newPassInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        newPassInput.sendKeys(newPassword);
    }


    public void clickShowPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
        WebElement showPasswordLink = driver.findElement(By.id("toggle-password-type"));
        showPasswordLink.click();
    }
    public void clickSaveAndContinueBtn() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
        WebElement saveAndContinueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("Button[type='submit']")));
        saveAndContinueBtn.click();
    }

    public String getChangeSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[aria-live='assertive']")
        ));
        return message.getText();
    }


    public String getChangeError() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-bbc-title='newPassword-error']")));
        return message.getText();
    };
}

