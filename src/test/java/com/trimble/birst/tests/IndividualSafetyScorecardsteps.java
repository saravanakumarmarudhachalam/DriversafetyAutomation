/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.IndividualScorecardpage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author smarudh
 */
public class IndividualSafetyScorecardsteps
{
    
    
    public WebDriver driver;
    
    String lastThirtdaystxt, startDate, endDate, exePagedriverName,
	    overallScore, totalDistance, idleDuration;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    public IndividualScorecardpage individualScorepage;
    
    /**
     * Constructor
     */
    public IndividualSafetyScorecardsteps()
    {
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	individualScorepage = new IndividualScorecardpage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @And("^I clicked on driver name in Executive console$")
    public void clickDrivername () throws Throwable
    {
	lastThirtdaystxt = driverSafetypage.getTextlastThirtydays();
	startDate = driverSafetypage.getTextstartDate();
	endDate = driverSafetypage.getTextendDate();
	exePagedriverName = driverSafetypage.getTextdriverName();
	overallScore = driverSafetypage.getTextoverallScoreofDrivername();
	totalDistance = driverSafetypage.getTexttotalDistanceRoundoff();
	idleDuration = driverSafetypage.getTextidleDuration();
	driverSafetypage.executivePagedriverLink.click();
	Reporter.log(Constants.INDIVIDUAL_SCORECARD_DISPLAYED);
    }
    
    @Then("^Verify Individual Scorecard is displayed for that driver$")
    public void verifyIndividualscorePage () throws Throwable
    {
	driverSafetypage.waitFornewWindowandSwitchtoIt(driver);
	String individualScoredriverName;
	individualScoredriverName = individualScorepage
		.getTextindividualScoredriverNameinFilter();
	Assert.assertEquals(exePagedriverName,
		individualScoredriverName.replace("= ", ""));
	Reporter.log(
		Constants.DRIVER_NAME_IN_EXECUTIVE_CONSOLE_AND_INDIVIDUAL_SCORECARD_MATCHES);
    }
    
    @Then("^I verified the Date filter settings is displayed correctly$")
    public void verifyDatefilterSettings () throws Throwable
    {
	Assert.assertEquals(
		driverSafetypage.getTextlastThirtydays(),
		lastThirtdaystxt, Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.LAST30DAYS_FILTER_TEXT_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextstartDate(),
		startDate, Constants.STARTDATEFILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.STARTDATEFILTER_TEXT_DISPLAYED);
	Assert.assertEquals(driverSafetypage.getTextendDate(),
		endDate, Constants.ENDDATEFILTER_TEXT_DISPLAYED);
	Reporter.log(Constants.ENDDATEFILTER_TEXT_DISPLAYED);
    }
    
    @Then("^I verified overall score in dashlet in Individual Scorecard$")
    public void verifyOverallscoreDashlet () throws Throwable
    {
	Assert.assertEquals(
		individualScorepage.getTextoverallScoreIndivudalscoreCard(),
		overallScore, Constants.OVERALLSCORE_INDIVIDUAL_SCORECARD);
	Reporter.log(Constants.OVERALLSCORE_INDIVIDUAL_SCORECARD);
    }
    
    @Then("^I Verify Target is enabled in the Bar chart in individual Scorecard$")
    public void verifyBarchartTargetisEnabled () throws Throwable
    {
	String targetWhenenabled;
	targetWhenenabled = driverSafetypage.getAttributetargetLine();
	Assert.assertEquals(targetWhenenabled, "legend-item");
    }
    
    @Then("^I clicked the Target in individual Scorecard$")
    public void clickTargetinBarchart () throws Throwable
    {
	driverSafetypage.clickBarcharttarget();
	
    }
    
    @Then("^I verify Target is disabled in the bar chart in individual Scorecard$")
    public void veirfyBarchartTargetisDisabled () throws Throwable
    {
	String targetWhendiabled;
	targetWhendiabled = driverSafetypage.getAttributetargetLine();
	Assert.assertEquals(targetWhendiabled, "legend-item filtered-legend");
    }
    
    @Then("^I verified total distance KPI in Individual Scorecard$")
    public void veirfyTotaldistanceKPI () throws Throwable
    {
	Assert.assertEquals(individualScorepage.getTexttotalDistanceKPI(),
		totalDistance,
		Constants.TOTALDISTANCE_KPI_INDIVIDUAL_SCORECARD);
	Reporter.log(Constants.TOTALDISTANCE_KPI_INDIVIDUAL_SCORECARD);
    }
    
    @Then("^I verified Idling Duration in Individual Scorecard$")
    public void veirfyIdlingduraction () throws Throwable
    {
	Assert.assertEquals(
		individualScorepage.getTextidlingDurationindividualScorecard(),
		idleDuration,
		Constants.IDLING_DURATION_INDIVIDUAL_SCORECARD);
	Reporter.log(Constants.IDLING_DURATION_INDIVIDUAL_SCORECARD);
    }
    
    @And("^I Changed to Kilometers$")
    public void changeTokilemeter () throws Throwable
    {
	individualScorepage.changeTokilometer();
    }
    
    @Then("^I verified Kilometer Text has been changed$")
    public void verifyKilometerchanged () throws Throwable
    {
	Assert.assertEquals(individualScorepage.getTxteventPerkiloMeter(),
		Constants.EVENT_PER_KILOMETER,
		Constants.EVENT_PER_KILOMETER_TEXT_MATCHED);
	Reporter.log(Constants.EVENT_PER_KILOMETER_TEXT_MATCHED);
    }
    
    @And("^I Changed to customdateRange$")
    public void changeTocustomDaterange () throws Throwable
    {
	individualScorepage.changeTocustomDaterange();
    }
    
    @And("^I filtered the EventStartdate and enddate$")
    public void changeTocustomEventstartEnddate () throws Throwable
    {
	individualScorepage.enterCustomstartDate();
	individualScorepage.enterCustomendDate();
    }
    
    @Then("^I verified Event Data and time$")
    public void verifyEventdateAndtime () throws Throwable
    {
	individualScorepage.scrollVertically();
	individualScorepage.verifyEventdateTime();
    }
}
