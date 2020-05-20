package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static lib.CoreTestCase.timeoutInSeconds;


public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE_TPL = "//*[contains(@text,'{TITLE}')]",
            FOOTER_ELEMENT = "//*[@text='View page in browser']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement(String title) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String searchResultXpath = getResultSearchElement(title);
        System.out.println(searchResultXpath);
        return this.waitIfElementPresent(By.xpath(searchResultXpath),
                "Can not find title",
                timeoutInSeconds);
    }

    private static String getResultSearchElement(String substring) {
        return TITLE_TPL.replace("{TITLE}", substring);
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT),
                "can not find the end of article",
                20);
    }

    public void waitArticle()
    {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
