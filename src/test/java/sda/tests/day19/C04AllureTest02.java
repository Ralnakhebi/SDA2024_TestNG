package sda.tests.day19;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04AllureTest02 {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void test1(){
        System.out.println("Test 1 has passed");
    }
    @Test(enabled = false)
    @Severity(SeverityLevel.CRITICAL)
    public void test2(){
        System.out.println("Test 2 has passed");
    }
    @Test(timeOut = 1000)
    public void test3() throws InterruptedException {
        System.out.println("Test 3 has passed");
        Thread.sleep(2000);
    }
    @Test
    public void test4(){
        System.out.println("Test 4 has passed");
        Assert.assertEquals(4,3);
    }
    @Test
    public void test5(){
        System.out.println("Test 5 has passed");
        Assert.assertEquals(3,3);
    }
}
