package com.hright.test;

import com.hright.action.Action;
import com.hright.demo.Module;
import com.hright.drivers.SeleniumDrivers;
import com.hright.find.WebElementUtils;
import com.hright.logger.LoggerControler;
import com.hright.page.LeaveBalancePage;
import com.hright.tools.MyAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.testng.Assert.assertEquals;

public class LeaveBalanceTest {
    final static LoggerControler log =LoggerControler.getlogger(LeaveBalanceTest.class);
    @BeforeMethod
    public void setUp() throws Exception {
        WebDriver driver = SeleniumDrivers.openBrower("chrome");
        Module.login(driver,"111","111111");

    }
    @Test
    //验证假期余额增加是否有效
    public void VerifyBalance() throws InterruptedException {

        //Thread.sleep(1500);
        //打开请休假管理
        WebElementUtils.findElement(LeaveBalancePage.openLeave).click();
        //打开假期余额
        WebElementUtils.findElement(LeaveBalancePage.openLeaveBalance).click();
        //点击云平台查看F病假余额
        WebElementUtils.findElement(By.xpath("//tr[6]/td[5]")).click();
        Thread.sleep(2000);
        //点击修改按钮
        WebElementUtils.findElement(LeaveBalancePage.updateButton).click();
        //输入增加的余额
        WebElementUtils.findElement(LeaveBalancePage.leaveInput).sendKeys("2");
        //输入必填项备注
        WebElementUtils.findElement(LeaveBalancePage.remakInput).sendKeys("自动化测试备注信息");
        //点击确定
        WebElementUtils.findElement(LeaveBalancePage.submitButton).click();

        //拿到缓存余额值
        String balance = WebElementUtils.findElement(LeaveBalancePage.originalBalance).getText();

        //string转double
        double b = Double.valueOf(balance);
        DecimalFormat df = new DecimalFormat("#.00");//此为保留1位小数，若想保留2位小数，则填写#.00  ，以此类推
        String temp = df.format(b);
        b = Double.valueOf(temp);

        //打印原有余额b
        log.info("缓存余额（原有余额）b："+b);

        //浏览器刷新，拿到最新余额，不然会取到缓存
        WebElementUtils.driver.navigate().refresh();
        Thread.sleep(2000);
        String upadatebalance = WebElementUtils.findElement(LeaveBalancePage.originalBalance).getText();
        log.info(upadatebalance);
        //string转double
        Thread.sleep(2000);
        double b1 = Double.valueOf(upadatebalance);
        DecimalFormat df1 = new DecimalFormat("#.00");//此为保留1位小数，若想保留2位小数，则填写#.00  ，以此类推
        String temp1 = df.format(b1);
        b1 = Double.valueOf(temp1);

        //打印最新假期余额，b1
        log.info("（实际）最新余额b1："+b1);

        //原有假期余额增加2天，b+2
        double inserttemp = 2.00;
        BigDecimal bd1 = new BigDecimal(Double.toString(b));
        BigDecimal bd2 = new BigDecimal(Double.toString(inserttemp));
        double b3 = bd1.add(bd2).doubleValue();

        //打印原有假期余额增加2天
        log.info("(期望值)原有余额+2 b3："+b3);

        //验证假期余额是否增加
        MyAssert.assertEquals(b1,b3);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        SeleniumDrivers.closed();
    }

}
