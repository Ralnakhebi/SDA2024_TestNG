package sda.homework.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.utillities.ParameterBrowserTestBase;

public class Task2 extends ParameterBrowserTestBase {

    //Go to URL: http://crossbrowsertesting.github.io/todo-app.html
    //Checking Box todo-4 and Checking Box todo-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the todo we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    By todo4ByName = By.name("todo-4");
    By todo5ByName = By.name("todo-5");
    By insertTodoById = By.id("todotext");
    By countByXpath = By.xpath("//*[@class='ng-binding']");
    By archiveByXpath= By.xpath("//*[@ng-click='todoList.archive()']");
    @Test
    public void test(){
        driver.get("http://crossbrowsertesting.github.io/todo-app.html");
        driver.findElement(todo4ByName).click();
        driver.findElement(todo5ByName).click();

        SoftAssert sa = new SoftAssert();

        sa.assertTrue(driver.findElement(countByXpath).getText().contains("3"));

        driver.findElement(archiveByXpath).click();
        driver.findElement(insertTodoById).sendKeys("New Task ", Keys.ENTER);
        sa.assertTrue(driver.findElement(countByXpath).getText().contains("4"));
        sa.assertAll();
    }
}
