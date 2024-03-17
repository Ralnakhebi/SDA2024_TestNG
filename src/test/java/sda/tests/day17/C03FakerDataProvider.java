package sda.tests.day17;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

import java.time.Duration;

public class C03FakerDataProvider extends TestBase {


    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ''Invalid credentials'’ is displayed.

    By userNameField = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");
    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        driver.findElement(buttonTag).click();

        SoftAssert sa = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(textByXpath)));
        WebElement invalidText =driver.findElement(textByXpath);
        sa.assertTrue(invalidText.isDisplayed());
        sa.assertAll();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getData(){
        Faker faker=new Faker();
        return new Object[][]{
                {Faker.instance().name().username(),Faker.instance().internet().password()},
                {faker.name().username(),faker.internet().password()},
                {faker.name().username(),faker.internet().password()},
                {faker.name().username(),faker.internet().password()},
                {faker.name().username(),faker.internet().password()}
        };
    }


}
