package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LogUtility;

public class LoginPage extends BasePages {

    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    private WebElement bankManagerElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginBankManager(){
        bankManagerElement.click();
        LogUtility.infoLog("The user clicked on bank manager button");
    }
}