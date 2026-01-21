package tests;

import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class CreateCustomersTest extends SharedData {

    @Test
    public void automationTest() {
        //CustomerModel testData = new CustomerModel("CustomersData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginBankManager();

        ManagerPage managerPage = new ManagerPage(getDriver());
        managerPage.createCustomer();

        List<String> firstNameValueList = Arrays.asList("Alex 1","Alex 2","Alex 3");
        List<String> lastNameValueList = Arrays.asList("Virlan 1","Virlan 2","Virlan 3");
        List<String> postCodeValueList = Arrays.asList("E10AA","E10AB","E10AC");

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.createCustomersProcess(firstNameValueList, lastNameValueList, postCodeValueList);
    }
}
