package Utils;

import Utils.BasePage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage extends BasePage {
    private static WebDriverWait wait;
    private static ExtentTest test;

    public RegistrationPage(ExtentTest extentTest){
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(5));
        test = extentTest;
    }

//    public void register() {
//        clickElement(By.linkText("כניסה / הרשמה"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='text-link theme']"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1862"))).sendKeys("YOUR_NAME");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1869"))).sendKeys("YOUR_EMAIL");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valPass"))).sendKeys("YOUR_PASSWORD");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1883"))).sendKeys("YOUR_PASSWORD");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("circle[class='fill']"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
//    }

    public void login() {
        By emailInpLocator = By.id("ember1836");
        By passwordInpLocator = By.id("ember1843");
        By submitBtnLocator = By.id("ember1852");

        clickElement(By.linkText("כניסה / הרשמה"));
        test.info("Clicked register link");

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInpLocator));
        sendKeysToElement(emailInpLocator,"YOUR_EMAIL");
        test.info("Entered email");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInpLocator));
        sendKeysToElement(passwordInpLocator,"YOUR_PASSWORD");
        test.info("Entered password");

        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtnLocator));
        clickElement(submitBtnLocator);
        test.info("clicked submit btn");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='login-form']")));
    }
}
