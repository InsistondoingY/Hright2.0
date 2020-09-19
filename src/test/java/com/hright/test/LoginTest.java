package com.hright.test;

import com.csvreader.CsvReader;
import com.hright.demo.Module;
import com.hright.drivers.SeleniumDrivers;
import com.hright.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    //Module module = new Module();
    //WebDriver driver = module.getDriver();
    //WebDriver driver  = module.getDriver();
    WebDriver driver = SeleniumDrivers.openBrower("chrome");
    private String loginname = "AAA";

    @BeforeMethod
    public void setUp() throws Exception {

         Module.login(driver,"111","111111");

        }
    @Test
    //验证登录是否成功
    public void Hright() throws InterruptedException {

        Thread.sleep(2000);
        System.out.print("登录用户名："+driver.findElement(LoginPage.loginName).getText());
        Assert.assertEquals(driver.findElement(LoginPage.loginName).getText(),loginname);


    }

    @AfterMethod
    public void tearDown() throws Exception {
        SeleniumDrivers.closed();
    }

    }


