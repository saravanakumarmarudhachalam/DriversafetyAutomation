package com.trimble.taf.pagefactory.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trimble.taf.exception.FrameworkException;
import com.trimble.taf.utils.ProLogger;

/**
 * @author Saravanakumar
 */

public class AbstractPage
{
    
    
    protected WebDriver driver;
    
    JavascriptExecutor javaScript;
    
    public AbstractPage(WebDriver driver)
    {
	this.driver = driver;
    }
    
    public String getPageTitle (WebDriver driver)
    {
	return driver.getTitle();
    }
    
    public void clickElement (WebElement element)
    {
	boolean exceptionOccured = false;
	
	try
	{
	    waitForElementPresent(element);
	    jsClick(element);
	}
	catch (NoSuchElementException nsee)
	{
	    exceptionOccured = true;
	    ProLogger.error("No Such Element {}", nsee.getMessage());
	}
	catch (Exception ex)
	{
	    exceptionOccured = true;
	    ProLogger.error("Exception in click element {}",
		    ex.getMessage());
	}
    }
    
    public boolean isElementDisplayed (WebElement element)
    {
	boolean isDisplayed = false;
	try
	{
	    isDisplayed = element.isDisplayed();
	}
	catch (NoSuchElementException ex)
	{
	    ProLogger.error("No Such Element {}", ex.getMessage());
	}
	return isDisplayed;
    }
    
    /**
     * Method to check if element is present
     * 
     * @param element
     * @return
     * @throws Exception
     */
    public boolean isElementPresent (WebElement element) throws Exception
    {
	return isElementPresentAfterWait(element);
    }
    
    /**
     * Method to check if element is present after waiting for specific time
     * 
     * @param element
     * @return
     */
    public boolean isElementPresentAfterWait (WebElement element)
    {
	boolean elementPresent = false;
	// FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	// .withTimeout(120, TimeUnit.SECONDS)
	// .pollingEvery(1, TimeUnit.SECONDS)
	// .ignoring(NoSuchElementException.class);
	
	WebDriverWait wait = new WebDriverWait(driver, 120);
	try
	{
	    wait.until(ExpectedConditions.visibilityOf(element));
	    if (element.isDisplayed())
	    {
		elementPresent = true;
	    }
	}
	catch (NoSuchElementException nsee)
	{
	    ProLogger.error("No Such Element {}", nsee.getMessage());
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception {}", ex.getMessage());
	}
	return elementPresent;
    }
    
    /**
     * Method to check if element is present without wait
     * 
     * @param element
     * @return
     * @throws Exception
     */
    public boolean noWaitElementPresent (WebElement element) throws Exception
    {
	return isElementPresent(element, 1);
    }
    
    /**
     * @param elements
     * @param waitTime
     * @return
     */
    private boolean isElementPresent (List<WebElement> elements, int waitTime)
    {
	return false;
    }
    
    /**
     * Method to check if element is not present without wait
     * 
     * @param elementBy
     * @return
     */
    public boolean isElementNotPresent (WebElement element, int waitTime)
    {
	boolean elementNotPresent = true;
	try
	{
	    driver.manage().timeouts()
		    .implicitlyWait(waitTime, TimeUnit.SECONDS);
	    if (element.isDisplayed())
	    {
		return false;
	    }
	}
	catch (NoSuchElementException nsee)
	{
	    ProLogger.error("Element not found {}", nsee.getMessage());
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception {}", ex.getMessage());
	}
	driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	return elementNotPresent;
    }
    
    /**
     * Method to click using Actions
     * 
     * @param element
     */
    public void clickUsingActions (WebElement element)
    {
	try
	{
	    if (isElementPresent((WebElement) element))
	    {
		Actions actions = new Actions(driver);
		actions.click(element);
	    }
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in click using actions {}",
		    ex.getMessage());
	}
    }
    
    /**
     * Method to double click using actions
     * 
     * @param elementBy
     */
    public void doubleClickUsingAction (WebElement element)
    {
	try
	{
	    if (isElementPresent(element))
	    {
		Actions actions = new Actions(driver);
		actions.doubleClick(element);
	    }
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in double click using actions {}",
		    ex.getMessage());
	}
    }
    
    /**
     * Method to check if alert box is present
     * 
     * @return
     */
    public boolean isAlertPresent ()
    {
	boolean isAlert = false;
	
	try
	{
	    driver.switchTo().alert();
	    isAlert = true;
	}
	catch (NoAlertPresentException noex)
	{
	    // To handle Firefox throwing exception
	    ProLogger.error("No Alert present {}", noex.getMessage());
	    isAlert = false;
	}
	return isAlert;
    }
    
    /**
     * Method to mouse over element using javascript
     * 
     * @param element
     */
    public void mouseOver (WebElement element)
    {
	String code = "var fireOnThis = arguments[0];"
		+ "var evObj = document.createEvent('MouseEvents');"
		+ "evObj.initEvent( 'mouseover', true, true );"
		+ "fireOnThis.dispatchEvent(evObj);";
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	((RemoteWebDriver) executor).executeScript(code, element);
    }
    
    /**
     * Method to mouse over element using javascript
     * 
     * @param element
     * @throws InterruptedException
     */
    public void mouseHover (WebElement element) throws Exception
    {
	WebElement weElement = element;
	String code = "var fireOnThis = arguments[0];"
		+ "var evObj = document.createEvent('MouseEvents');"
		+ "evObj.initEvent( 'mouseover', true, true );"
		+ "fireOnThis.dispatchEvent(evObj);";
	if (isElementPresent(element, 5))
	{
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    ((RemoteWebDriver) executor).executeScript(code, weElement);
	}
    }
    
    /**
     * Method to click element using javascript
     * 
     * @param elementBy
     * @throws InterruptedException
     */
    public void jsClick (By elementBy) throws Exception
    {
	WebElement weElement = driver.findElement(elementBy);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	((RemoteWebDriver) executor).executeScript("arguments[0].click();",
		weElement);
    }
    
    /**
     * Method to click element using javascript
     * 
     * @param weElement
     * @throws InterruptedException
     */
    public void jsClick (WebElement webElement) throws Exception
    {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	((RemoteWebDriver) executor).executeScript("arguments[0].click();",
		webElement);
    }
    
    /**
     * Method to click element using javascript
     * 
     * @param documentId
     */
    public void jsClick (String documentId)
    {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	((RemoteWebDriver) executor)
		.executeScript(
			"document.getElementById('hlViewStoreFinder').click();");
    }
    
    /**
     * Method to validate URL
     * 
     * @param driver
     * @throws Exception
     */
    public void validateURL (WebDriver driver, String aPagePath)
	    throws Exception
    {
	String actualURL = driver.getCurrentUrl();
	URL url = new URL(actualURL);
	System.out.println("URL path: " + url.getPath());
	if (url.getPath() != aPagePath)
	{
	    throw new Exception("Page URL Mismatch found");
	}
    }
    
    /**
     * Method to focus element
     * 
     * @param elementBy
     */
    public void focusElement (By elementBy)
    {
	try
	{
	    jsFocus(driver.findElement(elementBy));
	}
	catch (Exception ex)
	{
	    ProLogger
		    .error("Exception occured while clicking element using driver focus method {}",
			    ex.getMessage());
	}
    }
    
    /**
     * Method to focus element using javascript
     * 
     * @param element
     */
    private void jsFocus (WebElement element)
    {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	((RemoteWebDriver) executor).executeScript("arguments[0].click();",
		element);
    }
    
    /**
     * Method to clear text field
     * 
     * @param element
     */
    public void clearInput (WebElement element)
    {
	element.clear();
    }
    
    /**
     * Method to navigate back
     */
    public void navigateBack ()
    {
	driver.navigate().back();
    }
    
    /**
     * Method to select value for dropdown list
     * 
     * @param WebElement
     * @param label
     */
    public void selectValue (WebElement element, String label)
    {
	new Select(element).selectByVisibleText(label);
    }
    
    /**
     * Method to select radio button
     * 
     * @param elementBy
     * @param label
     */
    public void selectRadioButton (WebElement element)
    {
	element.click();
    }
    
    /**
     * Method to send keys to text element
     * 
     * @param element
     * @param typeValue
     * @throws InterruptedException
     */
    public void sendKeys (WebElement element, String typeValue)
	    throws Exception
    {
	clearInput(element);
	if (!getText(element).isEmpty())
	{
	    clearInput(element);
	}
	element.sendKeys(typeValue);
    }
    
    /**
     * Method to get text of an element
     * 
     * @param element
     * @return
     * @throws InterruptedException
     */
    public String getText (WebElement element) throws Exception
    {
	return element.getText().trim();
    }
    
    /**
     * Method to get Double value of an element
     * 
     * @param elementBy
     * @return
     * @throws InterruptedException
     */
    public Double getDouble (WebElement element) throws Exception
    {
	Double retValue = 0.0;
	try
	{
	    retValue = Double.valueOf(getText(element));
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in getting the text {}",
		    ex.getMessage());
	}
	return retValue;
    }
    
    /**
     * Method to get Double value of an element
     * 
     * @param str
     * @return
     * @throws InterruptedException
     */
    public Double getDouble (String str) throws Exception
    {
	Double retValue = 0.0;
	try
	{
	    retValue = Double.valueOf(str);
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in getting the value {}",
		    ex.getMessage());
	}
	return retValue;
    }
    
    /**
     * Method to get Double value of an element
     * 
     * @param elementBy
     * @return
     * @throws InterruptedException
     */
    public int getInteger (WebElement element) throws Exception
    {
	int retValue = 0;
	try
	{
	    retValue = Integer.valueOf(getText(element));
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in getting the value {}",
		    ex.getMessage());
	}
	return retValue;
    }
    
    /**
     * Method to get text of an element within parent element
     * 
     * @param element
     * @param elementBy
     * @return
     */
    public String getText (WebElement parentElement, WebElement childElement)
    {
	if (isElementPresent(parentElement, childElement))
	{
	    return childElement.getText().trim();
	}
	else
	{
	    return "";
	}
    }
    
    /**
     * @param parentElement
     * @param childElement
     * @return
     */
    private boolean isElementPresent (WebElement parentElement,
	    WebElement childElement)
    {
	return false;
    }
    
    /**
     * Method to get text of an element within parent element
     * 
     * @param element
     * @return
     * @throws InterruptedException
     */
    public String getText (WebElement element, int waitTime) throws Exception
    {
	if (isElementPresent(element, waitTime))
	{
	    return element.getText().trim();
	}
	else
	{
	    return "";
	}
    }
    
    /**
     * Method to handle alert box
     */
    public void handleAlert ()
    {
	try
	{
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception occured during alert handle {}",
		    ex.getMessage());
	}
    }
    
    /**
     * Method to wait for specific time till element is present
     * 
     * @param element
     * @throws Exception
     */
    public void waitForElementPresent (WebElement element) throws Exception
    {
	// FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	// .withTimeout(120, TimeUnit.SECONDS).pollingEvery(5,
	// TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	
	WebDriverWait wait = new WebDriverWait(driver, 120);
	try
	{
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	catch (NoSuchElementException nsee)
	{
	    ProLogger.error("No Such Element {}", nsee.getMessage());
	}
    }
    /*
    **
    * Method to wait for specific time till element is present
    * 
    * @param element
    * @throws Exception
    */
   public void waitForElementPresent (List<WebElement> element) throws Exception
   {
	// FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	// .withTimeout(120, TimeUnit.SECONDS).pollingEvery(5,
	// TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	
	WebDriverWait wait = new WebDriverWait(driver, 120);
	try
	{
	    wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	catch (NoSuchElementException nsee)
	{
	    ProLogger.error("No Such Element {}", nsee.getMessage());
	}
   }
    
    /**
     * Method to wait for specific time till element is present
     * 
     * @param element
     * @param waitTimeSecs
     * @throws InterruptedException
     */
    public void waitForElementPresent (final WebElement element,
	    int waitTimeSecs)
	    throws Exception
    {
	isElementPresent(element, waitTimeSecs);
    }
    
    /**
     * Method to wait for specific time till element is present
     * 
     * @param By
     * @param waitTimeSecs
     * @throws InterruptedException
     */
    public void waitForElementPresent (By locator, int waitTimeSecs)
	    throws Exception
    {
	isElementPresentByLocator(locator, waitTimeSecs);
    }
    
    /**
     * Method to hover and click element
     * 
     * @param parentElement
     * @param childElement
     * @throws Exception
     */
    public void
	    hoverAndClick (WebElement parentElement, WebElement childElement)
		    throws Exception
    {
	driver.getCurrentUrl().trim();
	try
	{
	    Actions action = new Actions(driver);
	    action.moveToElement(parentElement);
	    action.perform();
	    Thread.sleep(1000);
	    action.moveToElement(childElement);
	    action.click();
	    action.perform();
	    Thread.sleep(1000);
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception occured during hover and click {}",
		    ex.getMessage());
	}
    }
    
    /**
     * Method to check if element is Present with in an element for some seconds
     * 
     * @param element
     * @param elementBy
     * @param waitForSeconds
     * @return
     * @throws Exception
     */
    public boolean isElementPresent (WebElement element, By elementBy,
	    int waitForSeconds) throws Exception
    {
	boolean elementPresent = true;
	int count = 0;
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	while (elementPresent)
	{
	    try
	    {
		if (element.findElement(elementBy).isDisplayed())
		{
		    break;
		}
		else
		{
		    if (count == waitForSeconds)
		    {
			elementPresent = false;
			break;
		    }
		    Thread.sleep(1000);
		    count++;
		}
	    }
	    catch (Exception ex)
	    {
		ProLogger.error("Exception in finding element {}",
			ex.getMessage());
		if (count == waitForSeconds)
		{
		    elementPresent = false;
		    break;
		}
		Thread.sleep(1000);
		count++;
	    }
	}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return elementPresent;
    }
    
    /**
     * Method to check web element is present
     * 
     * @param By
     * @param waitTime
     * @return
     * @throws Exception
     */
    public boolean isElementPresentByLocator (By locator, int waitTime)
	    throws Exception
    {
	boolean elementPresent = true;
	int count = 0;
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	while (elementPresent)
	{
	    try
	    {
		if (driver.findElement(locator).isDisplayed())
		{
		    break;
		}
		else
		{
		    if (count == waitTime)
		    {
			elementPresent = false;
			break;
		    }
		    Thread.sleep(1000);
		    count++;
		}
	    }
	    catch (Exception ex)
	    {
		ProLogger.error("Exception in finding element {}",
			ex.getMessage());
		if (count == waitTime)
		{
		    elementPresent = false;
		    break;
		}
		Thread.sleep(1000);
		count++;
	    }
	}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return elementPresent;
    }
    
    /**
     * Method to check web element is present
     * 
     * @param element
     * @param waitTime
     * @return
     * @throws Exception
     */
    public boolean isElementPresent (WebElement element, int waitTime)
	    throws Exception
    {
	boolean elementPresent = true;
	int count = 0;
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	while (elementPresent)
	{
	    try
	    {
		if (element.isDisplayed())
		{
		    break;
		}
		else
		{
		    if (count == waitTime)
		    {
			elementPresent = false;
			break;
		    }
		    Thread.sleep(1000);
		    count++;
		}
	    }
	    catch (Exception ex)
	    {
		ProLogger.error("Exception in finding element {}",
			ex.getMessage());
		if (count == waitTime)
		{
		    elementPresent = false;
		    break;
		}
		Thread.sleep(1000);
		count++;
	    }
	}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return elementPresent;
    }
    
    /**
     * Method to wait for page to get loaded
     */
    public void waitForPageLoad (WebDriver driver)
    {
	ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
	{
	    
	    
	    public Boolean apply (WebDriver driver)
	    {
		return ((JavascriptExecutor) driver).executeScript(
			"return document.readyState;").equals("complete");
	    }
	};
	WebDriverWait wait = new WebDriverWait(driver, 30);
	try
	{
	    wait.until(expectation);
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in wait for page load {}",
		    ex.getMessage());
	}
    }
    
    /**
     * Component to move actual mouse pointer to top left corner of page.
     * 
     * @throws AWTException
     */
    public void moveActualMouse () throws AWTException
    {
	Robot robot = new Robot();
	robot.mouseMove(0, 0);
	robot = null;
    }
    
    /**
     * Component to move actual mouse pointer to top left corner of page
     * 
     * @param x
     * @param y
     * @throws AWTException
     */
    public void moveActualMouse (int x, int y) throws AWTException
    {
	Robot robot = new Robot();
	robot.mouseMove(x, y);
	robot = null;
    }
    
    /**
     * Component to click on close button of overlay and wait to until the
     * overlay closes itself.
     * 
     * @param elementToCheck
     * @param closeButton
     * @throws Exception
     */
    public void clickAndWaitUntilDisappear (WebElement elementToCheck,
	    WebElement closeButton) throws Exception
    {
	if (isElementPresent(elementToCheck, 0))
	{
	    clickElement(closeButton);
	    while (true)
	    {
		if (isElementPresent(elementToCheck, 1))
		{
		}
		else
		{
		    break;
		}
	    }
	}
    }
    
    /**
     * Component to wait until the overlay closes itself
     * 
     * @param elementToCheck
     * @throws Exception
     */
    public void waitUntilDisappear (WebElement elementToCheck) throws Exception
    {
	int i = 0;
	while (true)
	{
	    if (isElementPresent(elementToCheck, 1))
	    {
	    }
	    else
	    {
		break;
	    }
	    if (i == 10)
	    {
		break;
	    }
	    i++;
	}
    }
    
    /**
     * Component to paste text to a control
     * 
     * @param pasteElement
     * @throws Exception
     */
    public void pasteText (WebElement pasteElement) throws Exception
    {
	if (isElementPresent(pasteElement))
	{
	    clearInput(pasteElement);
	    pasteElement.sendKeys(Keys.CONTROL + "v");
	}
    }
    
    /**
     * Component to get attribute value for a particular control
     * 
     * @param element
     * @param attribute
     * @return
     * @throws Exception
     */
    public String getAttribute (WebElement element, String attribute)
	    throws Exception
    {
	String attributeValue = "";
	if (isElementPresent(element))
	{
	    attributeValue = element.getAttribute(attribute);
	}
	return attributeValue;
    }
    
    /**
     * Component to get attribute value for a particular control
     * 
     * @param element
     * @param attribute
     * @return
     * @throws Exception
     */
    public String getAttributeControl (WebElement element, String attribute)
	    throws Exception
    {
	String attributeValue = "";
	if (isElementPresent(element, 2))
	{
	    attributeValue = element.getAttribute(attribute);
	}
	return attributeValue;
    }
    
    /**
     * Component to get CSS value for a particular control
     * 
     * @param element
     * @param cssAttribute
     * @return
     * @throws Exception
     */
    public String getCssValue (WebElement element, String cssAttribute)
	    throws Exception
    {
	String cssValue = "";
	if (isElementPresent(element))
	{
	    cssValue = element.getCssValue(cssAttribute);
	}
	return cssValue;
    }
    
    /**
     * Method to getLocation for a particular element
     * 
     * @param element
     * @return
     * @throws Exception
     */
    public Point getLocation (WebElement element) throws Exception
    {
	Point locations = new Point(0, 0);
	if (isElementPresent(element, 5))
	{
	    locations = element.getLocation();
	}
	return locations;
    }
    
    /**
     * Method to refresh web page
     * 
     * @throws Exception
     */
    public void refresh () throws Exception
    {
	driver.navigate().refresh();
    }
    
    /**
     * Method to get no of webElements count
     * 
     * @param element
     * @return
     * @throws Exception
     */
    public int getElementsCount (List<WebElement> elements) throws Exception
    {
	int noOfElements = 0;
	if (noWaitElementPresent(elements))
	{
	    noOfElements = elements.size();
	}
	return noOfElements;
    }
    
    /**
     * @param elements
     * @return
     */
    private boolean noWaitElementPresent (List<WebElement> elements)
    {
	return false;
    }
    
    /**
     * Method to get webElements
     * 
     * @param elementBy
     * @return
     * @throws Exception
     */
    public List<WebElement> getWebElements (WebElement element, By elementBy)
	    throws Exception
    {
	List<WebElement> lstWebElements = new ArrayList<WebElement>();
	if (noWaitElementPresent(element))
	{
	    lstWebElements = element.findElements(elementBy);
	}
	return lstWebElements;
    }
    
    /**
     * Method to get webElements
     * 
     * @param elementBy
     * @return
     * @throws Exception
     */
    public List<WebElement> getElements (WebElement webElement, By elementBy)
	    throws Exception
    {
	List<WebElement> lstWebElements = new ArrayList<WebElement>();
	if (isElementPresent(webElement, elementBy, 2))
	{
	    lstWebElements = webElement.findElements(elementBy);
	}
	return lstWebElements;
    }
    
    /**
     * Method to get element count
     * 
     * @param webElement
     * @param elementBy
     * @return
     * @throws Exception
     */
    public int getElementsCount (WebElement webElement, By elementBy)
	    throws Exception
    {
	int noOfElements = 0;
	if (isElementPresent(webElement, elementBy, 0))
	{
	    noOfElements = webElement.findElements(elementBy).size();
	}
	return noOfElements;
    }
    
    /**
     * Method to open new tab
     * 
     * @param url
     */
    public void openTab (String url)
    {
	String script = "var d=document,a=d.createElement('a');a.target='_blank';a.href='%s';a.innerHTML='.';d.body.appendChild(a);return a";
	script = String.format(script, url);
	Object element = ((JavascriptExecutor) driver).executeScript(script);
	if (element instanceof WebElement)
	{
	    WebElement anchor = (WebElement) element;
	    anchor.click();
	    ((JavascriptExecutor) driver).executeScript(
		    "var a=arguments[0];a.parentNode.removeChild(a);", anchor);
	    Set<String> handles = driver.getWindowHandles();
	    String current = driver.getWindowHandle();
	    handles.remove(current);
	    String newTab = handles.iterator().next();
	    driver.switchTo().window(newTab);
	}
    }
    
    /**
     * Method to trigger javascript on web element
     * 
     * @param script
     * @param element
     */
    public void trigger (String script, WebElement element)
    {
	((JavascriptExecutor) driver).executeScript(script, element);
    }
    
    /**
     * Executes a script
     * 
     * @note Really should only be used when the web driver is sucking at
     *       exposing functionality natively
     * @param script
     *            The script to execute
     */
    public Object trigger (String script)
    {
	return ((JavascriptExecutor) driver).executeScript(script);
    }
    
    /**
     * Method to get width in pixels of an element
     * 
     * @param element
     * @return
     * @throws Exception
     */
    public int getWidth (WebElement element) throws Exception
    {
	int width = 0;
	if (noWaitElementPresent(element))
	{
	    width = element.getSize().getWidth();
	}
	return width;
    }
    
    /**
     * Method to get height in pixels of an element
     * 
     * @param element
     * @return
     * @throws Exception
     */
    public int getHeight (WebElement element) throws Exception
    {
	int height = 0;
	if (noWaitElementPresent(element))
	{
	    height = element.getSize().getHeight();
	}
	return height;
    }
    
    /**
     * Method to hover on some element
     * 
     * @param parentElementBy
     * @throws Exception
     */
    public void hoverOn (By parentElementBy) throws Exception
    {
	driver.getCurrentUrl().trim();
	try
	{
	    Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(parentElementBy));
	    action.perform();
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in hover on element {}",
		    ex.getMessage());
	}
    }
    
    /**
     * Method to hover on some element
     * 
     * @param parentElementBy
     * @throws Exception
     */
    public void hoverOn (WebElement element) throws Exception
    {
	driver.getCurrentUrl().trim();
	try
	{
	    Actions action = new Actions(driver);
	    action.moveToElement(element,24,0).click().build();
	    action.perform();
	}
	catch (Exception ex)
	{
	    ProLogger.error("Exception in hover on element {}",
		    ex.getMessage());
	}
    }
    /**
     * Method to clear browser history
     * 
     * @throws Exception
     */
    public void clearHistory () throws Exception
    {
	driver.manage().deleteAllCookies();
	refresh();
    }
    
    /**
     * Method to set display style of element to block
     * 
     * @param elementBy
     */
    public void blockElement (By elementBy)
    {
	WebElement weElement = driver.findElement(elementBy);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	((RemoteWebDriver) executor).executeScript(
		"arguments[0].style.display = 'block';", weElement);
    }
    
    /**
     * Method to check if element is selected
     * 
     * @param elementBy
     * @return
     * @throws Exception
     */
    public boolean isSelected (By elementBy) throws Exception
    {
	return driver.findElement(elementBy).isSelected();
    }
    
    /**
     * Wait for page ready
     */
    public void checkPageIsReady ()
    {
	javaScript = (JavascriptExecutor) driver;
	for (int i = 0; i < 75; i++)
	{
	    try
	    {
		Thread.sleep(5000);
	    }
	    catch (Exception ex)
	    {
		ProLogger.error("caught exception while loading page{}",
			ex.getMessage());
		throw new FrameworkException(
			"caught exception while loading page{}", ex);
	    }
	    if ("complete".equalsIgnoreCase(javaScript
		    .executeScript("return document.readyState").toString()))
	    {
		break;
	    }
	}
    }
    
}
