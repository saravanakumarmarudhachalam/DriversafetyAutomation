/**
 * 
 */
package com.trimble.taf.suite.tests.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import com.trimble.taf.driver.InitializeDriver;
import com.trimble.taf.utils.ProLogger;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * @author smarudh
 */

@CucumberOptions(
//		 features = {
//			 "src/test/java/com/trimble/features/commontests.feature",
//			 "src/test/java/com/trimble/features/executiveconsole.feature",
//			 "src/test/java/com/trimble/features/individualScorecard.feature",
//			 "src/test/java/com/trimble/features/combinedScorecard.feature",
//			 "src/test/java/com/trimble/features/seperatedScorecard.feature",
//			 "src/test/java/com/trimble/features/supervisorconsole.feature",
//			 "src/test/java/com/trimble/features/MostDangerousLocations.feature" },
		 features =
		 {"src/test/java/com/trimble/features/supervisorconsole.feature"},
		 glue = { "com/trimble/birst/tests" },
		 plugin = {
			 "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		 tags = { "@Regression" })
public class TestRunner
{
    
    public static WebDriver driver;
    
    private Platform aDeviceType;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    protected static final String appBaseURL = propertyUtils
	    .getProperty("appURL");
    
    private TestNGCucumberRunner testNGCucumberRunner;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass () throws Exception
    {
	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    
    @BeforeMethod(alwaysRun = true)
    public void driversetUp ()
    {
	driver = setUpDriver(propertyUtils.getProperty("browser"),
		propertyUtils.getProperty("runMode"),
		propertyUtils.getProperty("platform"));
	driver.navigate().to(appBaseURL);
    }
    
    @AfterMethod(alwaysRun = true)
    public void tear ()
    {
	tearDownDriver(propertyUtils.getProperty("browser"),
		propertyUtils.getProperty("platform"));
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Feature",
	  dataProvider = "features")
    public void feature (CucumberFeatureWrapper cucumberFeature)
    {
	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
    
    @DataProvider
    public Object[][] features ()
    {
	return testNGCucumberRunner.provideFeatures();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass () throws Exception
    {
	testNGCucumberRunner.finish();
	Reporter.loadXMLConfig(
		new File("src/test/resources/extent-config.xml"));
	Reporter.setSystemInfo("user", System.getProperty("username"));
	Reporter.setSystemInfo("OS", "Windows 7");
	Reporter.setSystemInfo("Hostname", "smarudh");
	Reporter.setSystemInfo("Test Type", "Regression");
	Reporter.setSystemInfo("Test Environment", "QA");
	Reporter.setSystemInfo("UserName", "Saravanakumar");
    }
    
    /**
     * @param aBrowserName
     * @param aRunMode
     * @param aPlatform
     */
    public WebDriver setUpDriver (String aBrowserName,
	    String aRunMode,
	    String aPlatform)
    {
	aDeviceType = Platform.WINDOWS;
	if (aPlatform.equalsIgnoreCase(Platform.LINUX.toString()))
	{
	    aDeviceType = Platform.LINUX;
	}
	else if (aPlatform.equalsIgnoreCase(Platform.LINUX.toString()))
	{
	    aDeviceType = Platform.UNIX;
	}
	else if (aPlatform.equalsIgnoreCase(Platform.MAC.toString()))
	{
	    aDeviceType = Platform.MAC;
	}
	
	driver = InitializeDriver.getInstance().getWebDriver(aBrowserName,
		aRunMode, aDeviceType);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	return driver;
    }
    
    public void tearDownDriver (@Optional String aBrowserName,
	    @Optional String aPlatform)
    {
	try
	{
	    InitializeDriver.getInstance().quitDriver(driver, aBrowserName,
		    aPlatform);
	}
	catch (IOException ioe)
	{
	    ProLogger.error("IO Exception {}", ioe.getMessage());
	}
    }
    
    public static WebDriver getDriver ()
    {
	return driver;
    }
}
