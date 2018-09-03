/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */
public class IndividualScorecardpage extends AbstractPage
{
    
    
    @FindBy(xpath = "//span[text() = \"Individual Scorecard\"]")
    public WebElement individualScorecard;
    
    @FindBy(xpath = "//span[text() = \"Individual Safety Scorecard\"]")
    public WebElement individualSafetyscorecard;
    
    @FindBy(xpath = "//*[@id=\"background-color-wrapper\"]/div[2]/div[1]/ul/li/a[2]/span")
    public WebElement individualScoredriverNameinFilter;
    
    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(8) > div.dashlet-wrapper.ng-scope > report > div > div > div > h3 > span")
    public WebElement overallScoreindividualScorecard;
    
    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(5) > div.dashlet-wrapper.ng-scope > report > div > div > div > h3 > span")
    public WebElement totalDistanceindividualScorecard;
    
    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(12) > div.dashlet-wrapper.ng-scope > report > div > div > div > h3 > span")
    public WebElement idlingDurationIndividualscorecard;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(1)")
    public WebElement distanceDropdown;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(1) > div > h1")
    public WebElement distanceUnits;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[2]/label")
    public WebElement kilometerRadiobutton;
    
    @FindBy(id = "xpath-apply-prompts")
    public WebElement applyButton;
    
    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(7) > div.dashlet-wrapper.ng-scope > report > div > div > div > h2")
    public WebElement eventPerKilometerText;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[5]/span")
    public WebElement dateRangedropDown;
    
    @FindBy(xpath = "//h1[text()='Time Period']")
    public WebElement timePeriod;
    
    @FindBy(xpath = "//label[text()='Custom date range']")
    public WebElement customDaterange;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[6]/span")
    public WebElement eventStartdateDropdown;
    
    @FindBy(xpath = "//h1[text()='Time Period: Begin Date']")
    public WebElement timePeriodbeginDate;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[7]/span")
    public WebElement eventEnddateDropdown;
    
    @FindBy(xpath = "//h1[text()='Time Period: End Date']")
    public WebElement timePeriodendDate;
    
    @FindBy(xpath = "//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div[1]/div/input")
    public WebElement eventEnterdateText;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div/div/div")
    public List<WebElement> driverTable;
    
    @FindBy(id = "xpath-dashboard-canvas")
    public WebElement scroll;
    
    @FindBy(xpath ="//*[@id='page-dashboard-breadcrumb']/h1/a/span[1]")
    public WebElement individualScorecardpage;
    
    /**
     * @param driver
     */
    public IndividualScorecardpage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
    }
    
    /**
     * Click Individual scorecard
     * 
     * @throws Exception
     */
    public void clickIndividualscoreCard () throws Exception
    {
	individualScorecard.click();
	checkPageIsReady();
    }
    
    /**
     * Click Individual Safety Scorecard
     * 
     * @throws Exception
     */
    public void clickIndividualsafetyScorecard () throws Exception
    {
	waitForElementPresent(individualSafetyscorecard);
	individualSafetyscorecard.click();
    }
    
    /**
     * Get text from Individual Score card driver name
     * 
     * @return
     */
    public String getTextindividualScoredriverNameinFilter () throws Exception
    {
	waitForElementPresent(individualScoredriverNameinFilter);
	return individualScoredriverNameinFilter.getText();
    }
    
    /**
     * Get text from Overallscore Dashlet in Individual Scorecard
     * 
     * @return
     * @throws Exception
     */
    public String getTextoverallScoreIndivudalscoreCard () throws Exception
    {
	waitForElementPresent(overallScoreindividualScorecard);
	return getText(overallScoreindividualScorecard);
    }
    
    /**
     * Get Text from total Distance of KPI in individual Scorecard
     * 
     * @return
     * @throws Exception
     */
    public String getTexttotalDistanceKPI () throws Exception
    {
	waitForElementPresent(totalDistanceindividualScorecard);
	return getText(totalDistanceindividualScorecard);
    }
    
    /**
     * get Text from Idling duration from Individual Scorecard
     * 
     * @return
     * @throws Exception
     */
    public String getTextidlingDurationindividualScorecard () throws Exception
    {
	waitForElementPresent(idlingDurationIndividualscorecard);
	System.out.println(
		"Indv Scorecard:" + getText(idlingDurationIndividualscorecard));
	return getText(idlingDurationIndividualscorecard);
    }
    
    /**
     * Change Miles to Kilometers
     * 
     * @throws Exception
     */
    public void changeTokilometer () throws Exception
    {
	waitForElementPresent(distanceDropdown);
	distanceDropdown.click();
	waitForElementPresent(timePeriod);
	timePeriod.click();
	waitForElementPresent(kilometerRadiobutton);
	kilometerRadiobutton.click();
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * Get Text from Event Per Mile
     * 
     * @return
     * @throws Exception
     */
    public String getTxteventPerkiloMeter () throws Exception
    {
	waitForElementPresent(eventPerKilometerText);
	System.out.println(getText(eventPerKilometerText));
	return getText(eventPerKilometerText);
    }
    
    /**
     * Change Custom date range
     * 
     * @throws Exception
     */
    public void changeTocustomDaterange () throws Exception
    {
	
	waitForElementPresent(dateRangedropDown);
	dateRangedropDown.click();
	waitForElementPresent(timePeriod);
	timePeriod.click();
	waitForElementPresent(customDaterange);
	customDaterange.click();
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * To Enter Custom Start Date and End date
     * 
     * @throws Exception
     */
    public void enterCustomstartDate () throws Exception
    {
	waitForElementPresent(eventStartdateDropdown);
	eventStartdateDropdown.click();
	waitForElementPresent(timePeriodbeginDate);
	timePeriodbeginDate.click();
	eventEnterdateText.clear();
	eventEnterdateText.click();
	eventEnterdateText.sendKeys("07/10/2018");
	eventEnterdateText.sendKeys(Keys.ENTER);
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * To Enter Custom Start Date and End date
     * 
     * @throws Exception
     */
    public void enterCustomendDate () throws Exception
    {
	waitForElementPresent(eventEnddateDropdown);
	eventEnddateDropdown.click();
	waitForElementPresent(timePeriodendDate);
	timePeriodendDate.click();
	eventEnterdateText.clear();
	eventEnterdateText.click();
	eventEnterdateText.sendKeys("07/10/2018");
	eventEnterdateText.sendKeys(Keys.ENTER);
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * Scroll the windows veritically
     */
    public void scrollVertically ()
    {
	checkPageIsReady();
	scroll.click();
	Actions action = new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN).build().perform();
	checkPageIsReady();
    }
    
    /**
     * Verify Event Start date and Time
     */
    public void verifyEventdateTime ()
    {
	List<String> acutalResult = new ArrayList<String>();
	for (int i = 0; i < driverTable.size(); i++)
	{
	    List<WebElement> allCells = driverTable.get(i)
		    .findElements(By.tagName("span"));
	    acutalResult.add(allCells.get(0).getText());
	}
	for (String expected : acutalResult)
	{
	    try
	    {
		if (expected.contains("07/10/2018"))
		{
		    ProLogger.info(
			    Constants.EVENTDATE_FILTERED_CORRECTLY);
		}
	    }
	    catch (Exception e)
	    {
		ProLogger.error(
			Constants.EVENTDATE_FILTERED_NOT_CORRECTLY,
			e.getMessage());
	    }	    
	}
    }
    
    /**
     * To verify Individual scorecard page is displayed correctly
     * @return
     */
    public boolean verifyIndividualscorecardPage(){
	return isElementDisplayed(individualScorecardpage);
    }
}
