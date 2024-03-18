package sda.tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

import java.time.Duration;

public class C04ParallelTestDataProvider {

    By userNameField = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");
    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        WebDriver driver =new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        driver.findElement(buttonTag).click();

        SoftAssert sa = new SoftAssert();
        Thread.sleep(1000);

        WebElement invalidText =driver.findElement(textByXpath);
        sa.assertTrue(invalidText.isDisplayed());
        sa.assertAll();
        System.out.println(Thread.currentThread().threadId());
    }

    @DataProvider(name = "invalidCredentials",parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                {"1Admin","admin123"},
                {"cdmin","admin123"},
                {"Admin","Admin123"},
                {"Admin","asr"},
                {"asef","admin123"}
        };
    }


}
