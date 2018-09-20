/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */
public class DriverEventsbyLocationpage extends AbstractPage
{
    
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[1]/span")
    public WebElement selectDriver;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/div/search-panel/form/div[1]/input")
    public WebElement searchAttributeTxtbox;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[1]/label")
    public WebElement driverNamecheckBox;
    
    @FindBy(id = "xpath-apply-prompts")
    public WebElement applyButton;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div/div/div")
    public List<WebElement> driverNameandAddress;
    
    @FindBy(xpath = "//*[@id='undefined']/div[1]/div[2]/div[3]/div/i")
    public WebElement mapDashlet;
    
    @FindBy(xpath = "//*[@id='undefined']/div[2]/div[4]/div[2]/a[2]")
    public WebElement zoomOut;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[1]/div/div/span/a")
    public WebElement driverName;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[6]/div/div/span/a")
    public WebElement driverAddress;
    
    /**
     * @param driver
     */
    public DriverEventsbyLocationpage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    /**
     * Select Driver Name from the list
     * 
     * @throws Exception
     */
    public void selectDriverlist () throws Exception
    {
	waitForElementPresent(selectDriver);
	selectDriver.click();
    }
    
    /**
     * Enter the Driver name from the attribute list
     * 
     * @throws Exception
     */
    public void enterDrivername () throws Exception
    {
	waitForElementPresent(searchAttributeTxtbox);
	searchAttributeTxtbox.clear();
	searchAttributeTxtbox.sendKeys("AL HIGGS");
	checkPageIsReady();
    }
    
    /**
     * Click Radio button from selected Driver
     * 
     * @throws Exception
     */
    public void selectDrivernameAttribute () throws Exception
    {
	waitForElementPresent(driverNamecheckBox);
	driverNamecheckBox.click();
    }
    
    /**
     * Click Apply Button
     * 
     * @throws Exception
     */
    public void clickApplybutton () throws Exception
    {
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * Verify Event Start date and Time
     */
    public void verifyDrivernameandEventdate ()
    {
	checkPageIsReady();
	List<String> acutalResult = new ArrayList<String>();
	for (int i = 0; i < driverNameandAddress.size(); i++)
	{
	    List<WebElement> allCells = driverNameandAddress.get(i)
		    .findElements(By.tagName("span"));
	    acutalResult.add(allCells.get(0).getText());
	}
	System.out.println("Actual Result:" + acutalResult);
	for (String expected : acutalResult)
	{
	    try
	    {
		if (expected.contains("AL HIGGS")
			|| expected.contains("08/21/2018"))
		{
		    ProLogger.info(
			    Constants.DRIVERNAME_EVENTDATE_DISPLAYED);
		}
	    }
	    catch (Exception e)
	    {
		Assert.fail(Constants.DRIVERNAME_EVENTDATE_NOT_DISPLAYED);
	    }
	}
    }
    
    /**
     * Verify Map Dashlet element is displayed
     * 
     * @return
     */
    public boolean verifyMapdashletDisplayed ()
    {
	checkPageIsReady();
	zoomOut.click();
	checkPageIsReady();
	return isElementDisplayed(mapDashlet);
	
    }
    
    /**
     * Get text of driver name
     * 
     * @return
     */
    public String getDrivername ()
    {
	return driverName.getText();
    }
    
    /**
     * Get Text of driver address
     * 
     * @return
     */
    public String getDriveraddress ()
    {
	return driverAddress.getText();
    }
    
    /**
     * Click Driver Address
     */
    public void clickDriveraddress ()
    {
	driverAddress.click();
	checkPageIsReady();
    }
}
