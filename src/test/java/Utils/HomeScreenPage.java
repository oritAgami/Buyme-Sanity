package Utils;

import Utils.BasePage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeScreenPage extends BasePage {

    private static ExtentTest test;
    private static WebDriverWait wait;

    public HomeScreenPage(ExtentTest extentTest) {
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(3));
        test = extentTest;
    }

    @Test
    public void searchForGifts() {
        By amountDdLocator = By.cssSelector("span[title='סכום']");
        By amountDdOptionLocator = By.id("ember1077");
        By regionDdLocator = By.cssSelector("span[title='אזור']");
        By regionDdOptionLocator = By.id("ember1111");
        By categoryDdLocator = By.cssSelector("span[title='קטגוריה']");
        By categoryDdOptionLocator = By.id("ember1171");
        By searchBtnLocator = By.linkText("חיפוש");

        wait.until(ExpectedConditions.elementToBeClickable(amountDdLocator));
        clickElement(amountDdLocator);
        test.info("opened amount dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(amountDdOptionLocator));
        clickElement(amountDdOptionLocator);
        test.info("selected amount option from dropdown");

        wait.until(ExpectedConditions.elementToBeClickable(regionDdLocator));
        clickElement(regionDdLocator);
        test.info("opened region dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(regionDdOptionLocator));
        clickElement(regionDdOptionLocator);
        test.info("selected region option from dropdown");

        wait.until(ExpectedConditions.elementToBeClickable(categoryDdLocator));
        clickElement(categoryDdLocator);
        test.info("opened category dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(categoryDdOptionLocator));
        clickElement(categoryDdOptionLocator);
        test.info("selected category option from dropdown");

        wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator));
        clickElement(searchBtnLocator);
        test.info("clicked search button");

    }

}
