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

import com.trimble.taf.pagefactory.application.SeperatedScorecardPage;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
/**
 * @author smarudh
 */
public class SeperatedScorecardsteps
{

    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public SeperatedScorecardPage seperatedScorecardpage;
    /**
     * @param driver
     */
    public SeperatedScorecardsteps()
    {
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	seperatedScorecardpage = new SeperatedScorecardPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked Dashlet Actions on seperated groups$")
    public void clickDashletaction() throws Throwable
    {	
	seperatedScorecardpage.clickDashletaction();	
	System.out.println("Dashlet Actions arrow clicked");
    }
    
    @And("^I clicked Export As on seperated groups$")
    public void clickExportas() throws Throwable
    {
	seperatedScorecardpage.clickExportasDashletaction();
	System.out.println("Export As in Dashlet Actions clicked");
    }
    
    @And("^I clicked Data to Excel on seperated groups$")
    public void clickDateToexcel() throws Throwable
    {
	seperatedScorecardpage.clickData2excel();
	System.out.println("Data to Excel clicked");
    }
    
    @Then("^Verify Export of the Report on seperated groups$")
    public void verifyExportDatatoExcel() throws Throwable
    {
	Reporter.log(Constants.DATA_TO_EXCEL_IS_SUCCESS);
    }
    
    @Then("^Verify separated groups report opened shows the data for DOVER Group by default$")
    public void veifyDefaultseperatedGroupname() throws Throwable
    {
	Assert.assertEquals("DOVER", seperatedScorecardpage.verifyDefaultgroupName());
	Reporter.log(Constants.DEFAULT_SEPERATE_SCORECARD_GROUP_NAME);
    }
}