/**
 * 
 */
package com.trimble.birst.tests;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.CombinedScorecardPage;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
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
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	combinedScorecardpage = new CombinedScorecardPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked Dashlet Actions$")
    public void clickDashletaction() throws Throwable
    {	
	combinedScorecardpage.clickDashletaction();	
	System.out.println("Dashlet Actions arrow clicked");
    }
    
    @And("^I clicked Export As$")
    public void clickExportas() throws Throwable
    {
	combinedScorecardpage.clickExportasDashletaction();
	System.out.println("Export As in Dashlet Actions clicked");
    }
    
    @And("^I clicked Data to Excel$")
    public void clickDateToexcel() throws Throwable
    {
	combinedScorecardpage.clickData2excel();
	System.out.println("Data to Excel clicked");
    }
    
    @Then("^Verify Export of the Report$")
    public void verifyExportDatatoExcel() throws Throwable
    {
	Reporter.log(Constants.DATA_TO_EXCEL_IS_SUCCESS);
    }
}