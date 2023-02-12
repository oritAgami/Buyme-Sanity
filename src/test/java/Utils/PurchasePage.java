package Utils;

import Utils.BasePage;
import Utils.Constants;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class PurchasePage extends BasePage {
    private static ExtentTest test;
    private static WebDriverWait wait;

    public PurchasePage(ExtentTest extentTest){
        super();
        wait = new WebDriverWait(super.driver, Duration.ofSeconds(5));
        test = extentTest;
    }

    public void purchaseGift() {
        By sendingTimeBtnLocator = By.cssSelector("div[gtm='עכשיו']");
        By sendingPlatformBtnLocator = By.cssSelector("path[class='circle']");
        By receiverPhoneLocator = By.cssSelector("input[placeholder='נייד מקבל/ת המתנה']");
        By senderPhoneLocator = By.cssSelector("input[placeholder='מספר נייד']");

        wait.until(ExpectedConditions.urlContains(Constants.PURCHASE_STEP_1));
        test.info("validated stage is 1");

        clickElement(By.xpath("//*[text()='למישהו אחר']"));
        test.info("clicked for someone else option");

        sendKeysToElement(By.cssSelector("input[type='text']"),"אורית עג\'מי");
        test.info("entered sender name");

        clickElement(By.cssSelector("div[class='selected-name']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='10']"))).click();
        test.info("selected option from event-type dropdown");

        clearAndSendKeysToElement(By.tagName("textarea"),"המון מזל טוב לי :)");
        test.info("entered greeting text inside the textarea");

//      clickElement(By.cssSelector("input[type='file']"));
//      clickElement(By.cssSelector("label[class='bm-media-upload']"));

        clickElement(By.cssSelector("button[type='submit']"));
        test.info("submitted the first stage");

        wait.until(ExpectedConditions.urlContains(Constants.PURCHASE_STEP_2));
        test.info("validated stage changed to 2");

        wait.until(ExpectedConditions.elementToBeClickable(sendingTimeBtnLocator));
        clickElement(sendingTimeBtnLocator);
        test.info("clicked gift's sending date");

        wait.until(ExpectedConditions.elementToBeClickable(sendingPlatformBtnLocator));
        clickElement(sendingPlatformBtnLocator);
        test.info("chose gift sending platform");

        wait.until(ExpectedConditions.visibilityOfElementLocated(receiverPhoneLocator));
        clearAndSendKeysToElement(receiverPhoneLocator,"0523743232");
        test.info("entered receiver phone number");

        wait.until(ExpectedConditions.visibilityOfElementLocated(senderPhoneLocator));
        clearAndSendKeysToElement(senderPhoneLocator,"0542448110");
        test.info("entered sender phone number");

        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"),"אורית");
        test.info("entered sender name");

        clickElement(By.cssSelector("button[gtm='המשך לתשלום']"));
        test.info("submitted the second stage");

        wait.until(ExpectedConditions.urlContains(Constants.PURCHASE_STEP_3));
        test.info("validated stage changed to 3");
        test.info("now just check the terms and click the submit button for finishing the transaction!");


    }
}
