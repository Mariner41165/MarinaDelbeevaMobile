package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageObject {

    AppiumDriver appiumDriver;

    @FindBy(xpath = "//*[@class='gLFyf']")
    WebElement searchField;

    @FindBy(xpath = "//li[@class='sbct'][1]")
    WebElement searchFirstSuggestion;

    @FindBy(xpath = "//div[@id='rso']")
    List<WebElement> results;

    public GooglePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        this.appiumDriver = appiumDriver;
    }

    public void sendSearchRequest(String textForSearch) {
        searchField.sendKeys(textForSearch);
        searchFirstSuggestion.click();
    }

    public List<WebElement> getListOfSearchResults(String textForSearch) {
        List<WebElement> resultsContainingText =
            results.stream().filter(el -> el.getText().contains(textForSearch.toLowerCase()))
                   .collect(Collectors.toList());
        return resultsContainingText;
    }
}
