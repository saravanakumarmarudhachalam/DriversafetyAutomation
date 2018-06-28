/**
 * 
 */
package com.trimble.birst.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.suite.tests.base.BaseTest;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */
public class CommonTests extends BaseTest
{
    
    private MyspacesPage mySpacepage;
    
    private DriverSafetyPage driverSafetypage;
    
    /**
     * Verify dashboards are set to display data for 'Last 30 Days' by default
     * (where applicable)
     * 
     * @throws Exception
     */
    @Test
    public void verifyDashboardThirtydayFilter () throws Exception
    {
	
	ProLogger.info("Verify dashboards are set to display data for 'Last 30 Days' by default (where applicable)");
	ProLogger.info(	"Test Case : Verify overall score should be displayed in the Ascending order in the Executive console");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Verify Last 30days in date filter| Last 30days is displayed correctly in the Date filter ");
	ProLogger.info("========================");
	ProLogger.info("Actual Results");	
	
	performLoginaction();
	mySpacepage = new MyspacesPage(driver);
	Assert.assertTrue(mySpacepage.verifyMyspacelbl(),Constants.MYSPACE_LBL_DISPLAYED);
	Reporter.log(Constants.MYSPACE_LBL_DISPLAYED);	
	mySpacepage.selectSpace("Sprint 18-21 PostgreSQL QA NEW_USERS");
	mySpacepage.selectOption("optDashboards");
	driverSafetypage = new DriverSafetyPage(driver);
	Assert.assertTrue(driverSafetypage.verifyTrimblepulseImg(),Constants.TIMBLE_PULSEIMAGE_DISPLAYED);
	Reporter.log(Constants.TIMBLE_PULSEIMAGE_DISPLAYED);	
	driverSafetypage.clickExecutidriverSafetyconsole();
	Assert.assertTrue(driverSafetypage.verifyExectiveconsolePage(),Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);
	Reporter.log(Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyLastthirtyDaysfilter(),Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);	
	Assert.assertEquals(driverSafetypage.getTextthirtyDayfilter(),"= Last 30 days");
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);	
    }
    
    /**
     * Verify date filters are consistent across dashboards
     * @throws Exception
     */
    
    @Test
    public void verifyDatefilterAcrossdashboards() throws Exception
    {	
	ProLogger.info("Verify date filters are consistent across dashboards");
	ProLogger.info("Test Case : Verify overall score should be displayed in the Ascending order in the Executive console");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Verify Last 30days, Start Date and End Date in date filter| Last 30days,StartDate and End Date is displayed correctly in the Date filter ");
	ProLogger.info("7. Click Folder Icon and click Individual Scorecard | Individual score card home page is displayed");
	ProLogger.info("8. Verify Last 30days, Start Date and End Date in date filter| Last 30days,StartDate and End Date is displayed correctly in the Date filter ");
	ProLogger.info("9. Click Folder Icon and click Scorecard Report - combined groups | Scorecard Report - combined groups home page is displayed");
	ProLogger.info("10. Verify Last 30days, Start Date and End Date in date filter| Last 30days,StartDate and End Date is displayed correctly in the Date filter ");
	ProLogger.info("11. Click Folder Icon and click Scorecard Report - separated groups | Scorecard Report - separated groups home page is displayed");
	ProLogger.info("12. Verify Last 30days, Start Date and End Date in date filter| Last 30days,StartDate and End Date is displayed correctly in the Date filter ");
	ProLogger.info("========================");
	ProLogger.info("Actual Results");		
	
	performLoginaction();
	mySpacepage = new MyspacesPage(driver);
	Assert.assertTrue(mySpacepage.verifyMyspacelbl(),
		Constants.MYSPACE_LBL_DISPLAYED);
	Reporter.log(Constants.MYSPACE_LBL_DISPLAYED);	
	mySpacepage.selectSpace("Sprint 18-23 PostgreSQL QA NEW_USERS");
	mySpacepage.selectOption("optDashboards");
	driverSafetypage = new DriverSafetyPage(driver);
	Assert.assertTrue(driverSafetypage.verifyTrimblepulseImg(),Constants.TIMBLE_PULSEIMAGE_DISPLAYED);
	Reporter.log(Constants.TIMBLE_PULSEIMAGE_DISPLAYED);	
	driverSafetypage.clickExecutidriverSafetyconsole();
	Assert.assertTrue(driverSafetypage.verifyExectiveconsolePage(),	Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);
	Reporter.log(Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyThritydaysFilterdisplayed(),Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyStartdateDisplayed(),Constants.STARTDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.STARTDATE_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyEnddateDisplayed(),Constants.ENDDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.ENDDATE_FILTER_DISPLAYED);	
	
	//To Check Date filter in Individual Scorecard	
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickIndividualscoreCard();
	Assert.assertTrue(driverSafetypage.verifyThritydaysFilterdisplayed(),Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyStartdateDisplayed(),Constants.STARTDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.STARTDATE_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyEnddateDisplayed(),Constants.ENDDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.ENDDATE_FILTER_DISPLAYED);
	
	//To Check Date filter in combined groups
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickCombinedscoreCard();
	Assert.assertTrue(driverSafetypage.verifyThritydaysFilterdisplayed(),Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyStartdateDisplayed(),Constants.STARTDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.STARTDATE_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyEnddateDisplayed(),Constants.ENDDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.ENDDATE_FILTER_DISPLAYED);
	
	//To Check Date Filter in Separated groups
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickSeparatedscoreCard();
	Assert.assertTrue(driverSafetypage.verifyThritydaysFilterdisplayed(),Constants.LAST30DAYS_FILTER_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyStartdateDisplayed(),Constants.STARTDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.STARTDATE_FILTER_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyEnddateDisplayed(),Constants.ENDDATE_FILTER_DISPLAYED);
	Reporter.log(Constants.ENDDATE_FILTER_DISPLAYED);
    }
    
    /**
     * Verify Banner, Trimble Pulse Logo look consistent across all dashboards (where applicable)
     * 
     * @throws Exception
     */
    @Test
    public void verifyAlllogosIndashboard() throws Exception
    {
	
	ProLogger.info("Verify dashboards are set to display data for 'Last 30 Days' by default (where applicable)");
	ProLogger.info(	"Test Case : Verify overall score should be displayed in the Ascending order in the Executive console");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Verify Trimble Pulse logo and Banner is displayed| Trimble pulse logo and banner is displayed correctly in the Date filter ");
	ProLogger.info("7. Click Folder Icon and click Individual Scorecard | Individual score card home page is displayed");
	ProLogger.info("8. Verify Trimble Pulse logo and Banner is displayed| Trimble pulse logo and banner is displayed correctly in the Date filter ");
	ProLogger.info("9. Click Folder Icon and click Scorecard Report - combined groups | Scorecard Report - combined groups home page is displayed");
	ProLogger.info("10. Verify Trimble Pulse logo and Banner is displayed| Trimble pulse logo and banner is displayed correctly in the Date filter ");
	ProLogger.info("11. Click Folder Icon and click Scorecard Report - separated groups | Scorecard Report - separated groups home page is displayed");
	ProLogger.info("12. Verify Trimble Pulse logo and Banner is displayed| Trimble pulse logo and banner is displayed correctly in the Date filter ");
	ProLogger.info("========================");
	ProLogger.info("Actual Results");	
	
	performLoginaction();
	mySpacepage = new MyspacesPage(driver);
	Assert.assertTrue(mySpacepage.verifyMyspacelbl(),Constants.MYSPACE_LBL_DISPLAYED);
	Reporter.log(Constants.MYSPACE_LBL_DISPLAYED);	
	mySpacepage.selectSpace("Sprint 18-23 PostgreSQL QA NEW_USERS");
	mySpacepage.selectOption("optDashboards");
	driverSafetypage = new DriverSafetyPage(driver);
	Assert.assertTrue(driverSafetypage.verifyTrimblepulseImg(),Constants.TIMBLE_PULSEIMAGE_DISPLAYED);
	Reporter.log(Constants.TIMBLE_PULSEIMAGE_DISPLAYED);	
	driverSafetypage.clickExecutidriverSafetyconsole();
	Assert.assertTrue(driverSafetypage.verifyExectiveconsolePage(),Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);
	Reporter.log(Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);	
	Assert.assertTrue(driverSafetypage.verifyTrimblelogo(),Constants.TRIMBLE_LOGO_DISPLAYED);
	Reporter.log(Constants.TRIMBLE_LOGO_DISPLAYED);		
	
	//To Check Date filter in Individual Scorecard	
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickIndividualscoreCard();
	Assert.assertTrue(driverSafetypage.verifyTrimblelogo(),Constants.TRIMBLE_LOGO_DISPLAYED);
	Reporter.log(Constants.TRIMBLE_LOGO_DISPLAYED);			
    }
    
    /**
     * Verify Date filter settings are maintained when you drill down from one dashboard to another e.g. from Exec Console to Individual Scorecard
     * 
     * @throws Exception
     */
    @Test
    public void verifyDatefilterOnedashboardToanother() throws Exception
    {
	
	ProLogger.info("Verify dashboards are set to display data for 'Last 30 Days' by default (where applicable)");
	ProLogger.info(	"Test Case : Verify overall score should be displayed in the Ascending order in the Executive console");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Verify Last 30days, Start Date & End Date filter is displayed| Last 30days, Start Date & End Date is displayed correctly in the Date filter ");
	ProLogger.info("7. Click Folder icon and click Individual Scorecard | Individual scorecard page is displayed correctly");
	ProLogger.info("8. Verify the data should be matched of Last 30days ,Startdate and End date after switching one dashboard to another dashboard | The data is matched of Last 30days ,Startdate and End date after switching one dashboard to another dashboar");
	ProLogger.info("========================");
	ProLogger.info("Actual Results");	
	
	performLoginaction();
	mySpacepage = new MyspacesPage(driver);
	Assert.assertTrue(mySpacepage.verifyMyspacelbl(),Constants.MYSPACE_LBL_DISPLAYED);
	Reporter.log(Constants.MYSPACE_LBL_DISPLAYED);	
	mySpacepage.selectSpace("Sprint 18-23 PostgreSQL QA NEW_USERS");
	mySpacepage.selectOption("optDashboards");
	driverSafetypage = new DriverSafetyPage(driver);
	Assert.assertTrue(driverSafetypage.verifyTrimblepulseImg(),Constants.TIMBLE_PULSEIMAGE_DISPLAYED);
	Reporter.log(Constants.TIMBLE_PULSEIMAGE_DISPLAYED);	
	driverSafetypage.clickExecutidriverSafetyconsole();
	Assert.assertTrue(driverSafetypage.verifyExectiveconsolePage(),Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);
	Reporter.log(Constants.EXECUTIVE_CONSOLEPAGE_DISPLAYED);	
	String lastThirtdaystxt = driverSafetypage.getTextlastThirtydays();	
	String startDate = driverSafetypage.getTextstartDate();	
	String endDate = driverSafetypage.getTextendDate();	
	
	//To Check Date filter in Individual Scorecard	
	driverSafetypage.clickFoldericon();
	driverSafetypage.clickIndividualscoreCard();	
	Assert.assertEquals(driverSafetypage.getTextlastThirtydays_Indvscorecard(), lastThirtdaystxt, Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextstartDate_Indvscorecard(), startDate, Constants.STARTDATEFILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.STARTDATEFILTER_TEXT_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextendDate_Indvscorecard(), endDate, Constants.ENDDATEFILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.ENDDATEFILTER_TEXT_DISPLAYED);
    }
    
}
