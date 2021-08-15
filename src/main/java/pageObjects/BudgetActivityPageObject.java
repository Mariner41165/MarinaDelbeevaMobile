package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BudgetActivityPageObject {

    @AndroidFindBy(xpath = "//*[contains(@text,'BudgetActivity')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Budget']")
    WebElement budgetActivityPageTitle;

    public BudgetActivityPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }


}
