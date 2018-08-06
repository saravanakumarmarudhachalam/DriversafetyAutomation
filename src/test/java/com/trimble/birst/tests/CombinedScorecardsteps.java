/**
 * 
 */
package com.trimble.birst.tests;

import java.io.IOException;
/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.CombinedScorecard;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.IndividualScorecardpage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
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
    
    public CombinedScorecard combinedScorecard;
    /**
     * @param driver
     */
    public CombinedScorecardsteps(WebDriver driver)
    {
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	combinedScorecard = new CombinedScorecard(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked Dashlet Actions$")
    public void clickDashletaction() throws Throwable
    {
	
	combinedScorecard.clickDashletaction();	
	System.out.println("Dashlet Actions arrow clicked");
    }
    
    @And("^I clicked Export As$")
    public void clickExportas() throws Throwable
    {
	combinedScorecard.clickExportasDashletaction();
	System.out.println("Export As in Dashlet Actions clicked");
    }
    
    @And("^I clicked Data to Excel$")
    public void clickDateToexcel() throws Throwable
    {
	combinedScorecard.clickData2excel();
	System.out.println("Data to Excel clicked");
    }
    
    @Then("^Verify Export of the Report$")
    public void verifyExportDatatoExcel() throws Throwable
    {
	Reporter.log(Constants.DATA_TO_EXCEL_IS_SUCCESS);
    }
}