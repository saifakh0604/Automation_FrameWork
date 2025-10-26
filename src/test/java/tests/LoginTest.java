package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
    public void validateLogin(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.enterLoginBtn();

    }
}
