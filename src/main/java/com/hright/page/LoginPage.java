package com.hright.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static By userField = By.id ("userCode");
    public static By pwdField  = By.id ("password");
    public static By loginButton  = By.cssSelector("span > button");
    public static By loginName = By.cssSelector(".ant-dropdown-trigger span:nth-of-type(2)");


}
