package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagerPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class CreateCustomerAccountsTest extends SharedData {
    @Test
    public void automationTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginBankManager();

        ManagerPage managerPage = new ManagerPage(getDriver());
        managerPage.createCustomer();

        WebElement firstNameElement = getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Madalina";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Chera";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = getDriver().findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "307382";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = getDriver().findElement(By.xpath("//button[@class='btn btn-default']"));
        submitCustomerElement.click();

        Alert customerAlert = getDriver().switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccountElement = getDriver().findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccountElement.click();

        // Pentru un customer vreau sa ii creez 3 conturi diferite (moneda diferita)

//        List<String> currencyValuesList = new ArrayList<>();
//        currencyValuesList.add("Dollar");
//        currencyValuesList.add("Pound");
//        currencyValuesList.add("Rupee");

//        SAU

        List<String> currencyValuesList = Arrays.asList("Dollar", "Pound", "Rupee");
        String fullName = firstNameValue + " " + lastNameValue;

        for (int i = 0 ; i < currencyValuesList.size(); i++) {

            WebElement customerNameElement = getDriver().findElement(By.id("userSelect"));
            Select customerSelect = new Select(customerNameElement);
            customerSelect.selectByVisibleText(fullName);

            WebElement currencyElement = getDriver().findElement(By.id("currency"));
            Select currencySelect = new Select(currencyElement);
            currencySelect.selectByVisibleText(currencyValuesList.get(i));

            WebElement processButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
            processButton.click();

            Alert accountAlert = getDriver().switchTo().alert();
            String accountAlertText = accountAlert.getText();
            System.out.println(accountAlertText);
            accountAlert.accept();
        }


        WebElement customerElement = getDriver().findElement(By.xpath("//button[@ng-click='showCust()']"));
        customerElement.click();

        WebElement searchCustomerElement = getDriver().findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchCustomerElement.click();
        searchCustomerElement.sendKeys(fullName);
    }
}