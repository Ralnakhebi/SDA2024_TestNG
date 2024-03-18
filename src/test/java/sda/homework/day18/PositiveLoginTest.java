package sda.homework.day18;

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

public class PositiveLoginTest{

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By submit = By.id("submit");
    By pageContains = By.xpath("//*[@class='has-text-align-center']");
    By logout = By.xpath("//a[starts-with(@class,'wp-block-button__link')]");

    @Test(dataProvider = "getDataFromExcelFile")
    public void positiveScenario(String username, String password){
        WebDriver driver = new ChromeDriver();
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

    @DataProvider(parallel = true)
    public Object[][] getDataFromExcelFile() throws IOException {
        return new Object[][]{
                {getData(1,0),getData(1,1)}
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
        result = wb.getSheet("CorrectCer").getRow(rowIndex).getCell(columnIndex).toString();
        System.out.println("result = " + result);
        wb.close();
        fis.close();
        return result;
    }

}
