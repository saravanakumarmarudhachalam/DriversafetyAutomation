package com.trimble.taf.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.trimble.taf.enums.EnumClass.Browsers;
import com.trimble.taf.enums.EnumClass.RunModes;
import com.trimble.taf.utils.ProLogger;
import com.trimble.taf.utils.PropertyUtils;

/**
 * @author Saravanakumar
 */

public class InitializeDriver
{
    
    private static InitializeDriver instance = null;
    
    private static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    private static final String FIREFOX_PROFILE = "Testing";
    
    private static final String CURRENT_DIR = System.getProperty("user.dir");
    
    private InitializeDriver()
    {
    }
    
    public WebDriver getWebDriver (String aBrowserName, String aRunType,
	    Platform aDevice)
    {
	WebDriver driver = null;
	if (aRunType.equalsIgnoreCase(RunModes.LOCAL.toString())
		|| aRunType.equalsIgnoreCase(RunModes.MULTIBROWSER.toString()))
	{
	    driver = getLocalWebDriver(aBrowserName, aDevice);
	}
	else if (aRunType.equalsIgnoreCase(RunModes.GRID.toString())
		|| aRunType.equalsIgnoreCase(RunModes.GRIDMULTIBROWSER
			.toString()))
	{
	    driver = getRemoteWebDriver(aBrowserName, aDevice);
	}
	return driver;
    }
    
    /**
     * Method to return driver instance based on Browser Name
     * 
     * @return
     */
    public WebDriver getLocalWebDriver (String aBrowserName, Platform aDevice)
    {
	WebDriver driver = null;
	Capabilities theDesCap = new DesiredCapabilities();
	if (aBrowserName.equalsIgnoreCase(Browsers.FIREFOX.toString()))
	{
	    theDesCap = getFirefoxCapabilities();
	    ((DesiredCapabilities) theDesCap).setPlatform(aDevice);
	    driver = new FirefoxDriver(theDesCap);
	}
	else if (aBrowserName.equalsIgnoreCase(Browsers.CHROME.toString()))
	{
	    theDesCap = getChromeCapabilities();
	    ((DesiredCapabilities) theDesCap).setPlatform(aDevice);
	    driver = new ChromeDriver(theDesCap);
	}
	else if (aBrowserName.replace(" ", "").equalsIgnoreCase(
		Browsers.INTERNETEXPLORER.toString()))
	{
	    theDesCap = getInternetExplorerCapabilities();
	    ((DesiredCapabilities) theDesCap).setPlatform(aDevice);
	    driver = new InternetExplorerDriver(theDesCap);
	}
	else if (aBrowserName.equalsIgnoreCase(Browsers.SAFARI.toString()))
	{
	    theDesCap = getSafariCapabilities();
	    ((DesiredCapabilities) theDesCap).setPlatform(aDevice);
	    driver = new SafariDriver(theDesCap);
	}
	return driver;
    }
    
    /**
     * Method to get Selenium Remote web driver instance
     * 
     * @param aPlatform
     * @return RemoteWebDriver
     */
    private WebDriver getRemoteWebDriver (String aBrowserName,
	    Platform aPlatform)
    {
	return getGridWebDriver(aBrowserName, aPlatform);
    }
    
    /**
     * Method to get Selenium WebDriver with setting remote settings
     * 
     * @param aPlatform
     * @param driver
     * @param currentTestCase
     * @return
     */
    private WebDriver getGridWebDriver (String aBrowserName,
	    Platform aPlatform)
    {
	WebDriver driver = null;
	
	DesiredCapabilities theDesCap = null;
	String nodeURL = propertyUtils.getProperty("nodeURL");
	
	try
	{
	    if (aBrowserName.equalsIgnoreCase(Browsers.FIREFOX.toString()))
	    {
		theDesCap = DesiredCapabilities.firefox();
		theDesCap.setPlatform(aPlatform);
		theDesCap.setBrowserName(aBrowserName);
	    }
	    else if (aBrowserName
		    .equalsIgnoreCase(Browsers.CHROME.toString()))
	    {
		theDesCap = DesiredCapabilities.chrome();
		theDesCap.setPlatform(aPlatform);
		theDesCap.setBrowserName(aBrowserName);
		theDesCap.setCapability("webdriver.chrome.driver",
			"drivers\\chromedriver.exe");
	    }
	    else if (aBrowserName.replace(" ", "").equalsIgnoreCase(
		    Browsers.INTERNETEXPLORER.toString()))
	    {
		theDesCap = DesiredCapabilities.internetExplorer();
		theDesCap.setPlatform(aPlatform);
		theDesCap.setBrowserName(aBrowserName);
	    }
	    else if (aBrowserName
		    .equalsIgnoreCase(Browsers.SAFARI.toString()))
	    {
		theDesCap = DesiredCapabilities.safari();
		theDesCap.setPlatform(aPlatform);
		theDesCap.setBrowserName(aBrowserName);
	    }
	    driver = new RemoteWebDriver(new URL(nodeURL), theDesCap);
	}
	catch (MalformedURLException urle)
	{
	    ProLogger.error("Malformed URL Exception {}", urle.getMessage());
	}
	return driver;
	
    }
    
    private DesiredCapabilities getInternetExplorerCapabilities ()
    {
	String ieDriverPath = propertyUtils.getProperty("ieDriverPath");
	System.setProperty("webdriver.ie.driver", CURRENT_DIR + ieDriverPath);
	DesiredCapabilities theDesCap = DesiredCapabilities.internetExplorer();
	((DesiredCapabilities) theDesCap)
		.setCapability(
			InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			true);
	((DesiredCapabilities) theDesCap).setCapability(
		CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	try
	{
	    Runtime.getRuntime().exec(
		    "RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
	}
	catch (IOException ioe)
	{
	    ProLogger.error("IO Exception {}", ioe.getMessage());
	}
	return (DesiredCapabilities) theDesCap;
    }
    
    private DesiredCapabilities getChromeCapabilities ()
    {
	String chromeDriverPath = propertyUtils.getProperty("chromeDriverPath");
	System.setProperty("webdriver.chrome.driver", CURRENT_DIR
		+ chromeDriverPath);
	DesiredCapabilities theDesCap = DesiredCapabilities.chrome();
	((DesiredCapabilities) theDesCap).setCapability(
		CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	
	return (DesiredCapabilities) theDesCap;
    }
    
    private DesiredCapabilities getFirefoxCapabilities ()
    {
	ProfilesIni theAllProfiles = new ProfilesIni();
	String firefoxDriverpath = propertyUtils.getProperty("firefoxDriverPath");
	System.setProperty("webdriver.gecko.driver", CURRENT_DIR
		+ firefoxDriverpath);
	DesiredCapabilities theDesCap = DesiredCapabilities.firefox();
	FirefoxProfile theProfile = theAllProfiles.getProfile(FIREFOX_PROFILE);
	//theProfile.setAcceptUntrustedCertificates(true);
	//theProfile.setAssumeUntrustedCertificateIssuer(false);
	((DesiredCapabilities) theDesCap).setCapability(FirefoxDriver.PROFILE,
		theProfile);
	((DesiredCapabilities) theDesCap).setCapability(
		CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	return (DesiredCapabilities) theDesCap;
    }
    
    /**
     * Method to get safari browser capabilities
     * 
     * @return
     */
    private DesiredCapabilities getSafariCapabilities ()
    {
	DesiredCapabilities theDesCap = DesiredCapabilities.safari();
	return (DesiredCapabilities) theDesCap;
    }
    
    /**
     * Method to quit driver instance
     * 
     * @param driver
     * @param aPlatform
     * @param aBrowserName
     * @throws IOException
     */
    public void quitDriver (WebDriver driver, String aBrowserName,
	    String aPlatform) throws IOException
    {
	Process currentProcess;
	if (!(aBrowserName.equalsIgnoreCase(Browsers.INTERNETEXPLORER
		.toString())))
	{
	    driver.quit();
	}
	else
	{
	    try
	    {
		driver.manage().deleteAllCookies();
		Runtime.getRuntime().exec(
			"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		driver.close();
		driver.quit();
		currentProcess = Runtime.getRuntime()
			.exec("IEDriverServer.exe");
		currentProcess.destroy();
	    }
	    catch (IOException ioe)
	    {
		ProLogger.error("IO Exception {}", ioe.getMessage());
	    }
	}
    }
    
    public static InitializeDriver getInstance ()
    {
	if (instance == null)
	{
	    instance = new InitializeDriver();
	}
	return instance;
    }
}
