/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.DriverEventMapPage;
import com.trimble.taf.pagefactory.application.DriverEventsbyLocationpage;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MostDangerousLocationsPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.suite.tests.base.TestRunner;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author smarudh
 */
public class DriverEventbyLocationTestSteps
{
    
    
    String lastThirtdaystxt;
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    public String driverName,driverAddress;
    
    public MostDangerousLocationsPage mostDangerousLocationspage;
    public DriverEventsbyLocationpage driverEventbyLocationpage;
    public DriverEventMapPage driverEventmapPage;
    
    /**
     * @param driver
     */
    public DriverEventbyLocationTestSteps()
    {
	driver = TestRunner.getDriver();
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	driverEventbyLocationpage = new DriverEventsbyLocationpage(driver);
	mostDangerousLocationspage = new MostDangerousLocationsPage(driver);
	driverEventmapPage = new DriverEventMapPage(driver);
	// TODO Auto-generated constructor stub
    }    
    
    @And("^I clicked Driver Events by Location$")
    public void clickDrivereventLocation () throws Throwable
    {
	driverSafetypage.clickDrivereventsBylocation();	
    }
   
    @Then("^I verified AL HIGGS driver and Event date and time in the grid$")
    public void verifyDrivernameAndeventDate () throws Throwable
    {
	driverEventbyLocationpage.verifyDrivernameandEventdate();
    }
    
    @And("^I Selected the AL HIGGS$")
    public void selectAlHiggsDriver () throws Throwable
    {
	driverEventbyLocationpage.selectDriverlist();
	driverEventbyLocationpage.enterDrivername();
	driverEventbyLocationpage.selectDrivernameAttribute();
	driverEventbyLocationpage.clickApplybutton();
    }
    
    @Then("^I verified Map Dashlet is displayed correctly$")
    public void verifyMapdashletDisplayed () throws Throwable
    {
	Assert.assertTrue(driverEventbyLocationpage.verifyMapdashletDisplayed());
    }
    
    @And("^I clicked driver address$")
    public void clickedDriveraddress () throws Throwable
    {
	driverName = driverEventbyLocationpage.getDrivername();
	driverAddress = driverEventbyLocationpage.getDriveraddress();
	driverEventbyLocationpage.clickDriveraddress();	
    }
    
    @Then("^I verified Driver name and Address displayed correctly in Driver Event Map$")
    public void verifyDrivereventHomepage() throws Throwable
    {
	driverSafetypage.waitFornewWindowandSwitchtoIt(driver);
	String driverAddressdriverEventmap=driverEventmapPage.getDriveraddressDrivereventMap().replace("= ", "").replaceAll("\\([^\\(]*\\)", "").replace(" |", "");	
	Assert.assertEquals(driverName, driverEventmapPage.getDrivernameDrivereventMap().replace("= ", ""),Constants.DRIVERNAME_DISPLAYED);
	Assert.assertEquals(driverAddress,driverAddressdriverEventmap,Constants.DRIVERADDRESS_DISPLAYED);
    }
    
    @Then("^I verified Map Dashlet is displayed correctly in Driver Event Map$")
    public void verifyMapdashletDisplayeddriverEventmap () throws Throwable
    {
	Assert.assertTrue(driverEventmapPage.verifyMapdashletDivereventMap());
    }
    
}
