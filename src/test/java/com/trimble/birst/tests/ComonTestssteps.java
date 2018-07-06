/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.LoginPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author smarudh
 */
public class ComonTestssteps
{
    
    
    String lastThirtdaystxt;
    
    String startDate;
    
    String endDate;
    
    public LoginPage loginPage;
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    /**
     * Constructor
     */
    public ComonTestssteps()
    {
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @Given("^I am logged into Application$")
    public void user_is_on_Landing_Page () throws Throwable
    {
	performLoginaction();
    }
    
    @Then("^I validate home page displayed correctly$")
    public void verify_Homepage () throws Throwable
    {
	Assert.assertTrue(mySpacepage.verifyMyspacelbl(),
		Constants.MYSPACE_LBL_DISPLAYED);
	Reporter.log(Constants.MYSPACE_LBL_DISPLAYED);
    }
    
    @And("^I clicked MySpaces & Dashboard$")
    public void clickWorkspace () throws Throwable
    {
	mySpacepage.selectSpace("Sprint 18-23 PostgreSQL QA NEW_USERS");
	mySpacepage.selectOption("optDashboards");
	Assert.assertTrue(driverSafetypage.verifyTrimblepulseImg(),
		Constants.TIMBLE_PULSEIMAGE_DISPLAYED);
	Reporter.log(Constants.TIMBLE_PULSEIMAGE_DISPLAYED);
    }
    
    @When("^I clicked Executive Driversafety console$")
    public void clickExecutivedriverSafetyConsole () throws Throwable
    {
	driverSafetypage.clickExecutidriverSafetyconsole();
    }
    
    @Then("^I validate the Executive Driversafety console page is displayed correctly$")
    public void verifyExecutivedriverSafetyhomePage () throws Throwable
    {
	Assert.assertTrue(driverSafetypage.verifyExectiveconsolePage(),
		Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);
	Reporter.log(Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);
    }
    
    @Then("^I verified Last 30days is displayed in Date filter$")
    public void verifyLastthirtyDaystxt () throws Throwable
    {
	Assert.assertTrue(driverSafetypage.verifyLastthirtyDaysfilter(),
		Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextthirtyDayfilter(),
		"= Last 30 days");
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
    }
    
    @Then("^I verified Last 30days, Startdate and Enddate filter is displayed correctly$")
    public void verifyAlldateFilter () throws Throwable
    {
	lastThirtdaystxt = driverSafetypage.getTextlastThirtydays();
	startDate = driverSafetypage.getTextstartDate();
	endDate = driverSafetypage.getTextendDate();
	Assert.assertTrue(driverSafetypage.verifyThritydaysFilterdisplayed(),
		Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);
	Assert.assertTrue(driverSafetypage.verifyStartdateDisplayed(),
		Constants.STARTDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.STARTDATE_FILTER_DISPLAYED);
	Assert.assertTrue(driverSafetypage.verifyEnddateDisplayed(),
		Constants.ENDDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.ENDDATE_FILTER_DISPLAYED);
    }
    
    @And("^I clicked Foldericon and Individual Scorecard$")
    public void clickIndividualscorecard () throws Throwable
    {
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickIndividualscoreCard();
    }
    
    @And("^I clicked Foldericon and Scorecard Report - combined groups$")
    public void clickCombinedgroups () throws Throwable
    {
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickCombinedscoreCard();
    }
    
    @And("^I clicked Foldericon and Scorecard Report - separated groups$")
    public void clickSeparatedgroups () throws Throwable
    {
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickSeparatedscoreCard();
    }
    
    @Then("^I verified Trimble pulse logo and banner is displayed correctly$")
    public void verifyTrimblepulseLogobanner () throws Throwable
    {
	Assert.assertTrue(driverSafetypage.verifyTrimblelogo(),
		Constants.TRIMBLE_LOGO_DISPLAYED);
	Reporter.log(Constants.TRIMBLE_LOGO_DISPLAYED);
    }
    
    @Then("^I verified the data of Last30days,startdate and enddate after switching one dash board to anotherdashboard is displayed correctly$")
    public void verifyDataforAlldateFilter () throws Throwable
    {
	Assert.assertEquals(
		driverSafetypage.getTextlastThirtydays_Indvscorecard(),
		lastThirtdaystxt, Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextstartDate_Indvscorecard(),
		startDate, Constants.STARTDATEFILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.STARTDATEFILTER_TEXT_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextendDate_Indvscorecard(),
		endDate, Constants.ENDDATEFILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.ENDDATEFILTER_TEXT_DISPLAYED);
    }
    
    public void performLoginaction () throws Exception
    {
	loginPage = new LoginPage(driver);
	loginPage.waitForPageToLoad(driver);
	loginPage.enterUsername(propertyUtils.getProperty("username"));
	loginPage.enterPassword(propertyUtils.getProperty("password"));
	loginPage.clickLogin();
    }
}