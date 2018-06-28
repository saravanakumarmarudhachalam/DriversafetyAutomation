/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.taf.pagefactory.global.AbstractPage;

import junit.framework.Assert;

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
     * Verify Home link is displayed
     */
    public void verifylnkHomeDisplayed3 ()
    {
	Assert.assertTrue(lblHome.isDisplayed());
	System.out.println("Link for Home is dislayed@@@");
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
	    case "space_Sprint11QA":
		checkPageIsReady();
		space_Sprint11QA.click();
		break;
	    
	    case "space_NAProduction":
		checkPageIsReady();
		space_NAProduction.click();
		break;
	    
	    case "Sprint 18-21 PostgreSQL QA NEW_USERS":
		checkPageIsReady();
		space_Newuser.click();		
		break;
	    case "Sprint 18-23 PostgreSQL QA NEW_USERS":		
		checkPageIsReady();
		space_Sprint18QA.click();		
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