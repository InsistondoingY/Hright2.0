package com.hright.action;

import com.hright.drivers.SeleniumDrivers;
import com.hright.logger.LoggerControler;
import com.hright.tools.DateFormat;
import com.hright.tools.MyFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

/**
 * Created by lenovo on .必须要继承SeleniumDrivers
 */
public class ScreenShot extends SeleniumDrivers {
    final static LoggerControler log =LoggerControler.getlogger(ScreenShot.class);
    static String path = System.getProperties().getProperty("user.dir") + "/error/";
    /**
     * 错误截图，通过日期命名的截图
     **/
    public static void screenShots() {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            //根据日期创建文件夹
            MyFile myFile = new MyFile();
            myFile.createFile1(path+DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            //根据日期创建截图并放到日期文件夹下
            FileUtils.copyFile(file,new File(path + "/" + DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/"+
                    DateFormat.format(DateFormat.ZN_DATE_FORMAT)+".jpg"));
        } catch (IOException e) {
            log.error("截图失败！！");
            e.printStackTrace();
        }
    }
    /**
     * 错误截图,通过传入name来给截图命名
     **/
    public static void screenShots1(String name) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            MyFile myFile = new MyFile();
            myFile.createFile1(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            log.info(DateFormat.format(DateFormat.ZH_DATE_FORMAT));
            FileUtils.copyFile(file,new File(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/" + name + ".jpg"));
        } catch (IOException e) {
            log.error("截图失败！！");
            e.printStackTrace();
        }
    }

    /**
     * 判断文件夹，没有就新建
     */
/*    public static void fileExists() {
        String fileName = DateUtil.format(DateUtil.CHECK_LOG_FORMAT);
        File file = new File(path + fileName);
        if (!file.exists()) {
            file.mkdirs();
        }
    }*/
}
