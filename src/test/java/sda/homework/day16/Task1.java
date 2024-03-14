package sda.homework.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.TestBase;

public class Task1 extends TestBase {

    //HW01:
    //Go to URL: https://www.google.com
    //Search words: Java, Selenium
    //Assert get text result est that the result text contains the searched Word.
    //Run tests from XML file.
    @Test
    @Parameters("keyWord")
    public void parametrizedTest(String keyWord){
        By searchBox = By.name("q");
        By searchButton = By.name("btnK");
        By result =By.xpath("//a[@href='https://www.selenium.dev/']" +
                "//h3[@class='LC20lb MBeuO DKV0Md'][normalize-space()='Selenium']");
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(searchBox);
        WebElement searchBtn = driver.findElement(searchButton);
        searchField.sendKeys(keyWord);
        searchBtn.click();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(driver.findElement(result)
                .getText().contains("Selenium"));
        sa.assertAll();

    }
    @Test
    @Parameters("keyWord1")
    public void parametrizedTest2(String keyWord1){
        By searchBox = By.name("q");
        By searchBoxAfter = By.xpath("//*[@class='gLFyf']");
        By searchButton = By.name("btnK");
        By result =By.xpath("//h3[@class ='LC20lb MBeuO DKV0Md']" +
                "[normalize-space()='Java | Oracle']");
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(searchBox);
        WebElement searchBtn = driver.findElement(searchButton);
        searchField.sendKeys(keyWord1);
        searchBtn.click();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(driver.findElement(result)
                .getText().contains("Java"));
        sa.assertAll();

    }
}
