package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;
import pageObjects.GooglePageObject;

public class webMobileTests extends BaseTest {

    @Parameters ({"url","textForSearch"})
    @Test(groups = {"web"}, description = "Test performs search by keyword and checks relevant results")
    public void testForWebApplication(String url, String textForSearch) {
        // open google search page
        getDriver().get(url);

        // make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // check google page title
        assert ((WebDriver) getDriver()).getTitle().equals("Google") : "This is not Google search page";
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // make a search using keyword EPAM
        GooglePageObject g = new GooglePageObject(getDriver());
        g.sendSearchRequest(textForSearch);

        // make sure that there are some relevant results
        assert (g.getListOfSearchResults().size() > 0) : "Forbidden: result of search is an empty list";

        // log that test finished
        System.out.printf("Count of displayed results for \"%s\": %s%n", textForSearch, g.getListOfSearchResults().size());
    }

}
