/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.taf.pagefactory.global.AbstractPage;

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
    
    @FindBy(css="#xpath-dashboard-canvas > div > dashlet:nth-child(12) > div.dashlet-wrapper.ng-scope > report > div > div > div > h3 > span")
    public WebElement idlingDurationIndividualscorecard;
    
    @FindBy(css="#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(1)")
    public WebElement distanceDropdown;
    
    @FindBy(css="#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(1) > div > h1")
    public WebElement distanceUnits;
    
    @FindBy(xpath="//*[@id='background-color-wrapper']/aside[1]/prompt-drawer/div/div[2]/prompt-selection/form/div/div/div[2]/label")
    public WebElement kilometerRadiobutton;
    
    @FindBy(id="xpath-apply-prompts")
    public WebElement applyButton;
    
    @FindBy(css="#xpath-dashboard-canvas > div > dashlet:nth-child(7) > div.dashlet-wrapper.ng-scope > report > div > div > div > h2")
    public WebElement eventPerKilometerText;
    
    @FindBy(xpath="//*[@id='background-color-wrapper']/div[2]/div[1]/ul/li/a[5]/span")
    public WebElement dateRangedropDown;
    
    @FindBy(xpath="//h1[text()='Time Period']")
    public WebElement timePeriod;
    
    @FindBy(xpath="//label[text()='Custom date range']")
    public WebElement customDaterange;
        
    
    
    
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
     * @return
     * @throws Exception 
     */
    public String getTextidlingDurationindividualScorecard() throws Exception{
	waitForElementPresent(idlingDurationIndividualscorecard);
	System.out.println("Indv Scorecard:"+getText(idlingDurationIndividualscorecard));
	return getText(idlingDurationIndividualscorecard);
    }
 
    /**
     * Change Miles to Kilometers
     * @throws Exception
     */
    public void changeTokilometer() throws Exception{
	waitForElementPresent(distanceDropdown);
	distanceDropdown.click();
	waitForElementPresent(distanceUnits);
	distanceUnits.click();
	waitForElementPresent(kilometerRadiobutton);
	kilometerRadiobutton.click();
	waitForElementPresent(applyButton);
	applyButton.click();
    }
    
    /**
     * Get Text from Event Per Mile
     * @return
     * @throws Exception
     */
    public String getTxteventPerkiloMeter() throws Exception{
	waitForElementPresent(eventPerKilometerText);
	System.out.println(getText(eventPerKilometerText));
	return getText(eventPerKilometerText);
    }
  

}