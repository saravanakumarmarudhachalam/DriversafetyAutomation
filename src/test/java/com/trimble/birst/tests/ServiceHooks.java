/**
 * 
 */
package com.trimble.birst.tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.trimble.taf.driver.InitializeDriver;
import com.trimble.taf.pagefactory.application.LoginPage;
import com.trimble.taf.utils.ProLogger;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author smarudh
 */
public class ServiceHooks
{
    
    
    public static WebDriver driver;
    
    public LoginPage loginPage;
    
    private Platform aDeviceType;
    
    public ExtentReports extent;
    
    public ExtentTest logger;
    
    private String myScreenshotDestinationPath;
    
    private String timeStamp;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    protected static final String appBaseURL = propertyUtils
	    .getProperty("appURL");
    
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
    
    /**
     * This class will take screenshot of any test method
     * 
     * @param driver
     * @param destPath
     */
    
    public static void takeSnapShot (WebDriver driver, String destPath)
	    throws Exception
    {
	// Convert web driver object to TakeScreenshot instance
	TakesScreenshot scrShot = ((TakesScreenshot) driver);
	
	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	
	File DestFile = new File(destPath);
	
	FileUtils.copyFile(SrcFile, DestFile);
    }
    
    @Before()
    public void GoToHomePage (Scenario sceario) throws Exception
    {
	String scenarioName = sceario.getName();	
	System.out.println("Executing Scenario : " + scenarioName);	
    }
    
    @After()
    public void Aftersteps (@Optional Scenario scenario) throws IOException
    {
//	if (scenario.isFailed()) {
//            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshotBytes, "image/png");
//        }	
    }
    
    public void performLoginaction () throws Exception
    {
	loginPage = new LoginPage(driver);
	loginPage.waitForPageToLoad(driver);
	loginPage.enterUsername(propertyUtils.getProperty("username"));
	loginPage.enterPassword(propertyUtils.getProperty("password"));
	loginPage.clickLogin();
    }
   
    public static WebDriver getDriver() {
        return driver;
    }
}
