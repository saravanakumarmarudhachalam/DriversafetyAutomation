/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.List;

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
public class CombinedScorecardPage extends AbstractPage
{
    
    
    @FindBy(xpath = "//*[@id=\"xpath-dashboard-canvas\"]/div/dashlet/div[1]/div[1]/div[1]/button/i")
    public WebElement dashletActionarrow;
    
    @FindBy(xpath = "//span[contains(text(), 'Export As')]")
    public WebElement dashletExportas;
    
    @FindBy(xpath = "//*[@id=\"xpath-dashboard-canvas\"]/div/div[1]/div/ul/li[2]/ul/li[3]/a")
    public WebElement dataToexcel;
    
    @FindBy(xpath = "//span[contains(text(),\"Report exported successfully\")]")
    public WebElement dashletExportSuccess;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(3) > span")
    public WebElement includeInactivedriver;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(3) > div > h1")
    public WebElement includeInactivedriverOption;
    
    @FindBy(css = "label[data-title='Yes']")
    public WebElement includeInactivedriverYesoption;
    
    @FindBy(id = "xpath-apply-prompts")
    public WebElement applyButton;
    
    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet > div.dashlet-wrapper.ng-scope > ul > li:nth-child(5) > a")
    public WebElement lastPage;
    
    @FindBy(xpath = "//*[@id='xpath-dashboard-canvas']/div/dashlet/div[1]/report/designer-report/div[1]/span")
    public List<WebElement> driverSafetyscorecardReport;
    
    @FindBy(xpath = "//*[@id='global-header']/header/ng-include/div/div/ul/li[6]/a/i")
    public WebElement filterOption;
    
    @FindBy(xpath = "//span[contains(text(), 'Org Unit')]")
    public WebElement orgUnitoptions;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[1]/label")
    public WebElement dumpTrucksDEoptions;
    
    @FindBy(xpath = "//*[@id='xpath-dashboard-canvas']/div/dashlet/div[1]/ul/li[4]/a")
    public WebElement nextPage;
    
    @FindBy(xpath = "//span[contains(text(), 'DUMP TRUCKS DE')]")
    public List<WebElement> dumpTrucksdeTxt;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[1]")
    public WebElement driverSafetylowerTarget;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/input")
    public WebElement driverSafetytargetValue;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[2]")
    public WebElement driverSafetyHightarget;
    
    /**
     * @param driver
     */
    public CombinedScorecardPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    /**
     * Click the Dashlet Action arrow
     * 
     * @throws Exception
     */
    public void clickDashletaction () throws Exception
    {
	checkPageIsReady();
	mouseOver(dashletActionarrow);
	// waitForElementPresent(dashletActionarrow);
	dashletActionarrow.click();
    }
    
    /**
     * Click the Export As in the Dashlet Actions
     * 
     * @throws Exception
     */
    public void clickExportasDashletaction () throws Exception
    {
	waitForElementPresent(dashletExportas);
	dashletExportas.click();
    }
    
    /**
     * Click the Date to excel in the Dashlet Actions
     * 
     * @throws Exception
     */
    public void clickData2excel () throws Exception
    {
	dataToexcel.click();
    }
    
    /**
     * Verify Dashlet Export is success
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyDashletexportSuccess () throws Exception
    {
	waitForElementPresent(dashletExportSuccess);
	return (dashletExportSuccess.isDisplayed());
    }
    
    /**
     * Click YES option for Include inactive driver
     * 
     * @throws Exception
     */
    public void clickIncludeinactiveDriver () throws Exception
    {
	waitForElementPresent(includeInactivedriver);
	if (!includeInactivedriver.getText().equals("= Yes"))
	{
	    includeInactivedriver.click();
	    includeInactivedriverOption.click();
	    waitForElementPresent(includeInactivedriverYesoption);
	    includeInactivedriverYesoption.click();
	    applyButton.click();
	}
    }
    
    /**
     * Click last Page
     * 
     * @throws Exception
     */
    public void clickLastpage () throws Exception
    {
	checkPageIsReady();
	waitForElementPresent(lastPage);
	lastPage.click();
    }
    
    /**
     * Verify Include Inactive Driver
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyIncludeinactiveDriver () throws Exception
    {
	checkPageIsReady();
	waitForElementPresent(driverSafetyscorecardReport);
	boolean isEmpty = false;
	for (WebElement datapassUsageRow : driverSafetyscorecardReport)
	{
	    if (datapassUsageRow.getText().isEmpty())
	    {
		
		isEmpty = true;
		break;
	    }
	}
	return isEmpty;
    }
    
    /**
     * Click Filter Options
     * 
     * @throws Exception
     */
    public void clickFilteroption () throws Exception
    {
	waitForElementPresent(filterOption);
	filterOption.click();
    }
    
    /**
     * Click Org Units
     * 
     * @throws Exception
     */
    public void clickOrgunit () throws Exception
    {
	waitForElementPresent(orgUnitoptions);
	orgUnitoptions.click();
    }
    
    /**
     * Select Dump Trucks DE
     * 
     * @throws Exception
     */
    public void selectDumpTrucksDE () throws Exception
    {
	waitForElementPresent(dumpTrucksDEoptions);
	dumpTrucksDEoptions.click();
    }
    
    /**
     * Click Apply button
     * 
     * @throws Exception
     */
    public void clickApplybutton () throws Exception
    {
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * Click Next button
     * 
     * @throws Exception
     */
    public void clickNextpage () throws Exception
    {
	checkPageIsReady();
	waitForElementPresent(nextPage);
	nextPage.click();
    }
    
    /**
     * Verify DUMP TRUCKS DE data is displayed
     */
    public void verifyDumptrucksTextdisplayed ()
    {
	checkPageIsReady();
	String actualText = "DUMP TRUCKS DE";
	for (int i = 0; i < dumpTrucksdeTxt.size(); i++)
	{
	    if (dumpTrucksdeTxt.get(i).getText().contains(actualText))
	    {
		ProLogger.info("DUMP TRUCKS DE data's displayed correctly");
	    }
	    else
	    {
		Assert.fail("DUMP TRUCKS DE data's is not displayed correctly");
	    }
	}
    }
    
    /**
     * Click Driver safety Lower target dropdown
     * 
     * @throws Exception
     */
    public void clickDriversafetyLowertarget () throws Exception
    {
	waitForElementPresent(driverSafetylowerTarget);
	driverSafetylowerTarget.click();
    }
    
    /**
     * Click Driver safety High Target dropdown
     * 
     * @throws Exception
     */
    public void clickDriversafetyHightarget () throws Exception
    {
	waitForElementPresent(driverSafetyHightarget);
	driverSafetyHightarget.click();
    }
    
    /**
     * Enter the Lower Target value
     * 
     * @throws Exception
     */
    public void enterLowtargetValue () throws Exception
    {
	waitForElementPresent(driverSafetytargetValue);
	driverSafetytargetValue.clear();
	driverSafetytargetValue.click();
	driverSafetytargetValue.sendKeys("55");
	applyButton.click();
	checkPageIsReady();
    }
    
    /**
     * Enter the High target value
     * 
     * @throws Exception
     */
    public void enterHightargetValue () throws Exception
    {
	waitForElementPresent(driverSafetytargetValue);
	driverSafetytargetValue.clear();
	driverSafetytargetValue.click();
	driverSafetytargetValue.sendKeys("75");
	applyButton.click();
	checkPageIsReady();
    }
    
    /**
     * Verify color coded in the driver safety filter
     * 
     * @throws InterruptedException
     */
    public void verifyColorcodedTargetfilter () throws InterruptedException
    {
	checkPageIsReady();
	for (int i = 0; i < driverSafetyscorecardReport.size(); i++)
	{
	    String rgbColor = driverSafetyscorecardReport.get(i)
		    .getCssValue("background-color");
	    if (rgbColor.equals("rgba(255, 255, 255, 1)")
		    || rgbColor.equals("rgba(0, 0, 0, 0)")
		    || rgbColor.equals("rgba(0, 0, 0, 1)")
		    || rgbColor.equals("rgba(230, 230, 230, 1)")
		    || rgbColor.equals("rgba(204, 255, 204, 1)")
		    || rgbColor.equals("rgba(255, 255, 0, 1)")
		    || rgbColor.equals("rgba(255, 0, 0, 1)"))
	    {
		ProLogger.info(Constants.DRIVER_SAFETY_COLOR_CODED);
	    }
	    else
	    {
		Assert.fail(
			"Driver safety Color coded is not displayed correctly");
	    }
	    
	}
    }
    
    /**
     * Verify the value should display without decimal point
     */
    public void verifyWOdecimalPoint ()
    {
	checkPageIsReady();
	for (int i = 0; i < driverSafetyscorecardReport.size(); i++)
	{
	    String rgbColor = driverSafetyscorecardReport.get(i)
		    .getCssValue("background-color");
	    if (rgbColor.equals("rgba(204, 255, 204, 1)")
		    || rgbColor.equals("rgba(255, 0, 0, 1)")
		    || rgbColor.equals("rgba(255, 255, 0, 1)"))
	    {
		String value = driverSafetyscorecardReport.get(i).getText().replace("%", "");		
		Double j = Double.parseDouble(value);
		try
		{
		    if (j % 1 == 0)
		    {
			ProLogger.info(
				Constants.GRIDVALUES_DISPLAYED_WODECMIAL_VALUE);
		    }
		}
		catch (Exception e)
		{
		    Assert.fail(
			    Constants.GRIDVALUES_DISPLAYED_WITHDECMIAL_VALUE);
		}
	    }
	}
    }
}
