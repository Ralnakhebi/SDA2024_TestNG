package sda.tests.day19;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.utillities.TestBaseExtendReport;

public class C01ExtentReport01 extends TestBaseExtendReport {

    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ''Invalid credentials'’ is displayed.

    By userNameFiled = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");

    @Test(dataProvider ="invalidCredentials" )
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        extentTest.info("Navigating to the page . .");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        extentTest.info("Entering Name: "+userName);
        driver.findElement(userNameFiled).sendKeys(userName);
        extentTest.info("Entering Password: "+password);
        driver.findElement(passwordName).sendKeys(password);
        extentTest.log(Status.PASS," Password Entered Successfully");
        extentTest.info("Clicking Sign In .. ");
        driver.findElement(buttonTag).click();

        Thread.sleep(1000);
        WebElement invalidText = driver.findElement(textByXpath);
        boolean isTextDisplayed = invalidText.isDisplayed();
        if(isTextDisplayed){
            extentTest.log(Status.PASS, " Passed");
        }else {
            extentTest.log(Status.FAIL," Failed");
        }
        Assert.assertTrue(invalidText.isDisplayed());


    }


    @DataProvider(name = "invalidCredentials")
    public Object[][] getData(){
        return new Object[][]{
                {"adm","admin23*"},
                {"cdmin","admin123"}
        };
    }

}