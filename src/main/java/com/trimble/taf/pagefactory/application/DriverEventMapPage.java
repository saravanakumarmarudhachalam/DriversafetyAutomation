/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.trimble.taf.pagefactory.global.AbstractPage;

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
	checkPageIsReady();
	return driverAddressfiltered.getText();
    }
    
    /**
     * Verify Map Dashlet in the Driver Event Maps
     * @return
     */
    public boolean verifyMapdashletDivereventMap(){
	checkPageIsReady();
	checkPageIsReady();
	zoomOut.click();
	zoomOut.click();		
	checkPageIsReady();
	return isElementDisplayed(mapDashleticon);
    }
}
