package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTeamPage extends BaseClass {

    public MyTeamPage(){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath ="//div[text()=' My Team ']")
    WebElement myTeamTab;

    @FindBy(xpath = "//input[@id='mat-input-9']")
    WebElement userSearchFiled;

    public void enterUserName(String userName) throws InterruptedException {
        myTeamTab.click();
        Thread.sleep(3000);
        userSearchFiled.click();
        userSearchFiled.sendKeys(userName);
    }

}
