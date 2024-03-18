package sda.homework.day18;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.FileInputStream;
import java.io.IOException;

public class NegativeLoginTest{
    By usernameById = By.id("username");
    By passwordById  = By.id("password");
    By submitById  = By.id("submit");
    By errorById  = By.id("error");
    @Test(dataProvider = "getDataFromExcelFile")
    public void negativeScenario(String username, String password){
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(usernameById);
        WebElement passwordInput = driver.findElement(passwordById);
        WebElement submitButton = driver.findElement(submitById);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();

        SoftAssert sa = new SoftAssert();

        WebElement errorMessage  =driver.findElement(errorById);
        sa.assertTrue(errorMessage.isDisplayed());
        sa.assertAll();
        System.out.println(Thread.currentThread().threadId());
    }


    @DataProvider(parallel = true)
    public Object[][] getDataFromExcelFile() throws IOException {
        return new Object[][]{
                {getData(1,0),getData(1,1)},
                {getData(2,0),getData(2,1)},
                {getData(3,0),getData(3,1)},
                {getData(4,0),getData(4,1)}
        };
    }

    public String getData(int rowIndex, int columnIndex) throws IOException {
        String result = "";
        String userDir =System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String path =userDir+separator+
                "src"+separator+
                "test"+separator+
                "java"+separator+
                "sda"+separator+
                "homework"+separator+
                "day18"+separator+
                "resources"+separator+
                "excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        result = wb.getSheet("credentials").getRow(rowIndex).getCell(columnIndex).toString();
        System.out.println("result = " + result);
        wb.close();
        fis.close();
        return result;
    }

}
