package sda.homework.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

public class Task3 extends TestBase {

    //D15HW03:
    //Test Case3: Negative Password Test
    //Open page https://practicetestautomation.com/practice-test-login/
    //Type username student into Username field.
    //Type password incorrectPassword into Password field.
    //Puch Submit button.
    //Verify error message is displayed.
    //Verify error message text is Your password is invalid!

    @Test
    public void softAssertion(){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By error = By.id("error");

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("incorrectPassword");

        submitButton.click();

        SoftAssert sa = new SoftAssert();

        WebElement errorMessage  =driver.findElement(error);
        sa.assertTrue(errorMessage.isDisplayed());
        sa.assertTrue(errorMessage.getText().contains("Your password is invalid!"));
        sa.assertAll();

    }
    @Test
    public void hardAssertion(){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By error = By.id("error");
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("incorrectPassword");

        submitButton.click();

        WebElement errorMessage  =driver.findElement(error);
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Your password is invalid!"));


    }
}
