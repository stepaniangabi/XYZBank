package pages;

import models.CustomerModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.LogUtility;

import java.util.List;

public class CustomersPage extends BasePages {

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerElement;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    private WebElement deleteCustomerElement;

    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    public void searchCustomer (CustomerModel testData){
        searchCustomerElement.click();
        LogUtility.infoLog("The user clicks on search customer");

        searchCustomerElement.sendKeys(testData.getFirstNameValue());
        LogUtility.infoLog("The user fills search field with value: " +testData.getFirstNameValue());
    }

    public void validateCustomer(CustomerModel testData){
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(testData.getFirstNameValue()));
        LogUtility.infoLog("The user validates the presence of: " + testData.getFirstNameValue() + "into the table");

        Assert.assertTrue(customerTableRow.contains(testData.getLastNameValue()));
        LogUtility.infoLog("The user validates the presence of: " + testData.getLastNameValue() + "into the table");

        Assert.assertTrue(customerTableRow.contains(testData.getPostCodeValue()));
        LogUtility.infoLog("The user validates the presence of: " + testData.getPostCodeValue() + "into the table");
//        Assert.assertTrue(customerTableRow.contains(accountNumber));
    }

    public void deleteCustomer(){
        deleteCustomerElement.click();
        LogUtility.infoLog("The user deletes the customer ");
    }
}