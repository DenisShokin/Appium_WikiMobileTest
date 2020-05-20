import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class WikiTests extends CoreTestCase {

    @Test
    public void testSearchJava() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.skip();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Java (programming language)");
    }

    @Test
    public void testCancelSearch() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.skip();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForCancelToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelToDisappear();
    }

    @Test
    public void testCompareArticleTitle() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.skip();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleBySubstring("Java (programming language)");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitArticle();
    }

    @Test
    public void testSwipeArticle() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);

        searchPageObject.skip();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleBySubstring("Java (programming language)");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitArticle();
        articlePageObject.swipeToFooter();
    }


}


