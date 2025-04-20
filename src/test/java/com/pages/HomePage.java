package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseClass {
    WebDriver driver=null;
    public HomePage() {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//menu-item[@class='ng-star-inserted'and @text='Logout']")
    WebElement logoutButton;

    @FindBy (xpath = "//menu-item[@text='My Profile']")
    WebElement MyProfile;

    @FindBy (xpath = "//input[@id='mat-input-2']")
    WebElement UserNametext;

    @FindBy (xpath = "//input[@id='mat-input-5']")
    WebElement emailText;

    @FindBy (xpath="(//span[@class='mdc-tab__text-label'])[2]")
    WebElement Securitytab;

    @FindBy (xpath="//span[text()='Create Key']")
    WebElement CreateKeyButton;

    @FindBy (xpath= "//div[@id='mat-select-value-1']")
    WebElement ApplicationDropDown;

    @FindBy (xpath="//span[text()='Cloud Execution']")
    WebElement cloudexecutionOption;

    @FindBy (xpath ="//span[text()='Create']")
    WebElement createButton;

    @FindBy (xpath = "//input[@id='mat-input-9']")
    WebElement APIKeyText;

    @FindBy (xpath = "//input[@id='mat-input-10']")
    WebElement secretKey;

    @FindBy (xpath ="//span[text()='Cancel']")
    WebElement cancelButton;



    //Action methods
    public void verifyLogoutPresence(){
        if(logoutButton.isDisplayed()){
            System.out.println("Login successful and Logout button is present");
            logoutButton.click();
            }
        else {
            System.out.println("Logout button is not present");
        }
    }

    public void verifyUserName_and_Email(){
        MyProfile.click();
        System.out.println("The UserName is : "+UserNametext.getAttribute("value"));
        System.out.println("The emailId is: "+emailText.getAttribute("value"));
    }

    public void createAPI_SecretKey() throws InterruptedException {
        MyProfile.click();
        Thread.sleep(3000);
        Securitytab.click();
        CreateKeyButton.click();
        ApplicationDropDown.click();
        cloudexecutionOption.click();
        createButton.click();

        String apiKey = APIKeyText.getAttribute("value");
        String secretKeyValue = secretKey.getAttribute("value");
        System.out.println("The new API Key is: "+apiKey);
        System.out.print("The new Secret Key is: "+secretKeyValue);
        Thread.sleep(000);
        cancelButton.click();

    }
}
