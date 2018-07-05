package com.trimble.birst.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.suite.tests.base.BaseTest;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author Saravanakumar
 */
public class ExecutiveConsoleTests extends BaseTest
{
    
    
    private MyspacesPage mySpacepage;
    
    private DriverSafetyPage driverSafetypage;
    
    /**
     * Verify drivers are shown in ascending order of their Overall Score in
     * Driver Ranking by Scores grid i.e. driver having lowest Overall Score is
     * at the top
     * 
     * @throws Exception
     */
    @Test
    public void verifyExecutiveconsoleOverallscoreinASC () throws Exception
    {
	ProLogger.info("Verify drivers are shown in ascending order of their Overall Score in Driver Ranking by Scores grid i.e. driver having lowest Overall Score is at the top");
	ProLogger.info("Test Case : Verify overall score should be displayed in the Ascending order in the Executive console");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Verify overall score is displayed in Ascending order| overall score is displayed correctly in Ascending order ");
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
	
    }    
    @Test
    public void verifyDefaultorganization() throws Exception
    {
	ProLogger.info("Verify default organization displayed is Allan Myers");
	ProLogger.info("Test Case : Verify default organization Allan Myers");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Verify default organization displayed is Allan Myers ");
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
	
	Assert.assertEquals(driverSafetypage.getTextdefaultOrg(), Constants.DEFAULT_ORGANIZATION);
	Reporter.log(Constants.DEFAULT_ORGANIZATION);
    }
    @Test
    public void verifyExportPDFmenu() throws Exception
    {
	ProLogger.info("Verify entire report is able to export");
	ProLogger.info("Test Case : Verify entire report is able to export");
	
	ProLogger.info("Test Steps | Expected Results:");
	ProLogger.info("1. Launch the application | Application Should be Launched");
	ProLogger.info("2. Login to the application | User Should be login successfully");
	ProLogger.info("3. Verify Home page | Home page should be displayed");
	ProLogger.info("4. Click My Spaces & Click Dashboards | Trimble pulse home page is displayed");
	ProLogger.info("5. Click Executive Driver safety Console| Executive console home page is displayed");
	ProLogger.info("6. Click the Export icon ");
	ProLogger.info("7. Click the PDF ");
	ProLogger.info("8. Verify entire report is able to export ");
	
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
	
	driverSafetypage.clickExporticon();
	driverSafetypage.clickExportPDF();
	Assert.assertEquals(driverSafetypage.getTextexportInprogress(), Constants.EXPORT_IN_PROGRESS);
	Reporter.log(Constants.EXPORT_IN_PROGRESS);
	
	driverSafetypage.clickExporticon();
	driverSafetypage.clickExportdetailPDF();
	Assert.assertEquals(driverSafetypage.getTextexportInprogress(), Constants.EXPORT_IN_PROGRESS);
	Reporter.log(Constants.EXPORT_IN_PROGRESS);
	Thread.sleep(30000);
	driverSafetypage.verifyExportedFiles();
	
    }
        
}
