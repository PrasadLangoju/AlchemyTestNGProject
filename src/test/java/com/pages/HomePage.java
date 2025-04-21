package com.pages;

import com.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseClass {
    WebDriver driver=null;
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public HomePage(WebDriver driver) {
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

    @FindBy (xpath="//div[text()=' My Team ']")
    WebElement myTeam;

    @FindBy(xpath="//span[text()='Licensing']")
    WebElement licenceTab;

    @FindBy(xpath="//td[@class=\"mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-validFrom mat-column-validFrom ng-star-inserted\"]")
    WebElement validFrom;

    @FindBy(xpath="//td[@class=\"mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-validTo mat-column-validTo ng-star-inserted\"]")
    WebElement validTo;



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
    public void validateLicence() throws InterruptedException {
        myTeam.click();
        licenceTab.click();
        //wait.until(ExpectedConditions.visibilityOf(validFrom));
        Thread.sleep(3000);
        String validFromDate = validFrom.getText();
        System.out.println("The Valid From date is: "+validFromDate);
        //wait.until(ExpectedConditions.visibilityOf(validTo));
        Thread.sleep(3000);
        String validToDate = validTo.getText();
        System.out.println("The Valid To date is: "+validToDate);
    }
}
