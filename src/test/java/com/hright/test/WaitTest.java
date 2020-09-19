package com.hright.test;

import com.hright.drivers.SeleniumDrivers;
import com.hright.find.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WaitTest {

    @Test
    public  void  Test(){

        WebDriver driver = SeleniumDrivers.openBrower("chrome");
        driver.get("file:///C:/SeleniumProject/webdriver_demo/selenium_html/index.html");
        WebElementUtils.findElement(By.className("wait")).click();
        String text = WebElementUtils.findElement(By.className("red")).getText();
        System.out.println(text);

        SeleniumDrivers.closed();

    }



}
