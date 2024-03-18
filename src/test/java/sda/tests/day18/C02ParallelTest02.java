package sda.tests.day18;

import org.testng.annotations.Test;
import sda.utillities.TestBase;

public class C02ParallelTest02 extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.clarusway.com");
    }
    @Test
    public void test02(){
        driver.get("https://www.ebay.com");
    }
    @Test
    public void test03(){
        driver.get("https://www.linkedin.com");
    }
    @Test
    public void test04(){
        driver.get("https://www.google.com");
    }
}