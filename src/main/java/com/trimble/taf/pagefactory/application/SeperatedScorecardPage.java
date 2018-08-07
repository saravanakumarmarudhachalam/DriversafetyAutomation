/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;

/**
 * @author smarudh
 */
public class SeperatedScorecardPage extends AbstractPage
{
    @FindBy(xpath = "//*[@id=\"xpath-dashboard-canvas\"]/div/dashlet/div[1]/div[1]/div[1]/button/i")
    public WebElement dashletActionarrow;
    
    @FindBy(xpath = "//span[contains(text(), 'Export As')]")
    public WebElement dashletExportas;
    
    @FindBy(xpath = "//*[@id=\"xpath-dashboard-canvas\"]/div/div[1]/div/ul/li[2]/ul/li[3]/a")
    public WebElement dataToexcel;
    
    @FindBy(xpath = "//span[contains(text(),\"Report exported successfully\")]")
    public WebElement dashletExportSuccess;
    
    @FindBy(xpath = "//span[contains(text(), 'DOVER')]")
    public WebElement defaultSeperatedgroupName;
    
    /**
     * @param driver
     */
    public SeperatedScorecardPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    /**
     * Click the Dashlet Action arrow
     * @throws Exception
     */
    public void clickDashletaction() throws Exception
    {	
	checkPageIsReady();
	mouseOver(dashletActionarrow);
	//waitForElementPresent(dashletActionarrow);
	dashletActionarrow.click();
    }
    
    /**
     * Click the Export As in the Dashlet Actions
     * @throws Exception
     */
    public void clickExportasDashletaction() throws Exception
    {
	waitForElementPresent(dashletExportas);
	dashletExportas.click();
    }
    
    /**
     * Click the Date to excel in the Dashlet Actions
     * @throws Exception
     */
    public void clickData2excel() throws Exception
    {
	dataToexcel.click();
    }
    
    public boolean verifyDashletexportSuccess() throws Exception
    {
	waitForElementPresent(dashletExportSuccess);
	return(dashletExportSuccess.isDisplayed()); 
    }
    
    public void verifyDefaultgroupName() throws Exception
    {
	waitForElementPresent(defaultSeperatedgroupName);
	Assert.assertEquals("DOVER", defaultSeperatedgroupName.getText());
	
    }
}
    