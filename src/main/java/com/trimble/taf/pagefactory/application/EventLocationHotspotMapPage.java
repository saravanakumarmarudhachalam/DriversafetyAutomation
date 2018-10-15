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
public class EventLocationHotspotMapPage extends AbstractPage
{
    
    
    @FindBy(xpath = "//span[contains(text(), '= Last 30 days')]")
    public WebElement last30Days;
    
    @FindBy(xpath = "//span[contains(text(), '= Last month')]")
    public WebElement lastMonth;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[7]/div/div/span")
    public WebElement valueOftotalEvents;
    
    @FindBy(xpath = "//*[contains(@id, 'background-color-wrapper')]/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[6]/label")
    public WebElement LastmonthTimeperiod;
    
    @FindBy(xpath = "//*[contains(@id, 'xpath-apply-prompts')]")
    public WebElement applyButton;
    
    @FindBy(id = "xpath-dashboard-canvas")
    public WebElement scroll;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div/div/div/span/a")
    public List<WebElement> AppAddress;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[1]/div/div/span")
    public WebElement firstAddress;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[2]/div/div/span/a")
    public WebElement firstAddresslink;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[7]/div/div/span")
    public WebElement firstTotalvalue;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[14]/div/div/span")
    public WebElement secondTotalvalue;
    
    @FindBy(xpath = "//div[contains(@id, 'tableChart')]/div/div/div[2]/div[21]/div/div/span")
    public WebElement thirdTotalvalue;
    
    @FindBy(xpath="//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[11]/label")
    public WebElement last30DaysradioBtn;
    
    @FindBy(xpath="//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[4]/label")
    public WebElement lastQuarterradioBtn;
    
    @FindBy(xpath="//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[2]/span")
    public WebElement lastQuarterValue;
    
    public static String last30DaysValue;
    
    /**
     * @param driver
     */
    public EventLocationHotspotMapPage(WebDriver driver)
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
    
    public void scrollVertically ()
    {
	checkPageIsReady();
	scroll.click();
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	checkPageIsReady();
    }
    
    public void scrollUp ()
    {
	checkPageIsReady();
	scroll.click();
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_UP).build().perform();
	checkPageIsReady();
    }
    
    public void checkTotaleventsValue () throws Exception
    {
	
	checkPageIsReady();
	waitForElementPresent(valueOftotalEvents);
	scrollVertically();
	String tEventsValue;
	tEventsValue = valueOftotalEvents.getText();
	last30Days.click();
	checkPageIsReady();
	lastQuarterradioBtn.click();
	applyButton.click();
	checkPageIsReady();
	scrollUp();
	String tEventsValue1;
	tEventsValue1 = valueOftotalEvents.getText();	
	Assert.assertNotEquals(tEventsValue, tEventsValue1);
    }
    
    /**
     * Check No.of Records in the table
     * 
     * @throws Exception
     */
    public int checkNoofRecordsinTable () throws Exception
    {
	int NoofAddress = AppAddress.size();	
	return NoofAddress;
    }
    
    public void verifyTotalvalue () throws Exception
    {
	Double FirstValue = Double.parseDouble(firstTotalvalue.getText());
	Double SecValue = Double.parseDouble(secondTotalvalue.getText());
	Double ThirdValue = Double.parseDouble(thirdTotalvalue.getText());
	Assert.assertTrue(FirstValue >= SecValue);
	Assert.assertTrue(FirstValue >= ThirdValue);
    }
    
    public void clickDrivername () throws Exception
    {
	checkPageIsReady();
	lastQuarterValue.click();
	checkPageIsReady();
	last30DaysradioBtn.click();
	applyButton.click();
	last30DaysValue = last30Days.getText();
	checkPageIsReady();
	firstAddresslink.click();	
    }
    
    public void verifyDriverEventsByLocation () throws Exception
    {
	checkPageIsReady();
	checkPageIsReady();
	scrollVertically();
	Assert.assertEquals(last30Days.getText(), last30DaysValue);	
    }
    
}
