/**
 * 
 */
package com.trimble.taf.suite.tests.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.trimble.taf.driver.InitializeDriver;
import com.trimble.taf.pagefactory.application.LoginPage;
import com.trimble.taf.utils.ProLogger;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * @author smarudh
 */

@CucumberOptions(
		 features = "src/test/java/com/trimble/features",
		 glue = { "com/trimble/birst/tests" },
			 format = {
			                "pretty",
			                "html:target/cucumber-reports/cucumber-pretty",
			                "json:target/cucumber-reports/CucumberTestReport.json",
			                "rerun:target/cucumber-reports/rerun.txt"
			        },
		 monochrome = true, strict = true, dryRun = false,
		 tags = { "@Regression" })
public class TestRunner
{
    private TestNGCucumberRunner testNGCucumberRunner;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
