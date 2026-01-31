package pages;

import models.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LogUtility;

import java.util.List;

public class CustomerPage extends BasePages {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameElement;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameElement;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeElement;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement submitCustomerElement;

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    private WebElement openAccountElement;

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void createCustomerProcess(CustomerModel testData) {
        firstNameElement.sendKeys(testData.getFirstNameValue());
        LogUtility.infoLog("The user fills first name field with value: " + testData.getFirstNameValue());

        lastNameElement.sendKeys(testData.getLastNameValue());
        LogUtility.infoLog("The user fills last name field with value: " + testData.getLastNameValue());

        postCodeElement.sendKeys(testData.getPostCodeValue());
        LogUtility.infoLog("The user fills post code field with value: " + testData.getPostCodeValue());

        submitCustomerElement.click();
        LogUtility.infoLog("The user clicks on submit button");

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();
        LogUtility.infoLog("The user accepts the alert with message: " + customerAlertText);
    }

    public void createCustomersProcess(List<String> firstNameValueList, List<String> lastNameValueList, List<String> postCodeValueList){
        int i = 0;
        while (i<firstNameValueList.size()){
            firstNameElement.sendKeys(firstNameValueList.get(i));
            LogUtility.infoLog("The user fills first name field with value: " + firstNameValueList.get(i));

            lastNameElement.sendKeys(lastNameValueList.get(i));
            LogUtility.infoLog("The user fills last name field with value: " + lastNameValueList.get(i));

            postCodeElement.sendKeys(postCodeValueList.get(i));
            LogUtility.infoLog("The user fills post code field with value: " + postCodeValueList.get(i));

            submitCustomerElement.click();
            LogUtility.infoLog("The user clicks on Submit button");

            Alert customerAlert = driver.switchTo().alert();
            String customerAlertText = customerAlert.getText();
            System.out.println(customerAlertText);
            customerAlert.accept();
            LogUtility.infoLog("The user accept the customer alert");

            i++;
        }

    }

    public void openAccount() {
        openAccountElement.click();
        LogUtility.infoLog("The user clicks on Open Account button ");
    }

}