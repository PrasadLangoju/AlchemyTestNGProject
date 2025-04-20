package com.testcases;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTestCases extends BaseClass {

    @Test(priority = 0)
    public void validateLoginFunctionality() {
        //Create object of LoginPage
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        //Call the login method

        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"), ConfigReader.getProperty("url"));
        homePage.verifyLogoutPresence();
        //Add assertions to verify successful login
        //For example, check if the URL has changed or if a specific element is visible after login
    }


}
