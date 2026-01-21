package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LogUtility;

public class ManagerPage extends BasePages {

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    private WebElement addCustomerElement;

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    public void createCustomer(){
        addCustomerElement.click();
        LogUtility.infoLog("The user clicked on create customer button");
    }
}