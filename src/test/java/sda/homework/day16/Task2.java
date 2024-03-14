package sda.homework.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

public class Task2 extends TestBase {

    @Test
    @Parameters({"positiveUsername","positivePassword"})
    public void positiveScenario(String username, String password){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By pageContains = By.xpath("//*[@class='has-text-align-center']");
        By logout = By.xpath("//a[starts-with(@class,'wp-block-button__link')]");

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

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
    @Parameters({"negativeUsername","positivePassword2"})
    public void negativeScenario(String negativeUsername, String positivePassword){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By error = By.id("error");

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys(negativeUsername);
        passwordInput.sendKeys(positivePassword);

        submitButton.click();

        SoftAssert sa = new SoftAssert();

        WebElement errorMessage  =driver.findElement(error);
        sa.assertTrue(errorMessage.isDisplayed());
        sa.assertTrue(errorMessage.getText().contains("Your username is invalid!"));
        sa.assertAll();

    }

    @Test
    @Parameters({"positiveUsername2","negativePassword"})
    public void negativeScenario2(String positiveUsername, String negativePassword){
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By submit = By.id("submit");
        By error = By.id("error");

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement submitButton = driver.findElement(submit);
        usernameInput.sendKeys(positiveUsername);
        passwordInput.sendKeys(negativePassword);

        submitButton.click();

        SoftAssert sa = new SoftAssert();
        WebElement errorMessage  =driver.findElement(error);
        sa.assertTrue(errorMessage.isDisplayed());
        sa.assertTrue(errorMessage.getText().contains("Your password is invalid!"));
        sa.assertAll();

    }
}
