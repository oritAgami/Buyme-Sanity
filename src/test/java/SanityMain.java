import Utils.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class SanityMain {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
    private String time = "/Users/lioragami/Desktop/BuymeSanity/src/Output" + String.valueOf(System.currentTimeMillis());

    @BeforeClass
    public void initSanity() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("/Users/lioragami/Desktop/BuymeSanity/src/Output/Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("My Sanity Tests", "Let's go");
        test.log(Status.INFO, "@Before class");
        driver = DriverSingleton.getDriverInstance();
        driver.get(DriverSingleton.getData("site"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void registrationFlow()  {
        RegistrationPage registrationPage = new RegistrationPage(test);

        try {
            test.info("!!Started registration flow!!");
            //registrationPage.register();
            registrationPage.login();
            test.info("!!Completed registration flow!!");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(time)).build());
        }
    }

    @Test(priority = 2)
    public void searchForGiftsFlow() {
        HomeScreenPage homeScreenPage = new HomeScreenPage(test);

        try {
            test.info("!!Started searchForGiftsFlow flow!!");
            homeScreenPage.searchForGifts();
            test.info("!!Completed searchForGiftsFlow flow!!");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(time)).build());
        }
    }

    @Test(priority = 3)
    public void selectGiftsSupplierFlow() {
        GiftsSuppliersPage suppliersPage = new GiftsSuppliersPage(test);

        try {
            test.info("!!Started selectGiftsSupplierFlow flow!!");
            suppliersPage.selectGiftsSupplier();
            test.info("!!Completed selectGiftsSupplierFlow flow!!");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(time)).build());
        }
    }

    @Test(priority = 4)
    public void purchaseFlow() {
        var purchasePage = new PurchasePage(test);

        try {
            test.info("!!Started purchaseFlow flow!!");
            purchasePage.purchaseGift();
            test.info("!!Completed purchaseFlow flow!!");
        } catch (NoSuchElementException e){
            e.printStackTrace();
            test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(time)).build());
        }
    }

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

    @AfterClass
    public void tearDown(){
        test.log(Status.INFO, "@After test " + "After test method");
//        driver.quit();
        extent.flush();
    }
}