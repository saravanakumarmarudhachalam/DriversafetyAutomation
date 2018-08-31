/**
 * 
 */
package com.trimble.birst.tests;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.CombinedScorecardPage;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.suite.tests.base.TestRunner;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author smarudh
 */
public class CombinedScorecardsteps
{
    
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public CombinedScorecardPage combinedScorecardpage;
    
    /**
     * @param driver
     */
    public CombinedScorecardsteps()
    {
	driver = TestRunner.getDriver();
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	combinedScorecardpage = new CombinedScorecardPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked Dashlet Actions on combined groups$")
    public void clickDashletaction () throws Throwable
    {
	combinedScorecardpage.clickDashletaction();	
    }
    
    @And("^I clicked Export As on combined groups$")
    public void clickExportas () throws Throwable
    {
	combinedScorecardpage.clickExportasDashletaction();	
    }
    
    @And("^I clicked Data to Excel on combined groups$")
    public void clickDateToexcel () throws Throwable
    {
	combinedScorecardpage.clickData2excel();	
    }
    
    @Then("^Verify Export of the Report on combined groups$")
    public void verifyExportDatatoExcel () throws Throwable
    {
	Reporter.log(Constants.DATA_TO_EXCEL_IS_SUCCESS);
    }
    
    @And("^I checked Include Active Drivers as YES$")
    public void checkIncludeactiveDriver () throws Throwable
    {
	combinedScorecardpage.clickIncludeinactiveDriver();
    }
    
    @And("^I navigate to last page$")
    public void navigateTolastPage () throws Throwable
    {
	combinedScorecardpage.clickLastpage();
    }
    
    @Then("^I verified  Include inactive Drivers are displayed$")
    public void verifyIncludeinactiveDriverdisplayed () throws Throwable
    {
	Assert.assertTrue(combinedScorecardpage.verifyIncludeinactiveDriver(),Constants.INCLUDE_INACTIVE_DRIVERS_DISPLAYED);
    }
    
}
