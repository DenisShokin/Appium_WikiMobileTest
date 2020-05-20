//import lib.CoreTestCase;
//import lib.ui.MainPageObject;
//import lib.ui.SearchPageObject;
//import org.junit.Assert;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.ScreenOrientation;
//import org.openqa.selenium.WebElement;
//
//import java.time.Duration;
//
//public class FirstTest extends CoreTestCase {
//
//    private MainPageObject MainPageObject;
//    private SearchPageObject searchPageObject;
//
//    protected void setUp() throws Exception {
//        MainPageObject = new MainPageObject(driver);
//    }
//
//    @Test
//    public void testSearchJava() {
//        searchPageObject.skip();
//        searchPageObject.initSearchInput();
//        searchPageObject.typeSearchLine("Java");
//        searchPageObject.waitForSearchResult("Java (programming language)");
//    }
//
//    @Test
//    public void testCancelSearch() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                "Java",
//                "error Java label",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClear(By.id("search_src_text"),
//                "error clear field Search",
//                timeoutInSeconds);
//        MainPageObject.waitForElementNotPresent("org.wikipedia:id/search_close_btn", "button close is visible", 5);
//    }
//
//    @Test
//    public void testCompareArticleTitle() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                "Java",
//                "error Java label",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
//                "error click Java element",
//                timeoutInSeconds
//        );
//        WebElement title_element = MainPageObject.waitIfElementPresent(By.xpath("//*[contains(@text,'Java (programming language)')]"),
//                "element not present",
//                timeoutInSeconds);
//        String articel_title = title_element.getAttribute("text");
//        Assert.assertEquals("assert error", "Java (programming language)", articel_title);
//    }
//
//    @Test
//    public void testSwipeArticle() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search ')]"),
//                "Appium",
//                "error Java label",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='Appium']"),
//                "error click Appium element",
//                timeoutInSeconds
//        );
//        MainPageObject.swipeUpToFindElement(By.xpath("//*[@text='View page in browser']"), "Can not find the end of the article", 30);
//    }
//
//    @Test
//    public void testSaveFirstArticleToMyList() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                "Java",
//                "error Java label",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
//                "error click Java element",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/article_menu_bookmark']"),
//                "error click bookmark button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Got')]"),
//                "error Got it button click",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/default_list_empty_image']"),
//                "error click Save button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/snackbar_action']"),
//                "error click bookmark button",
//                timeoutInSeconds);
//        MainPageObject.swipeElementToLeft(By.xpath("//*[contains(@text,'Java (programming language)')]"),
//                "error swipe Java element");
//    }
//
//    @Test
//    public void testAmountOfNotEmptySearch() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        String search_line = "Link";
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                search_line,
//                "error Link label",
//                timeoutInSeconds);
//        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']";
//        MainPageObject.waitIfElementPresent(By.xpath(search_result_locator),
//                "error find element",
//                timeoutInSeconds);
//        int amount_of_search_results = MainPageObject.getAmountOfElements(
//                By.xpath(search_result_locator));
//        Assert.assertTrue("Have not result items", amount_of_search_results > 0);
//    }
//
//    @Test
//    public void testAmountOfEmptyResult() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        String search_line = "sdfkjljtrojojoi";
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                search_line,
//                "error Link label",
//                timeoutInSeconds);
//        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']";
//        String empty_result_label = "//*[@text='No results found']";
//        MainPageObject.waitIfElementPresent(By.xpath(empty_result_label),
//                "empty result label not present",
//                timeoutInSeconds);
//        MainPageObject.assertElementNotPresent(By.xpath(search_result_locator),
//                "We have found results");
//    }
//
//    @Test
//    public void testChangeOrientationOnSearchResult() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                "Java",
//                "error Java label",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.xpath("//*[contains(@text,'Java (programming language)')]"),
//                "error click Java element",
//                timeoutInSeconds
//        );
//        String titleBeforeRotation = MainPageObject.waitForElementAndGetAttribute(By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
//                "text",
//                "Can not find title of article",
//                timeoutInSeconds);
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//        String titleAfterRotation = MainPageObject.waitForElementAndGetAttribute(By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
//                "text",
//                "Can not find title of article",
//                timeoutInSeconds);
//        Assert.assertEquals("title after rotation not equals title before rotation",
//                titleBeforeRotation,
//                titleAfterRotation);
//        driver.rotate(ScreenOrientation.PORTRAIT);
//        String titleAfterSecondRotation = MainPageObject.waitForElementAndGetAttribute(By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
//                "text",
//                "Can not find title of article",
//                timeoutInSeconds);
//        Assert.assertEquals("title after rotation not equals title before rotation",
//                titleBeforeRotation,
//                titleAfterSecondRotation);
//    }
//
//    @Test
//    public void testCheckSearchArticleInBackground() {
//        MainPageObject.waitForElementPresentAndClick(By.id("fragment_onboarding_skip_button"),
//                "error skip button",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndClick(By.id("search_container"),
//                "error search container",
//                timeoutInSeconds);
//        MainPageObject.waitForElementPresentAndSendKeys(By.xpath("//*[contains(@text,'Search')]"),
//                "Java",
//                "error Java label",
//                timeoutInSeconds);
//        MainPageObject.waitIfElementPresent(By.xpath("//*[@text='Object-oriented programming language']"),
//                "error Java search item",
//                timeoutInSeconds);
//        driver.runAppInBackground(Duration.ofSeconds(2));
//        MainPageObject.waitIfElementPresent(By.xpath("//*[contains(@text,'Search')]"),
//                "Search field not empty",
//                timeoutInSeconds);
//    }
//
//
//}