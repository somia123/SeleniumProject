package com.selenium.testcases;


import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base_page.Base;
import com.selenium.business.Registration_logic;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

/**
 * Created by utkarshpandey on 4/3/2017.
 *
 */

public class Registration_failure

{

	//ExtentReports extent;
    //ExtentTest test;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentTestInterruptedException testexception;
    public static String newUrl;
    @BeforeTest
    public void config()
    {
    
    extent = ExtentManager.Instance();
    }
    
    
    @Test(dataProvider="testdata")
    public void test01(String pname1,String fname1,String lname1,String month1,String year1,String date1) throws InterruptedException {
    	/*ExtentReports extent;
        ExtentTest test;
        extent = ExtentManager.Instance(); */
       
        Base b = new Base();
        int i=1;
        WebDriver driver = b.getDriver();
        driver.manage().window().maximize();
        /*ATUReports.setWebDriver(driver);
         * */
        test = extent.startTest("Test 1", "First Test Case Execution");
        Registration_logic logic = PageFactory.initElements(driver, Registration_logic.class);
        String url = "http://passportindia.gov.in/AppOnlineProject/welcomeLink";
        driver.get(url);
        newUrl=url;
        System.out.println(pname1);
        //logic.fillform("Bengaluru","somya","chaudhry","Mar","1990","2");
    
        logic.fillform(pname1,fname1,lname1,month1,year1,date1);
        
        /*if(driver.findElement(By.xpath("//*[@id='frmSample']/table/tbody/tr[14]/td[1]/label[contains(text(),Hint)]/span[contains(text(),*)]")).isDisplayed())
		{
	
	   new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id='frmSample']/table/tbody/tr[14]/td[1]/label[contains(text(),Hint)]/span[contains(text(),*)]"))).perform();
	   i++;
	   test.log(LogStatus.INFO, "Its a mandatory field");
	   String screenshotpath=ExtentManager.CaptureScreen(driver,"Registration_failure"+Integer.toString(i));
	   test.log(LogStatus.INFO,"Screenshot below:"+ test.addScreenCapture(screenshotpath));
		
		}*/
        System.out.println("1111111111111111111");
        test.log(LogStatus.INFO, "Registration form filling done");
        System.out.println("1111112221111111");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.resizeTo(1366, 768);");
        String screenshotpath=ExtentManager.CaptureScreen(driver,"Registration_failure"+Integer.toString(i));
        test.log(LogStatus.INFO,"Screenshot below:"+ test.addScreenCapture(screenshotpath));
        i++;

        if(driver.findElement(By.linkText("Check Availability")).isDisplayed())
        {
            screenshotpath=ExtentManager.CaptureScreen(driver,"Registration_failure"+Integer.toString(i));
            test.log(LogStatus.PASS,"Link is displayed properly:"+ test.addScreenCapture(screenshotpath));
        }
            
           
        
        

            Assert.assertFalse("Dropdown is not selected",driver.findElement(By.id("hintQues")).isSelected());
            i++;
            screenshotpath=ExtentManager.CaptureScreen(driver,"Registration_failure"+Integer.toString(i));
            test.log(LogStatus.PASS,"Assert Failed:"+ test.addScreenCapture(screenshotpath));
            

            if(logic.verifyHint())
            {
            	WebElement element = logic.getHintElement();
            	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            	Thread.sleep(500); 
            	i++;
            	screenshotpath=ExtentManager.CaptureScreen(driver,"Registration_failure"+Integer.toString(i));
            	test.log(LogStatus.INFO,"Screenshot below:"+ test.addScreenCapture(screenshotpath));
            }
            extent.endTest(test);
            
            logic.setVariable(url);
        //extent.flush();
        //extent.close();
        driver.close();
        
        //driver.
        //Please enter Login Id.
        //ATUReports.add("Form Filled", LogAs.INFO,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

    }
    
    @Test				
	public void testEasy() {	
   

        Base b = new Base();
        int i=1;
        WebDriver driver = b.getDriver();
        
        driver.manage().window().maximize();
        Registration_logic logic = PageFactory.initElements(driver, Registration_logic.class);
        /*ATUReports.setWebDriver(driver);
         * */
        test = extent.startTest("Test 2", "Second test case execution");
       
		driver.get(newUrl);  
		String title = driver.getTitle();
		System.out.println("the value of url is:"+ newUrl);
		String screenshotpath=ExtentManager.CaptureScreen(driver,"NewTest"+Integer.toString(i));
		System.out.println(screenshotpath);
		//Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		test.log(LogStatus.PASS,"Assert Passed:"+ test.addScreenCapture(screenshotpath));
		extent.endTest(test);
		/*extent.flush();
        extent.close();*/
		driver.close();
	}	
    
    @AfterTest
    public void endReport(){
    	extent.flush();
        extent.close();
    }
    @DataProvider(name="testdata")
    public Object[][] TestDataFeed()
    {
     
    String Path = System.getProperty("user.dir")+"\\Excel.xlsx";
    DataDriven config = new DataDriven(Path);
     
    int rows = config.getRowCount(0);
     System.out.println("value of rows is");
     System.out.println(rows-1);
    Object[][] data = new Object[rows-1][6];
    
   for(int i=0;i<rows-1;i++)
    {
    data[i][0] = config.getData(0, i+1, 0);
    System.out.println(data[i][0]);
    data[i][1] = config.getData(0, i+1, 1);
    System.out.println(data[i][1]);
    data[i][2] = config.getData(0, i+1, 2);
    System.out.println(data[i][2]);
    data[i][3] = config.getData(0, i+1, 3);
    System.out.println(data[i][3]);
    data[i][4] = config.getData(0, i+1, 4);
    System.out.println(data[i][4]);
    data[i][5] = config.getData(0, i+1, 5);
    System.out.println(data[i][5]);
    }
     
    return data;
    }
    
   }
    
			
			
	
    
  


