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
public class VehicleUtilizationReportpage extends AbstractPage
{
    
    
    @FindBy(xpath = "//span[contains(text(), '= Last 30 days')]")
    public WebElement last30Days;
    
    @FindBy(xpath = "//*[contains(@id, 'xpath-dashboard-canvas')]/div/dashlet[4]/div[1]/report/div/div/div/h3/span")
    public WebElement utilValue;
    
    @FindBy(xpath = "//*[contains(@id, 'background-color-wrapper')]/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[6]/label")
    public WebElement LastmonthTimeperiod;
    
    @FindBy(xpath = "//*[contains(@id, 'xpath-apply-prompts')]")
    public WebElement applyButton;
    
    @FindBy(xpath = "//*[contains(@id,'tableChart')]/div/div/div[2]/div/div")
    public List<WebElement> utilTablevalues;
    
    @FindBy(xpath = "//*[contains(@id,'tableChart')]/div/div/div[2]/div/div/div[2]/span")
    public List<WebElement> utilTablecolor;
    
    /**
     * @param driver
     */
    public VehicleUtilizationReportpage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    public void verifyDateFilter () throws Exception
    {
	
	Assert.assertEquals(last30Days.getText(), "= Last 30 days");
	
    }
    
    public void verifyUtilizationValue () throws Exception
    {
	checkPageIsReady();
	String UtilizationValue = utilValue.getText();
	System.out.println(UtilizationValue);
	last30Days.click();
	LastmonthTimeperiod.click();
	applyButton.click();
	checkPageIsReady();
	Assert.assertNotEquals(UtilizationValue, utilValue);
	
    }
    
    public void verifyColorofUtilization () throws Exception
    {
	checkPageIsReady();
	for (int i = 0; i < utilTablecolor.size(); i++)
	{	    
	    String rgb = utilTablecolor.get(i).getAttribute("style");
	    if (rgb.equals("color: rgb(255, 255, 255, 1);")
		    || rgb.equals("color: rgb(245, 42, 51);"))
	    {
		ProLogger.info(Constants.VEHICLE_UTILIZATION_COLOR_CODED);
	    }
	    else
	    {
		Assert.fail(
			"Vehicle Utilization Color coded is not displayed correctly");
	    }
	    
	}
	
    }
    
}
