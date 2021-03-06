/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.pagefactory.application.VehicleUtilizationReportpage;
import com.trimble.taf.suite.tests.base.TestRunner;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;
import cucumber.api.java.en.Then;
 /**
 * @author smarudh
 */
public class VehicleUtilizationReportTestSteps
{
 public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public VehicleUtilizationReportpage vehicleUtilzationreportPage;
    
    public VehicleUtilizationReportTestSteps() 
    {
	driver = TestRunner.getDriver();
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	vehicleUtilzationreportPage = new VehicleUtilizationReportpage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @Then("^Verify that Utlization report is opened for the current month by default$")
    public void verifyDateFilter() throws Throwable
    {
	vehicleUtilzationreportPage.verifyDateFilter();
	Reporter.log(Constants.CURRENT_MONTH_BYDEFAULT);
    }
    
    @Then("^I changed the time period to last month in the Vehicle Utilization Report$")
    public void verifyUtilizationValue() throws Throwable
    {
	
	vehicleUtilzationreportPage.verifyUtilizationValue();
	Reporter.log(Constants.UTILIZATIONVALUE_CHANGES);
    }
    
    @Then("^I verify color coding of Utilization percentage$")
    public void verifyColorofUtilization() throws Throwable
    {
	vehicleUtilzationreportPage.verifyColorofUtilization();
	
    }
} 
