package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BasePage {
    WebDriver driver = null;

    BasePage() {
        this.driver = DriverSingleton.getDriverInstance();
    }
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }
    public void clearAndSendKeysToElement(By locator, String text) {
        WebElement elem = getWebElement(locator);
        elem.clear();
        elem.sendKeys(text);
    }

    public WebElement getWebElement(By locator) {
        return this.driver.findElement(locator);
    }

    public List<WebElement> getWebElements(By locator) {
        return this.driver.findElements(locator);
    }
}
