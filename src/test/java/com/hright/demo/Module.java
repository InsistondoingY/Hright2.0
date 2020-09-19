package com.hright.demo;

import com.csvreader.CsvReader;
import com.hright.drivers.SeleniumDrivers;
import com.hright.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class Module {

    //初始化webdriver
    /*public  WebDriver getDriver() {
        WebDriver driver = SeleniumDrivers.openBrower("chrome");
       // return driver;
    }*/
    //public WebDriver driver = SeleniumDrivers.openBrower("chrome");
    //登录方法
    public static void login(WebDriver driver,String username,String password)throws Exception{

        driver.get("https://ctalentlitetest.fsgplus.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //读取csv文件
        String filePath = "./datafile/userinfo.csv";
        CsvReader reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
        reader.readHeaders(); // 跳过表头, 如果需要表头的话，不要写这句。

        while (reader.readRecord()) {
            // 读取一条记录
            System.out.println("用户名密码"+reader.getRawRecord());
            // 按列名读取这条记录的值
            username = reader.get("username");
            password = reader.get("password");
            //调用登录方法
            //Module.login(driver,username,password);
            Thread.sleep(1000);
            driver.findElement(LoginPage.userField).clear();
            driver.findElement(LoginPage.userField).sendKeys(username);
            driver.findElement(LoginPage.pwdField).clear();
            driver.findElement(LoginPage.pwdField).sendKeys(password);
            driver.findElement(LoginPage.loginButton).click();
            
        }

    }

    //退出方法
    public void logout(WebDriver driver)throws InterruptedException{

        Thread.sleep(3000);
        driver.quit();

    }

}
