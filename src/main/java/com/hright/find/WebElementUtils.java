package com.hright.find;

import com.hright.action.Action;
import com.hright.drivers.SeleniumDrivers;
import com.hright.logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by lenovo on 2016/11/8.
 */
public class WebElementUtils extends SeleniumDrivers{

    final static LoggerControler log =LoggerControler.getlogger(Action.class);
    public static WebElement findElement(final By by){
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            log.info("元素"+by+"查找超时");
            e.printStackTrace();
        }
        return driver.findElement(by);
    }
    public static List<WebElement> findElements(final By by){
        List<WebElement> webElements=null;
        try {
            webElements=new WebDriverWait(driver,5).until(new ExpectedCondition<List<WebElement>>(){
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(by);
                }
            });
        }catch (Exception e){
            log.info("元素"+by+"定位超时");
            e.printStackTrace();
        }
        return webElements;
    }
}