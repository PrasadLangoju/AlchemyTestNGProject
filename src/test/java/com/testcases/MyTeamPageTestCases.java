package com.testcases;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.pages.MyTeamPage;
import com.utilities.ConfigReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyTeamPageTestCases extends BaseClass {
    LoginPage loginPage;

    @Test
    public void validateUserNameInTeams() throws InterruptedException {
        //Create object of LoginPage
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        //Call the login method
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"), ConfigReader.getProperty("url"));
        //Create object of MyTeamPage

        MyTeamPage myTeamPage = PageFactory.initElements(driver, MyTeamPage.class);
        myTeamPage.enterUserName("Allen");
        // Add assertions to verify the functionality
    }
}
