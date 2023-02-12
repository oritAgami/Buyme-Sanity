package Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class GiftsSuppliersPage extends BasePage {

    private static ExtentTest test;
    private static WebDriverWait wait;

    public GiftsSuppliersPage(ExtentTest extentTest) {
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(15));
        test = extentTest;
    }
    public void selectGiftsSupplier() {
        By categoryBoxLocator = By.cssSelector("span[class='name bm-subtitle-1']");
        String route = "https://buyme.co.il/search";
        String websiteUrl = super.driver.getCurrentUrl();

        assertWebsiteUrl();

        clickElement(categoryBoxLocator);
        test.info("clicked supplier card from grid");

        chooseGiftsPrice();
    }

    public void assertWebsiteUrl() {
        String route = "https://buyme.co.il/search";
        String websiteUrl = super.driver.getCurrentUrl();

        Assert.assertTrue(websiteUrl.contains(route));
        test.info("Validated website url = /search");
    }

    public void chooseGiftsPrice() {
        By giftAmountInpLocator = By.cssSelector("input[type='tel']");
        By submitBtnLocator = By.cssSelector("button[type='submit']");

        wait.until(ExpectedConditions.elementToBeClickable(giftAmountInpLocator));
        sendKeysToElement(giftAmountInpLocator, "100");
        test.info("entered price inside gift price input");

        wait.until(ExpectedConditions.elementToBeClickable(submitBtnLocator));
        clickElement(submitBtnLocator);
        test.info("confirmed gift price");
    }
}
