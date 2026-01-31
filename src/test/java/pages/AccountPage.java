package pages;

import models.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.LogUtility;

import javax.xml.xpath.XPath;

public class AccountPage extends BasePages {

    @FindBy(id = "userSelect")
    private WebElement customerNameElement;

    @FindBy(id = "currency")
    private WebElement currencyElement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement processButtonElement;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    private WebElement customersElement;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void createAccountProcess(CustomerModel testData){
        Select customerSelect = new Select(customerNameElement);
        customerSelect.selectByVisibleText(testData.getFullNameValue());
        LogUtility.infoLog("The user select" + testData.getFullNameValue()+ "value from drop down");

        Select currencySelect = new Select(currencyElement);
        currencySelect.selectByVisibleText(testData.getCurrencyValue());
        LogUtility.infoLog("The user select" + testData.getCurrencyValue()+ "value from drop down");

        processButtonElement.click();
        LogUtility.infoLog("The user clicks on procces button");



        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String[] accountsArray = accountAlertText.split(":");
        String accountNumber = accountsArray[1];
        accountAlert.accept();
        LogUtility.infoLog("The user accepts the account creation alert");
    }

    public void openCustomersPage(){
        customersElement.click();
        LogUtility.infoLog("The user clicks on Customers page");
    }
}