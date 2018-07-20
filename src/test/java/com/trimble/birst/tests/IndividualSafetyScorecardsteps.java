/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author smarudh
 */
public class IndividualSafetyScorecardsteps
{
    
    public WebDriver driver;
    
    String exePagedriverName;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    /**
     * Constructor
     */
    public IndividualSafetyScorecardsteps()
    {
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked on driver name in Executive console$")
    public void clickDrivername () throws Throwable
    {
	exePagedriverName = driverSafetypage.getTextdriverName();
	driverSafetypage.executivePagedriverLink.click();
	Reporter.log(Constants.INDIVIDUAL_SCORECARD_DISPLAYED);	
    }
    
    @Then("^Verify Individual Scorecard is displayed for that driver$")
    public void verifyIndividualscorePage() throws Throwable
    {	
	driverSafetypage.waitFornewWindowandSwitchtoIt(driver);	
	String individualScoredriverName;
	individualScoredriverName = driverSafetypage.getTextindividualScoredriverNameinFilter();	
	Assert.assertEquals(exePagedriverName,individualScoredriverName.replace("= ", ""));
	Reporter.log(Constants.DRIVER_NAME_IN_EXECUTIVE_CONSOLE_AND_INDIVIDUAL_SCORECARD_MATCHES);	
    }    
}
