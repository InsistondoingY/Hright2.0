package com.hright.page;


import org.openqa.selenium.By;

public class LeaveBalancePage {

    //打开假期管理
    public static By openLeave = By.xpath("//li[5]/div[1]");
    //打开假期余额
    public static By openLeaveBalance = By.linkText("假期余额");
    //修改余额按钮
    public static By updateButton = By.xpath("//div[12]//button");
    //余额输入框
    public static By leaveInput = By.xpath("//*[@id=\"editLimit_ChangeValue\"]/div[2]/input");
    //备注输入框
    public static By remakInput = By.xpath("//*[@id=\"editLimit_Remark\"]");
    //确定按钮
    public static By submitButton = By.xpath("//div/button[2]");
    //缓存余额(原有余额)
    public static By originalBalance = By.tagName("strong");
}
