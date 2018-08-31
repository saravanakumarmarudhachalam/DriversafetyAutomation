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
    
    @FindBy(xpath = "//span[contains(text(), 'ALLAN MYERS')]")
    public WebElement defaultSeperatedgroupName;
    
    @FindBy(xpath="//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[4]/span")
    public WebElement groupNamedisplayed;
    
    @FindBy(xpath ="//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[4]/div/h1")
    public WebElement organizationalLevelname;
    
    @FindBy(xpath ="//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/div/search-panel/form/div[1]/label")
    public WebElement selectAllcheckbox;
    
    @FindBy(xpath ="//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[2]/label")
    public WebElement doverCheckbox;
    
    @FindBy(id="xpath-apply-prompts")
    public WebElement applyButton;
    
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
    
    /**
     * Verify Excel report has been exported sucessfully
     * @return
     * @throws Exception
     */
    public boolean verifyDashletexportSuccess() throws Exception
    {
	waitForElementPresent(dashletExportSuccess);
	return(dashletExportSuccess.isDisplayed()); 
    }
    
    /**
     * Verify Default group name is displayed correctly
     * @return
     * @throws Exception
     */
    public String verifyDefaultgroupName() throws Exception
    {
//	if(!defaultSeperatedgroupName.getText().contains("DOVERS")){
//	    waitForElementPresent(groupNamedisplayed);
//	    groupNamedisplayed.click();
//	    waitForElementPresent(organizationalLevelname);
//	    organizationalLevelname.click();
//	    waitForElementPresent(selectAllcheckbox);
//	    selectAllcheckbox.click();
//	    selectAllcheckbox.click();
//	    doverCheckbox.click();
//	    applyButton.click();	    
//	}
	waitForElementPresent(defaultSeperatedgroupName);
	return defaultSeperatedgroupName.getText();
    }
}
    