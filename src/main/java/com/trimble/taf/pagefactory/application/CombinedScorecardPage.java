/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.trimble.taf.pagefactory.global.AbstractPage;

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
    public WebElement driverSafetyscorecardReport;
    
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
	waitForElementPresent(lastPage);
	lastPage.click();
    }
    
//    /**
//     * Verify Include Inactive Driver
//     * 
//     * @return
//     */
//    public boolean verifyIncludeinactiveDriver ()
//    {
//	checkPageIsReady();
//	waitForElementPresent(driverSafetyscorecardReport);
//	boolean isEmpty = false;
//	for (WebElement datapassUsageRow : driverSafetyscorecardReport)
//	{
//	    if (!datapassUsageRow.getText()
//		    .contains("There are no records at this time"))
//	    {
//		isEmpty = true;
//		break;
//	    }
//	}
//	return isEmpty;
//    }
    
}
