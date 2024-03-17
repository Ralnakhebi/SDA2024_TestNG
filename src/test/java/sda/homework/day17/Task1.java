package sda.homework.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sda.utillities.TestBase;

public class Task1 extends TestBase {
    By emailById = By.id("input-email");
    By passwordById = By.id("input-password");
    By searchBoxByName = By.name("search");
    @Test (dataProvider = "getData")
    public void test(String search){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(emailById).sendKeys("clarusway@gmail.com");
        driver.findElement(passwordById).sendKeys("123456789", Keys.ENTER);

        driver.findElement(searchBoxByName).sendKeys(search,Keys.ENTER);

    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
