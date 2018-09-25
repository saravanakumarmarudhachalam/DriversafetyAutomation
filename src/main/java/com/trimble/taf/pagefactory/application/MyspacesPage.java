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
public class MyspacesPage extends AbstractPage
{
    
    
    @FindBy(id = "bid-header-addspc-btn-btnEl")
    public WebElement btnAddSpace;
    
    @FindBy(xpath = "//*[@id='button-1023-btnEl']")
    public WebElement lblHome;
    
    @FindBy(xpath = "//div[text()='NA Production']")
    public WebElement space_NAProduction;
    
    @FindBy(css = "#gridview-1014 > table > tbody > tr:nth-child(5) > td.x-grid-cell.x-grid-cell-gridcolumn-1012 > div")
    public WebElement space_Newuser;
    
    @FindBy(xpath = "//div[text()='Sprint 11 QA']")
    public WebElement space_Sprint11QA;
    
    @FindBy(xpath = "//div[text()='Sprint 18-23 PostgreSQL QA NEW_USERS']")
    public WebElement space_Sprint18QA;
    
    @FindBy(xpath = "//div[text()='AutomationSpace4']")
    public WebElement automationSpace4;
    
    @FindBy(xpath = "//div[text()='AutomationSpace2']")
    public WebElement automationSpace2;
    
    @FindBy(css = "#component-1069 > p")
    public WebElement optDashboards;
    
    @FindBy(xpath = "//*[text()='Visualizer']")
    public WebElement optVisualizer;
    
    @FindBy(xpath = "//*[text()='Designer']")
    public WebElement optDesigner;
    
    @FindBy(id = "idMySpacesMainContainer_header_hd-textEl")
    public WebElement mySpacelbl;
    
    public MyspacesPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    public void verifyAddSpaceBtn1 ()
    {
	if (btnAddSpace.isEnabled())
	    System.out.println("Add Space Button is enabled");
    }
    
    /**
     * Verify AddSpace Button is enabled
     * 
     * @return
     */
    public boolean verifyAddSpaceBtn2 ()
    {
	return btnAddSpace.isEnabled();
    }
    
    /**
     * Check if Label for Home is displayed
     */
    public void verifyHomeLbl1 ()
    {
	if (lblHome.isDisplayed())
	    System.out.println("Text for Home is displayed");
	String label = lblHome.getText();
	System.out.println(label);
    }
    
    /**
     * Verify Home label is displayed
     * 
     * @return
     */
    public boolean verifyHomeLbl2 ()
    {
	return lblHome.isDisplayed();
    }
    
    /**
     * Check My Space label is displayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyMyspacelbl () throws Exception
    {
	waitForElementPresent(mySpacelbl);
	return mySpacelbl.isDisplayed();
    }
    
    /**
     * Function to select the required Space. SpaceName is the string from home
     * page
     * 
     * @param spaceName
     * @throws Exception
     */
    public void selectSpace (String spaceName) throws Exception
    {
	switch (spaceName)
	{	   
	    case "AutomationSpace2":
		waitForElementPresent(automationSpace2);
		checkPageIsReady();		
		automationSpace2.click();
		break;
	    case "AutomationSpace4":
		waitForElementPresent(automationSpace4);
		checkPageIsReady();		
		automationSpace4.click();
		break;
	}
    }
    
    /**
     * Function to select the required Option i.e. Dashboards, Visualizer or
     * Designer. Option is the string from HomePage
     * 
     * @param option
     * @throws Exception
     */
    public void selectOption (String option) throws Exception
    {
	switch (option)
	{
	    case "optDashboards":
		waitForElementPresent(optDashboards);
		checkPageIsReady();		
		optDashboards.click();
		break;
	    case "optVisualizer":
		optVisualizer.click();
		break;
	    case "optDesigner":
		optDesigner.click();
		break;
	}
    }
}
