package com.testcases;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTestCases extends BaseClass {
    @Test(priority = 1)
    public void validateUsernameAndEmail() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"), ConfigReader.getProperty("url"));
        homePage.verifyUserName_and_Email();
    }

    @Test(priority = 2)
    public void validateCreateKey() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"), ConfigReader.getProperty("url"));
        homePage.createAPI_SecretKey();
    }
}
