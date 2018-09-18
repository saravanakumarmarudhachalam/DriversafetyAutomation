/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */

public class MostDangerousLocationsPage extends AbstractPage
{
    
    @FindBy(xpath = "//span[contains(text(), '= Last 30 days')]")
    public WebElement last30Days;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[1]/div/div/span/a")
    public WebElement approxAddress;
    
    @FindBy(xpath = "//*[@id=\"background-color-wrapper\"]/div[2]/div[1]/ul/li/a[2]/span")
    public WebElement latitudeFilter;
    
    @FindBy(xpath = "//*[@id=\"background-color-wrapper\"]/div[2]/div[1]/ul/li/a[3]/span")
    public WebElement longitudeFilter;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div/div/div/div/span/a")
    public List<WebElement> AppAddress;
    
    @FindBy(xpath = "//div[@id=\"tableChart_19\"]/div/div/div[2]/div[7]/div")
    public WebElement valueOftotalEvents;
    
    @FindBy(id = "xpath-dashboard-canvas")
    public WebElement scroll;
    
    @FindBy(xpath = "//*[contains(@id, 'background-color-wrapper')]/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[6]/label")
    public WebElement LastmonthTimeperiod;
    
    @FindBy(xpath = "//*[contains(@id, 'xpath-apply-prompts')]")
    public WebElement applyButton;
    
  
  //*[@id="tableChart_112"]/div/div/div[2]/div[8]/div/div/span/a
  //*[@id="tableChart_112"]/div/div/div[2]/div[1]/div/div/span/a
        
    /**
     * @param driver
     */
    public MostDangerousLocationsPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    public boolean verifyLastthirtyDaysfilter () throws Exception
    {
	waitForElementPresent(last30Days);
	return last30Days.isDisplayed();
    }
    
    public String getTextthirtyDayfilter () throws Exception
    {
	waitForElementPresent(last30Days);
	return last30Days.getText();
    }
    
    public void clickApproximateaddress() throws Exception
    {
	waitForElementPresent(approxAddress);
	approxAddress.click();
    }
    
    public String checkApproxaddress() throws Exception
    {
	waitForElementPresent(approxAddress);
	String ApproximateAddress;
	ApproximateAddress = approxAddress.getText();
	
	String[] arrSplit_3 = ApproximateAddress.split("\\s"); 
	for (int i=0; i < arrSplit_3.length; i++)
	{ 
	    System.out.println(arrSplit_3[i]); 
	}
	
	return arrSplit_3[2];
	
	
    }
    
    public void checkLatlonFilters(String latlong) throws Exception
    {
	waitForElementPresent(latitudeFilter);
	waitForElementPresent(longitudeFilter);
	String Latitude, Longitude;
	Latitude = latitudeFilter.getText().replace("= ", "");
	Longitude = longitudeFilter.getText().replace("= ", "");
	System.out.println(Latitude + Longitude);
	String latlon = "(" + Latitude +","+ Longitude + ")";
	System.out.println(latlon);
	Assert.assertEquals(latlon, latlong);
	
	
    }
    
    /**
     * Scroll the windows veritically
     */
    public void scrollVertically ()
    {
	checkPageIsReady();
	scroll.click();
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	checkPageIsReady();
	
    }
    
    public int checkNoofRecordsinTable() throws Exception
    {
	checkPageIsReady();
	scrollVertically();
	int NoofAddress = AppAddress.size();
	System.out.println(NoofAddress);
	return NoofAddress;
		
    }
    
    public void checkTotaleventsValue() throws Exception
    {
	checkPageIsReady();
	waitForElementPresent(valueOftotalEvents);
	scrollVertically();
	String tEventsValue;
	tEventsValue = valueOftotalEvents.getText();
	System.out.println(tEventsValue);
	
	last30Days.click();
	LastmonthTimeperiod.click();
	applyButton.click();
	Thread.sleep(10000);
	checkPageIsReady();
	String tEventsValue1;
	tEventsValue1 = valueOftotalEvents.getText();
	System.out.println(tEventsValue1);
	Assert.assertNotEquals(tEventsValue, tEventsValue1);
	
    }
    
}