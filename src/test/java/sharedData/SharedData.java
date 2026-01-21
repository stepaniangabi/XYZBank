package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LogUtility;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;
    private String testName;

    //fac un mecanism care sa deschida browserul
    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();

        //headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LogUtility.startTest(testName);
    }

    //fac un mecanism care sa inchida browseru
    @AfterMethod
    public void clearEnvironment(){
        driver.quit();
        LogUtility.finishTest(testName);
    }

    public WebDriver getDriver() {
        return driver;
    }
}