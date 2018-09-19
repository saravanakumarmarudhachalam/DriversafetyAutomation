/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */
public class SupervisorConsolepage extends AbstractPage
{
    
    
    /**
     * @param driver
     */
    public SupervisorConsolepage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//span[text() = \"Supervisor Console\"]")
    public WebElement superVisorconsoleDashboard;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div/div/div[2]/span")
    public List<WebElement> superVisorconsoleDriverscores;
    
    @FindBy(xpath="//div[contains(@id,'chart')]/div[1]/div/canvas")
    public WebElement driverSafetyeventchart;
    
    public void invokeSupervisorconsole () throws Exception
    {
	superVisorconsoleDashboard.click();
	checkPageIsReady();
	
    }
    
    /**
     * Verify color coded in the driver safety filter
     * 
     * @throws InterruptedException
     */
    public void verifyColorcodedTargetfilter () throws InterruptedException
    {
	checkPageIsReady();
	for (int i = 0; i < superVisorconsoleDriverscores.size(); i++)
	{
	    String rgbColor = superVisorconsoleDriverscores.get(i)
		    .getCssValue("color");
	    
	    if (rgbColor.equals("rgba(204, 0, 0, 1)")
		    || rgbColor.equals("rgba(213, 42, 51, 1)")
		    || rgbColor.equals("rgba(255, 129, 0, 1)")
		    || rgbColor.equals("rgba(96, 144, 0, 1)"))
	    {
		ProLogger.info(Constants.SUPERVISOR_CONSOLE_DRIVER_SAFETY_COLOR_CODED);
	    }
	    else
	    {
		Assert.fail(
			"Supervisor console Driver safety Color coded is not displayed correctly");
	    }
	    
	}
    }
    
    /**
     * Verify Driver safety Event charts is displayed
     * @return
     */
    public boolean verifyDriversafetyChartdisplayed(){
	return isElementDisplayed(driverSafetyeventchart);
    }
    
}
