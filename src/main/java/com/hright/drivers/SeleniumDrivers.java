package com.hright.drivers;
import com.hright.action.Action;
import com.hright.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * Created by lenovo on 2016/11/8.
 */
public class SeleniumDrivers {
    public static WebDriver driver;
    final static LoggerControler log =LoggerControler.getlogger(SeleniumDrivers.class);

    public static WebDriver openBrower(String browser){
        String path = System.getProperty("user.dir");
        if(browser.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver.exe",path+"drivers/chromedriver.exe");
            driver = new ChromeDriver();
           log.info("你打开了"+browser+"浏览器");
        }else if(browser.equals("firefox")){
            //System.setProperty("webdriver.geckodriver",path+"drivers/geckodriver.exe");
            driver = new FirefoxDriver();log.info("你打开了"+browser+"浏览器");
        }else {
            log.error("你输入的"+browser+"浏览器不支持打开");
        }
        return driver;
    }
    public static void closed() {

        driver.quit();
    }
}
