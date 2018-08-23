/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.pagefactory.application.SupervisorConsolepage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;
import cucumber.api.java.en.And;

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
	driver = ServiceHooks.driver;
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
    
}
