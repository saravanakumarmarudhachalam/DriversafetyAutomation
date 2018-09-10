/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.trimble.taf.pagefactory.global.AbstractPage;

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
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart_112')]/div/div/div[2]/div/div/div/span/a")
    public List<WebElement> AppAddress;
    
    @FindBy(id = "xpath-dashboard-canvas")
    public WebElement scroll;
    // *[@id="tableChart_112"]/div/div/div[2]/div[8]/div/div/span/a
    // *[@id="tableChart_112"]/div/div/div[2]/div[1]/div/div/span/a
    
    /**
     * @param driver
     */
    public MostDangerousLocationsPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    /**
     * Veryify Last 30days text in the date filter
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyLastthirtyDaysfilter () throws Exception
    {
	waitForElementPresent(last30Days);
	return last30Days.isDisplayed();
    }
    
    /**
     * Get Last 30days text from the Date filter
     * 
     * @return
     * @throws Exception
     */
    public String getTextthirtyDayfilter () throws Exception
    {
	waitForElementPresent(last30Days);
	return last30Days.getText();
    }
    
    /**
     * Click Approximate Address
     * 
     * @throws Exception
     */
    public void clickApproximateaddress () throws Exception
    {
	waitForElementPresent(approxAddress);
	approxAddress.click();
    }
    
    /**
     * Check Approxaddress and separate latlong values
     * 
     * @return
     * @throws Exception
     */
    public String checkApproxaddress () throws Exception
    {
	waitForElementPresent(approxAddress);
	String ApproximateAddress;
	ApproximateAddress = approxAddress.getText();
	
	String[] arrSplit_3 = ApproximateAddress.split("\\s");
	for (int i = 0; i < arrSplit_3.length; i++)
	{
	    System.out.println(arrSplit_3[i]);
	}
	
	return arrSplit_3[2];
	
    }
    
    /**
     * To Check Latlong Filters
     * 
     * @param latlong
     * @throws Exception
     */
    public void checkLatlonFilters (String latlong) throws Exception
    {
	waitForElementPresent(latitudeFilter);
	waitForElementPresent(longitudeFilter);
	String Latitude, Longitude;
	Latitude = latitudeFilter.getText().replace("= ", "");
	Longitude = longitudeFilter.getText().replace("= ", "");
	System.out.println(Latitude + Longitude);
	String latlon = "(" + Latitude + "," + Longitude + ")";
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
    
    /**
     * Check No.of Records in the table
     * 
     * @throws Exception
     */
    public void checkNoofRecordsinTable () throws Exception
    {
	checkPageIsReady();
	scrollVertically();
	System.out.println(AppAddress.size());
	
    }
    
}
