package scenarios;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.RegistrationPageObject;
import pageObjects.SignInPageObject;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Parameters ({"email", "password"})
    @Test(groups = {"native"}, description = "Test perform registration and signing in")
    public void testForNativeAndroidApp(String email, String password) throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        //go to registration page
        (new SignInPageObject(getDriver())).goToRegistrationPage();

        //Register new account
        (new RegistrationPageObject(getDriver())).registerNewAccount(email, password);

        //Sign in
        (new SignInPageObject(getDriver())).signIn(email, password);

        //BudgetActivity page is opened
        Assert.assertTrue(getPo().getWelement("budgetActivityPageTitle").isDisplayed());

        System.out.println("BudgetActivityPage is opened. Test successfully passed");
    }

}
