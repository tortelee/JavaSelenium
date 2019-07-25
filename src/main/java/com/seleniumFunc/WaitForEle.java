package com.seleniumFunc;

/**
 * 这里主要使用
 *    WebDriveWait来等待一定找到目标
 * 要用异常处理下
 *     防止最后这样做也没找到元素
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForEle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\MI\\AppData\\Local\\Continuum\\Anaconda3\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();

        wd.get("http://www.newsmth.net/nForum/#!article/WorkLife/2014215");
        By by = new By.ByClassName("a-u-name");
        try{
        WebDriverWait webDriverWait = new WebDriverWait(wd,10);
        WebElement s = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        System.out.println(s.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
