/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.CombinedScorecardPage;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.IndividualScorecardpage;
import com.trimble.taf.pagefactory.application.LoginPage;
import com.trimble.taf.pagefactory.application.MostDangerousLocationsPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.suite.tests.base.TestRunner;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author smarudh
 */
public class MostDangerousLocationsTestSteps
{       
    String lastThirtdaystxt;
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public MostDangerousLocationsPage mostDangerousLocationspage;
    
    /**
     * @param driver
     */
    public MostDangerousLocationsTestSteps()
    {
	driver = TestRunner.getDriver();
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	mostDangerousLocationspage = new MostDangerousLocationsPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @Then("^I verified Last 30 days is displayed in Date filter in Most Dangerous Locations report$")
    public void verifyTimeperiod() throws Throwable
    {
	Assert.assertTrue(mostDangerousLocationspage.verifyLastthirtyDaysfilter(),
		Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);
	Assert.assertEquals(mostDangerousLocationspage.getTextthirtyDayfilter(),
		"= Last 30 days");
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
    }
    
    @Then("^I click on approx address link to drill down to 'Event Location Hotspot Map'$")
    public void clickApproxaddress() throws Throwable
    {
	mostDangerousLocationspage.clickApproximateaddress();
	String latlong = mostDangerousLocationspage.checkApproxaddress();
	mostDangerousLocationspage.approxAddress.click();
	driverSafetypage.waitFornewWindowandSwitchtoIt(driver);
	mostDangerousLocationspage.checkLatlonFilters(latlong);
	Reporter.log(Constants.VERIFICATED_SUCCESSFULLY);
	
    }
    
    @Then("^I find the number of columns in the Approimate Address table$")
    public void checkNoOfrecordsInLocationtable() throws Throwable
    {
	Assert.assertEquals(mostDangerousLocationspage.checkNoofRecordsinTable(),10);
	Reporter.log(Constants.TOTAL_NO_OF_ADDRESS_IN_DANGEROUS_LOCATIONS);
	
    }
}
    
