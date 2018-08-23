package com.selenium.base_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Created by utkarshpandey on 4/3/2017.
 */
public class Base {

    public WebDriver driver=null;

    public WebDriver getDriver()
    {
    	System.setProperty("webdriver.chrome.driver","C:\\bin\\chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("test-type");
        //options.addArguments("--start-maximized");
        //options.addArguments("--js-flags=--expose-gc");
        //options.addArguments("--enable-precise-memory-info");
        //options.addArguments("--disable-popup-blocking");
        //options.addArguments("--disable-default-apps");
        //options.addArguments("test-type=browser");
        //options.addArguments("disable-infobars");

        driver =new ChromeDriver();
       
        //options.addArguments("start-maximized");
        //WebDriver driver = new ChromeDriver();
        return driver;
    }
}
