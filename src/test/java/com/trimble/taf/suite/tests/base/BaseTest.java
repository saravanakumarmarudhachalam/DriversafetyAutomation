/**
 * 
 */
package com.trimble.taf.suite.tests.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.org.apache.bcel.internal.classfile.Method;
import com.trimble.taf.driver.InitializeDriver;
import com.trimble.taf.pagefactory.application.LoginPage;
import com.trimble.taf.utils.ProLogger;
import com.trimble.taf.utils.PropertyUtils;

/**
 * @author Saravanakumar
 */
public class BaseTest
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
    
    @BeforeSuite
    public void extentReport ()
    {
	
    }
    
   
    @BeforeTest
    public void SetUp ()
    {
	
    }  
    
    @Parameters({ "browser", "runMode", "platform" })
    @BeforeMethod
    public void GoToHomePage (@Optional String aBrowserName,
	    @Optional String aRunMode, @Optional String aPlatform) throws Exception
    {	
	driver = setUpDriver(aBrowserName, aRunMode, aPlatform);
	driver.navigate().to(appBaseURL);
	
    }
    
    @Parameters({ "browser", "platform" })
    @AfterMethod
    public void generateReport (ITestResult result,@Optional
    String aBrowserName,
	    @Optional
	    String aPlatform)
    {		
	tearDownDriver(aBrowserName, aPlatform);	
    }      
   
    @AfterTest
    public void endReport(){
	
    }
   
    public void performLoginaction () throws Exception
    {
	loginPage = new LoginPage(driver);
	loginPage.waitForPageToLoad(driver);
	loginPage.enterUsername(propertyUtils.getProperty("username"));
	loginPage.enterPassword(propertyUtils.getProperty("password"));
	loginPage.clickLogin();
    }
}
