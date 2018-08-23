package com.selenium.business;
import com.selenium.testcases.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.business.DatePicker;


import com.selenium.page.Registration_page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




/**
 * Created by utkarshpandey on 4/3/2017.
 */
public class Registration_logic extends Registration_page {
	public String neededVariable;

    public Registration_logic(WebDriver driver) {
        super(driver);
    }


    public void fillform(String pname,String fname,String lname,String month,String year,String date)
    {
        DatePicker obj=new DatePicker(driver);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clicknew().click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select p=new Select(getpname());
        p.selectByVisibleText(pname);
        getfname().sendKeys(fname);
        getlname().sendKeys(lname);
        getdateinput().click();
        obj.selectdate(driver,"ui-datepicker-month","ui-datepicker-year","ui-datepicker-calendar",month,year,date);
    }

    public boolean verifyHint()
    {
    	if(getHint().isDisplayed())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
         }
    public WebElement getHintElement()
    {
    	return getHint();
    }
    
    public String getVariable(){
  	  return neededVariable;
  	}
  public void setVariable(String var){
  	  this.neededVariable = var;
  	}
    

}
