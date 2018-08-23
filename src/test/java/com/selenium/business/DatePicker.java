package com.selenium.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by utkarshpandey on 4/3/2017.
 */
public class DatePicker {


    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public static void selectdate(WebDriver driver, String month_loc, String year_loc, String tab_name, String month, String year, String date) {

        WebElement monthv = driver.findElement(By.className(month_loc));
        Select monthCombo = new Select(monthv);
        monthCombo.selectByVisibleText(month);

        WebElement yearv = driver.findElement(By.className(year_loc));
        Select yearCombo = new Select(yearv);
        yearCombo.selectByVisibleText(year);
        WebElement dateWidget = driver.findElement(By.className(tab_name));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns) {
            if (cell.getText().equals(date)) {
                cell.click();
                break;
            }
        }


    }
}


