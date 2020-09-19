package com.hright.test;

import com.hright.action.Action;
import com.hright.drivers.SeleniumDrivers;
import com.hright.logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class ActionTest {
    //final static LoggerControler log= getLogger(ActionTest.class);

    @Test
    public void getText(){
        WebDriver driver = SeleniumDrivers.openBrower("chrome");
        driver.get("http:www.baidu.com");
        Action.sendkey(By.id("kw1"),"selenium test");
        Action.click(By.id("su"),"你点击了百度一下");

        SeleniumDrivers.closed();
    }
   /* @Test
    public void doubleClickTest(){
        WebDriver driver = SeleniumDrivers.openBrower("chrome");
        driver.get("http:www.baidu.com");
        Action.doubleClick(driver,By.id("su"));
    }*/

    @AfterMethod
    public void close(){
        SeleniumDrivers.closed();
    }
}
