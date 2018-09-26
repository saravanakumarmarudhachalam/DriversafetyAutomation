/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.DriverEventsbyLocationpage;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.EventLocationHotspotMapPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.suite.tests.base.TestRunner;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

/**
 * @author smarudh
 */
public class EventLocationHotspotMapTestSteps
{
    
    String lastThirtdaystxt;
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public EventLocationHotspotMapPage eventLocationhotspotMappage;
    public DriverEventsbyLocationpage driverEventbyLocationpage;
    
    public EventLocationHotspotMapTestSteps()
    {
	driver = TestRunner.getDriver();
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	driverEventbyLocationpage = new DriverEventsbyLocationpage(driver);
	eventLocationhotspotMappage = new EventLocationHotspotMapPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @Then("^I verified Last 30 days is displayed in Date filter in Event Location Hotspot Map$")
    public void verifyTimeperiod () throws Throwable
    {
	Assert.assertTrue(
		eventLocationhotspotMappage.verifyLastthirtyDaysfilter(),
		Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);
	Assert.assertEquals(
		eventLocationhotspotMappage.getTextthirtyDayfilter(),
		"= Last 30 days");
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
    }
    
    @Then("^I changed the time period to last month in the Event Location Hotspot Map$")
    public void verifyTotaleventsValue () throws Throwable
    {	
	eventLocationhotspotMappage.checkTotaleventsValue();
	Reporter.log(Constants.GRID_VALUES_BASEDON_DATEFILTER);
    }
    
    @Then("^I find the number of columns in the Approimate Address table in the Event Location Hotspot Map$")
    public void checkNoOfrecordsInLocationtable () throws Throwable
    {
	Assert.assertEquals(
		eventLocationhotspotMappage.checkNoofRecordsinTable(), 24);
	Reporter.log(Constants.TOTAL_NO_OF_ADDRESS_IN_DANGEROUS_LOCATIONS);
    }
    
    @Then("^I verified the filtered Lat/Long location with the drivers having highest number of Total Events at the top$")
    public void checkTotalevents () throws Throwable
    {
	eventLocationhotspotMappage.verifyTotalvalue();
	Reporter.log(Constants.HIGHEST_TOTAL);
	
    }
    
    @Then("^I click the driver opens the Driver Events By Location report with Date Period filter settings are maintained$")
    public void verifyDrivereventsByLocation () throws Throwable
    {
	eventLocationhotspotMappage.clickDrivername();
	driverSafetypage.waitFornewWindowandSwitchtoIt(driver);
	eventLocationhotspotMappage.verifyDriverEventsByLocation();
	Reporter.log(Constants.DATE_FILTERS_MATCHES);
    }
    
    @Then("^I verified Map dashlet Icon is displayed in the Event Location Hotspot Map$")
    public void verifyMapdashletIcon() throws Throwable
    {	
	Assert.assertTrue(driverEventbyLocationpage.verifyMapdashletDisplayed());
	
    }
}
