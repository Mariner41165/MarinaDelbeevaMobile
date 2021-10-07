package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageObject {

    AppiumDriver appiumDriver;

    @FindBy(xpath = "//*[@class='gLFyf']")
    WebElement searchField;

    @FindBy(css = "a.C8nzq")
    List<WebElement> results;

    public GooglePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        this.appiumDriver = appiumDriver;
    }

    public void sendSearchRequest(String textForSearch) {
        searchField.sendKeys(textForSearch);
        searchField.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getListOfSearchResults(String textForSearch) {
        List<WebElement> resultsContainingText =
            results.stream().filter(el -> el.getAttribute("href").contains(textForSearch.toLowerCase()))
                   .collect(Collectors.toList());
        return resultsContainingText;
    }

}
