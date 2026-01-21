package pages;

import models.CustomerModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
        searchCustomerElement.sendKeys(testData.getFirstNameValue());
    }

    public void validateCustomer(CustomerModel testData){
        String customerTableRow = tableRows.get(0).getText();
        Assert.assertTrue(customerTableRow.contains(testData.getFirstNameValue()));
        Assert.assertTrue(customerTableRow.contains(testData.getLastNameValue()));
        Assert.assertTrue(customerTableRow.contains(testData.getPostCodeValue()));
//        Assert.assertTrue(customerTableRow.contains(accountNumber));
    }

    public void deleteCustomer(){
        deleteCustomerElement.click();
    }
}