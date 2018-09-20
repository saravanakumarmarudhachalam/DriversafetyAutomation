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
import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */
public class DriverEventMapPage extends AbstractPage
{
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[1]/span")
    public WebElement driverNamefiltered;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[4]/span")
    public WebElement driverAddressfiltered;
    
    @FindBy(xpath="//*[@id='undefined']/div[1]/div[2]/div[3]/div/i")
    public WebElement mapDashleticon;
    
    @FindBy(xpath="//*[@id='undefined']/div[2]/div[4]/div[2]/a[2]")
    public WebElement zoomOut;
    
    
    /**
     * @param driver
     */
    public DriverEventMapPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    /**
     * Get text from Driver event map of Driver Name
     * @return
     */
    public String getDrivernameDrivereventMap ()
    {
	return driverNamefiltered.getText();
    }
    
    /**
     * Get text from Driver event map of Driver Address
     * @return
     */
    public String getDriveraddressDrivereventMap ()
    {
	return driverAddressfiltered.getText();
    }
    
    /**
     * Verify Map Dashlet in the Driver Event Maps
     * @return
     */
    public boolean verifyMapdashletDivereventMap(){
	zoomOut.click();
	zoomOut.click();
	checkPageIsReady();
	return isElementDisplayed(mapDashleticon);
    }
}
