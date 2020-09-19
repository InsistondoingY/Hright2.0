package com.hright.action;



import com.hright.find.WebElementUtils;
import com.hright.logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/11/8.
 */
public class Action {
    final static LoggerControler log =LoggerControler.getlogger(Action.class);
    //单击操作
    public static void click(By by, String text){
        WebElementUtils.findElement(by).click();
        log.info("点击："+by);
    }
    //输入文本
    public static void sendkey(By by, String text){
        WebElementUtils.findElement(by).sendKeys(text);
        log.info("在"+by+"输入"+text);
        log.error("这是一个error");
        log.warn("这是一个warn");
        log.debug("这是一个debug");
    }
    //获取单个文本值
    public static String getText(By by){
        String text=WebElementUtils.findElement(by).getText();
        return text;
    }
    //获取多个文本值
    public static ArrayList getTexts(By by){
        ArrayList arryList=new ArrayList();
        List<WebElement> webElement=WebElementUtils.findElements(by);
        for(int j=0;j<webElement.size();j++){
            String text=webElement.get(j).getText();
            arryList.add(text);

        }
        return arryList;
    }
    //封装双击操作
    public static void doubleClick(WebDriver driver,By by){
        Actions actions = new Actions(driver);
        WebElement element = WebElementUtils.findElement(by);
        actions.doubleClick(element).perform();


    }
}
