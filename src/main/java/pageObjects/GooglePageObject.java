package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePageObject {

    AppiumDriver appiumDriver;

    @FindBy(xpath = "//*[@class='gLFyf']")
    WebElement searchField;

    @FindBy(xpath = "//li[@class='sbct'][1]")
    WebElement searchFirstSuggestion;

    @FindBy(xpath = "//*[@class='g']")
    List<WebElement> results;

    public GooglePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        this.appiumDriver = appiumDriver;
    }

    public void sendSearchRequest(String textForSearch) {
        searchField.sendKeys(textForSearch);
        searchFirstSuggestion.click();
    }

    public List<WebElement> getListOfSearchResults() {
        return results;
    }
}
