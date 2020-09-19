package com.hright.test;



import com.hright.drivers.SeleniumDrivers;
import com.hright.tools.MyAssert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/11/13.
 */
public class MyAssertTest {
    @Test
    public void testAssert() throws InterruptedException {
        WebDriver driver;
        driver= SeleniumDrivers.openBrower("chrome");
        driver.get("https://www.baidu.com");
        Assert.assertEquals("百度一下你就知道","百度一你就知道");

        //MyAssert.assertTrue(false);
        SeleniumDrivers.closed();
    }
    @AfterMethod
    public void close(){
        SeleniumDrivers.closed();
    }
}
