package com.seleniumFunc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hello {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MI\\AppData\\Local\\Continuum\\Anaconda3\\chromedriver.exe");
        WebDriver b = new ChromeDriver();
        b.get("http://www.baidu.com");
    }
}
