package com.pages;

import com.base.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver driver;

    public LoginPage() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='mat-input-0']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='mat-input-1']")
    WebElement password;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    WebElement loginButton;

    //Action methods
    public void login(String uName, String pwd, String url) {
        BaseClass.launchUrl(url);
        userName.sendKeys(uName);
        password.sendKeys(pwd);
        loginButton.click();
    }

}
