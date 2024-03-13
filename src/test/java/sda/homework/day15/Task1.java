package sda.homework.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

public class Task1 extends TestBase {

    /*
    Test Case1: Positive Login Test
    Open page https://practicetestautomation.com/practice-test-login/
    Type username student into Username field
    Type password Password123 into Password field
    Click Submit button.
    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    Verify button Log out is displayed on the new page.
    */
    @Test
    public void softAssertion(){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By pageContains = By.xpath("//*[@class='has-text-align-center']");
        By logout = By.xpath("//a[starts-with(@class,'wp-block-button__link')]");
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");

        submitButton.click();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));

        WebElement welcomeMassage = driver.findElement(pageContains);
        sa.assertTrue(welcomeMassage.getText().contains("Congratulations")||
                welcomeMassage.getText().contains("successfully logged in"));
        WebElement logoutButton = driver.findElement(logout);
        sa.assertTrue(logoutButton.isDisplayed());
        sa.assertAll();


    }
    @Test
    public void hardAssertion(){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By pageContains = By.xpath("//*[@class='has-text-align-center']");
        By logout = By.xpath("//a[starts-with(@class,'wp-block-button__link')]");
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");

        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));

        WebElement welcomeMassage = driver.findElement(pageContains);
        Assert.assertTrue(welcomeMassage.getText().contains("Congratulations")||
                welcomeMassage.getText().contains("successfully logged in"));
        WebElement logoutButton = driver.findElement(logout);
        Assert.assertTrue(logoutButton.isDisplayed());


    }
}
