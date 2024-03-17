package sda.tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

public class C02DataProvider extends TestBase {


    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ''Invalid credentials'’ is displayed.

    By userNameField = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");
    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        driver.findElement(buttonTag).click();

        SoftAssert sa = new SoftAssert();
        Thread.sleep(500);
        WebDriverWait wait = (WebDriverWait) driver;

        WebElement invalidText =driver.findElement(textByXpath);
        sa.assertTrue(invalidText.isDisplayed());
        sa.assertAll();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getData(){
        return new Object[][]{
                {"Admin","admin123"},
                {"cdmin","admin123"},
                {"Admin","Admin123"},
                {"Admin","asr"},
                {"asef","admin123"}
        };
        }


}
