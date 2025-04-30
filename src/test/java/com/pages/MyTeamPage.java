package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTeamPage extends BaseClass {

    public MyTeamPage(){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath ="//div[text()=' My Team ']")
    WebElement myTeamTab;

    @FindBy (xpath ="//div[@class='mat-mdc-tab-labels']//div[1]")
    WebElement Members;

    @FindBy(xpath = "//input[@id='mat-input-2']")
    WebElement userSearchFiled;

    public void enterUserName(String userName) throws InterruptedException {
        myTeamTab.click();
        Members.click();
        Thread.sleep(200); // if needed
        userSearchFiled.sendKeys("Allen");

         System.out.println("UserName clicked");
    }

}
