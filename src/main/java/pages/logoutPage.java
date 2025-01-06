package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public logoutPage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void openLoggedinPage() {
        driver.get("https://www.bbc.com/");
    }

    public void clickAccountBtn() {
        WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.sc-5b3467da-7.cWmBDI")
        ));
        accountBtn.click();
    }
    public void submitLogout() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href*='signout']")
        ));
        logoutBtn.click();
    }

    public String getSuccessMessage() {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.heading.u-padding-bottom-quad > span")));
        return successMsg.getText();
    }
}
