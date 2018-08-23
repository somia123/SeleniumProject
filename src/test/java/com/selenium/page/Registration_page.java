package com.selenium.page;

import com.selenium.base_page.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by utkarshpandey on 4/3/2017.
 */

public class Registration_page extends Base {

    public WebDriver driver;
    public Registration_page(WebDriver driver) {
        this.driver=driver;

    }
    public WebElement clicknew()
    {
        return(driver.findElement(By.cssSelector("div.main_button_typ_002 > div")));
    }
    public WebElement getpname()
    {
        return(driver.findElement(By.className("dropdown-box")));

    }

    public WebElement getfname()
    {
        return(driver.findElement(By.name("givenName")));

    }

    public WebElement getlname()
    {
        return(driver.findElement(By.name("surname")));
    }

    public WebElement getemail()
    {
        return(driver.findElement(By.name("email")));
    }
    public WebElement registerbutton()
    {
        return(driver.findElement(By.name("register")));
    }

    public WebElement getdateinput()
    {
        return(driver.findElement(By.id("dob")));
    }

    public WebElement getHint()
    {
        return(driver.findElement(By.xpath("//*[@id='frmSample']/table/tbody/tr[14]/td[1]/label[contains(text(),Hint)]/span[contains(text(),*)]")));
    }
   




}
