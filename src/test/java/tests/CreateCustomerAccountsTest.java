package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCustomerAccountsTest {
    public WebDriver driver;

    @Test
    public void automationTest(){
        driver=new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        WebElement bankManagerElement = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
        bankManagerElement.click();

        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameElementValue = "Gabriella";
        firstNameElement.sendKeys(firstNameElementValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Stepanian";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "300360";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomer = driver.findElement(By.xpath("//button[@type='submit']"));
        submitCustomer.click();

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccount = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccount.click();

        //pentru un customer vreau sa ii creez 3 conturi
        List<String> currencyValueList = Arrays.asList("Dollar", "Pound", "Rupee");

        String fullName = firstNameElementValue + " " + lastNameValue;
        for (int i=0 ; i<= currencyValueList.size() ; i++) {
            WebElement customerName = driver.findElement(By.id("userSelect"));
            Select customerSelect = new Select(customerName);
            customerSelect.selectByVisibleText(fullName);

            WebElement currency = driver.findElement(By.id("currency"));
            Select currencySelect = new Select(currency);
            currencySelect.selectByVisibleText(currencyValueList.get(i));

            WebElement process = driver.findElement(By.xpath("//button[@type='submit']"));
            process.click();

            Alert accountAlert = driver.switchTo().alert();
            String accountAlertText = accountAlert.getText();
            System.out.println(accountAlertText);
            accountAlert.accept();
        }


        WebElement customers = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        customers.click();

        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder='Search Customer']"));
        searchCustomerElement.sendKeys(fullName);
    }

}
