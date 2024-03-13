package sda.homework.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

public class Task2 extends TestBase {
        /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!

     */

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
        usernameInput.sendKeys("incorrectUser");
        passwordInput.sendKeys("Password123");

        submitButton.click();

        SoftAssert sa = new SoftAssert();

        WebElement errorMessage  =driver.findElement(error);
        sa.assertTrue(errorMessage.isDisplayed());
        sa.assertTrue(errorMessage.getText().contains("Your username is invalid!"));
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
        usernameInput.sendKeys("incorrectUser");
        passwordInput.sendKeys("Password123");

        submitButton.click();

        WebElement errorMessage  =driver.findElement(error);
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Your username is invalid!"));


    }
}
