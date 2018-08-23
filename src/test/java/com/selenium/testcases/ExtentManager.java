package com.selenium.testcases;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


/**
 * Created by utkarshpandey on 7/19/2017.
 */
public class ExtentManager
{
    public static ExtentReports Instance()
    {
        ExtentReports extent;
        String Path = System.getProperty("user.dir")+"\\ExtentReport.html";
        System.out.println("Path for Reports is" + Path);
        System.out.println(Path);
        extent = new ExtentReports(Path, true);
        String path=System.getProperty("user.dir");
        System.out.println("Path for user.dir is" + path);
        extent.loadConfig(new File(System.getProperty("user.dir")+".//src//test//ReportsConfig.xml"));
        return extent;
    }
    public static String CaptureScreen(WebDriver driver, String ImageName) {
        System.out.println("inside capture screen method");
        TakesScreenshot ts = (TakesScreenshot) driver;
        System.out.println("before file source");
        File source=ts.getScreenshotAs(OutputType.FILE);
        System.out.println("after file source");
        String dest=System.getProperty("user.dir") + "/Screenshots/" +ImageName +".jpg";
        System.out.println("path for destination is "+ dest);

        File oDest = new File(dest);
        try {
            System.out.println("Inside try");
            FileUtils.copyFile(source,oDest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return dest;

    }
    }

