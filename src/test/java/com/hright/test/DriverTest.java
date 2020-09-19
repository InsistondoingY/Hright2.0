package com.hright.test;

import com.hright.drivers.SeleniumDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void  openTest(){

        WebDriver driver = SeleniumDrivers.openBrower("firefox");
        driver.get("http://www.baidu.com");
    }
}
