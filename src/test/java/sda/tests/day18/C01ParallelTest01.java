package sda.tests.day18;

import org.testng.annotations.Test;
import sda.utillities.TestBase;

public class C01ParallelTest01  {

    // Thread.currentThread().getId(): Returns the ID of the thread executing the method.
    // Since there is no interference when this class is executed, the execution is sequential.
    // If we want to make the tests in this class run in parallel, we can configure it in the XML file.
    @Test
    public void test01(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test01 ..");
    }
    @Test
    public void test02(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test02 ..");

    }
    @Test
    public void test03(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test03 ..");

    }
    @Test
    public void test04(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test04 ..");

    }
    @Test
    public void test05(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test05 ..");

    }
    @Test
    public void test06(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test06 ..");

    }
    @Test
    public void test07(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test07 ..");

    }
    @Test
    public void test08(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+"Thread executing for test08 ..");

    }
}
