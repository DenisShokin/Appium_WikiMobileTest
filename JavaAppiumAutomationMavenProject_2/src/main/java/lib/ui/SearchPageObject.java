package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static lib.CoreTestCase.timeoutInSeconds;

public class SearchPageObject extends MainPageObject {

    private final static String
            SKIP_BUTTON = "fragment_onboarding_skip_button",
            SEARCH_INIT_ELEMENT = "search_container",
            SEARCH_INPUT = "//*[contains(@text,'Search')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void skip(){
        this.waitForElementPresentAndClick(By.id(SKIP_BUTTON), "Can not find and click skip element", timeoutInSeconds);
    }

    public void waitForCancelToAppear(){
        this.waitIfElementPresent(By.id(SEARCH_CANCEL_BUTTON),"Can not find search cancel button",timeoutInSeconds);
    }

    public void waitForCancelToDisappear(){
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"Cancel button is still present",timeoutInSeconds);
    }

    public void clickCancelSearch(){
        waitForElementPresentAndClick(By.id(SEARCH_CANCEL_BUTTON),"Can not click search cancel button", timeoutInSeconds);
    }

    public void initSearchInput() {
        this.waitForElementPresentAndClick(By.id(SEARCH_INIT_ELEMENT), "Can not find and click search element", timeoutInSeconds);
        this.waitIfElementPresent(By.xpath(SEARCH_INPUT), "Can not present element");
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementPresentAndSendKeys(By.xpath(SEARCH_INPUT), searchLine,"Can not find and type in search input", timeoutInSeconds);
    }

    public void waitForSearchResult(String substring){
        String searchResultXpath = getResultSearchElement(substring);
        this.waitIfElementPresent(By.xpath(searchResultXpath), "element can not displayed result with substring: " + substring, timeoutInSeconds);
    }

    public void clickByArticleBySubstring(String substring){
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementPresentAndClick(By.xpath(searchResultXpath), "element can not displayed result with substring: " + substring, timeoutInSeconds);
    }


}
