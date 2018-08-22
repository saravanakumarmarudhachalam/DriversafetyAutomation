/**
 * 
 */
package com.trimble.taf.suite.tests.base;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * @author smarudh
 */

@CucumberOptions(
		 features = "src/test/java/com/trimble/features",
		 glue = { "com/trimble/birst/tests" },
		 plugin = {
			 "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		 tags = { "@Regression" })
public class TestRunner
{
    
    
    private TestNGCucumberRunner testNGCucumberRunner;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass () throws Exception
    {
	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
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
}
