package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageObject {
    public AppiumDriver driver;

    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitIfElementPresent(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    public WebElement waitIfElementPresent(By by, String errorMessage) {
        return waitIfElementPresent(by, errorMessage, 5);
    }


    public WebElement waitForElementPresentAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitIfElementPresent(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementPresentAndSendKeys(By by, String value, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitIfElementPresent(by, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    public Boolean waitForElementNotPresent(String id, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresentAndClear(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitIfElementPresent(by, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp(long timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        PointOption pointStart = PointOption.point(x, start_y);
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(5000));
        PointOption pointEnd = PointOption.point(x, end_y);
        action.press(pointStart)
                .waitAction(waitOptions)
                .moveTo(pointEnd)
                .perform();
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpToFindElement(By by, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitIfElementPresent(by, "Can not find element by swiping up \n" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void swipeElementToLeft(By by, String errorMessage) {
        WebElement element = waitIfElementPresent(by, errorMessage, 5000);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction(driver);
        PointOption pointStart = PointOption.point(right_x, middle_y);
        PointOption pointEnd = PointOption.point(left_x, middle_y);
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(150));
        action.press(pointStart)
                .waitAction(waitOptions)
                .moveTo(pointEnd)
                .release()
                .perform();
    }

    public int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(By by, String errorMessage) {
        int elements = getAmountOfElements(by);
        if (elements > 0) {
            String default_message = "An element '" + by.toString() + "' present";
            throw new AssertionError(default_message + " " + errorMessage);
        }
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String errorMessage, long timeouts){
        WebElement element = waitIfElementPresent(by, errorMessage, timeouts);
        return element.getAttribute(attribute);
    }
}
