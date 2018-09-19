/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.pagefactory.application.SupervisorConsolepage;
import com.trimble.taf.suite.tests.base.TestRunner;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author smarudh
 */
public class SupervisorTestSteps
{
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public SupervisorConsolepage superVisorconsole;
    
    /**
     * Constructor
     */
    public SupervisorTestSteps()
    {
	driver = TestRunner.getDriver();
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	superVisorconsole = new SupervisorConsolepage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked Supervisor Console$")
    public void openSupervisorConsole () throws Throwable
    {
	superVisorconsole.invokeSupervisorconsole();
	Reporter.log(Constants.SUPERVISOR_CONSOLE_OPENED_SUCCESSFULLY);
    }
    
    @Then("^I verified overall score is displayed in ascending order in Supervisor Console$")
    public void verifyAscendingoverallScore () throws Throwable
    {
	Assert.assertTrue(driverSafetypage.verifyOverallscoreAsc(),
		Constants.OVERALLSCORE_ASCENDINGORDER_DISPLAYED);
	Reporter.log(Constants.OVERALLSCORE_ASCENDINGORDER_DISPLAYED);
    }
    
    @Then("^I verified all the sorting column are working correctly in Supervisor Console$")
    public void verifySortingcolumn () throws Throwable
    {
	driverSafetypage.sortTableascDescanyColumn();
    }
    
    @Then("^I verified all the displayed without decimal point in the score grid in supervisor console$")
    public void verifyAllscoreValueWOdecimal () throws Throwable
    {
	driverSafetypage.verifyWOdecimalPoint();
    }
    
    @Then("^I verified score values are color coded as per the Filter values in supervisor console$")
    public void verifyAllscorevalueColorcoded () throws Throwable
    {
	superVisorconsole.verifyColorcodedTargetfilter();
    }
    
    @Then("^I verified all Driver safety Events chart is displayed$")
    public void verifyDriversafetyEventschart () throws Throwable
    {
	Assert.assertTrue(superVisorconsole.verifyDriversafetyChartdisplayed(),Constants.DRIVER_SAFETY_EVENTS_CHART_DISPLAYED);
    }
}
