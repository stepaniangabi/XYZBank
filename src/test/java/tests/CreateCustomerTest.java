package tests;

import models.CustomerModel;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

public class CreateCustomerTest extends SharedData {

    //data-driven testing = concept pe baza caruia datele de test se vor salva in fisiere externe cu scopul de a le
    //accesa in orice test avem nevoie + sa le putem refolosi
    //pentru acest concept se accepta diferite extensii de fisiere
    //key-1..value
    //firstName=[Alex,Madalina,Oana]

    @Test
    public void automationTest() {
        CustomerModel testData = new CustomerModel("src/test/resources/CustomerData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginBankManager();

        ManagerPage managerPage = new ManagerPage(getDriver());
        managerPage.createCustomer();

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.createCustomerProcess(testData);
        customerPage.openAccount();

        AccountPage accountPage = new AccountPage(getDriver());
        accountPage.createAccountProcess(testData);
        accountPage.openCustomersPage();

        CustomersPage customersPage = new CustomersPage(getDriver());
        customersPage.searchCustomer(testData);
        customersPage.validateCustomer(testData);
        customersPage.deleteCustomer();
    }
}
