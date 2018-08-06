package com.trimble.taf.pagefactory.application;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.poifs.storage.DocumentBlock;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;

/**
 * @author smarudh
 */
public class DriverSafetyPage extends AbstractPage
{
    
    
    @FindBy(xpath = "//*[@id='xpath-dashboard-canvas']/div/dashlet[1]/div[1]/report/image-report/img")
    public WebElement trimblePulseImg;
    
    @FindBy(xpath = "//*[@id='xpath-dashboard-canvas']//div/p/span[contains(text(),'Executive')]")
    public WebElement lnkExecDSConsole;
    
    @FindBy(css = "#page-dashboard-breadcrumb > h1 > a > span.ng-binding")
    public WebElement driversafetyHomepage;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(5) > span")
    public WebElement last30daysFilter;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(6) > span")
    public WebElement startDatefilter;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(7) > span")
    public WebElement endDatefilter;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(6) > span")
    public WebElement last30daysFilterIndiviudalscorecard;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(7) > span")
    public WebElement startDatefilterIndiviudalscorecard;
    
    @FindBy(css = "#background-color-wrapper > div.sub-head.ng-scope > div.filters-wrap.ng-scope > ul > li > a:nth-child(8) > span")
    public WebElement endDatefilterIndiviudalscorecard;
    
    @FindBy(css = "#global-header > header > ng-include > div > div > ul > li.nav-item-open > button")
    public WebElement folderIcon;
    
    @FindBy(xpath = "//span[text() = \"Scorecard Report - combined groups\"]")
    public WebElement combinedScorecard;
    
    @FindBy(xpath = "//span[text() = \"Scorecard Report - separated groups\"]")
    public WebElement separatedScorecard;
    
    @FindBy(xpath = "//span[text() = \"Executive Console\"]")
    public WebElement executiveConsole;
    
    @FindAll({
	    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(6) > div.dashlet-wrapper.ng-scope > report > image-report > img"),
	    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(11) > div.dashlet-wrapper.ng-scope > report > image-report")
    })
    public WebElement trimbleLogo;
    
    @FindBy(css = "i[class='table-sorting ASC']")
    public WebElement overallScoreasc;
    
    @FindBy(css = "td[id = org-name]")
    public WebElement defaultOrg;
    
    @FindBy(xpath = "//*[@id='global-header']/header/ng-include/div/div/ul/li[4]/a")
    public WebElement exportIcon;
    
    @FindBy(xpath = "//span[text() = \"Printable PDF\"]")
    public WebElement exportPDF;
    
    @FindBy(xpath = "//span[text() = \"Printable PDF (with Details)\"]")
    public WebElement exportDetailPDF;
    
    @FindBy(xpath = "//*[@id=\"info-dashboardExportInProgress\"]/div/span/span[1]")
    public WebElement exportInprogress;
    
    @FindBy(xpath = "//text[@dy = '-.1em' and @class='c3-gauge-value']")
    public WebElement overallScoredonutChart;
    
    @FindBy(xpath = "//*[@id='table-view-27']/div[1]/div/div[1]/div/div[3]/i")
    public List<WebElement> sortedColumndataTable;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[1]/div[1]/div[3]/i")
    public WebElement sortedParticularcolumn;
    
    @FindBy(xpath = "//*[@id='table-view-27']/div[1]/div/div[2]/div/div/div[2]")
    public List<WebElement> gridValues;
    
    @FindAll({
	    @FindBy(xpath = "//*[@id='chart25']/div[2]/div[1]/div/div/div/div[2]"),
	    @FindBy(xpath = "//*[@id='chart10']/div[2]/div[1]/div/div/div/div[2]")
    })  
    public WebElement barchartTarget;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div[1]/div")
    public WebElement executivePagedriverName;    
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div[1]/div/div/span/a")     
    public WebElement executivePagedriverLink;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div[3]/div/div[2]/span")    
    public WebElement overallScoreforDrivers;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div[10]/div/div/span")
    public WebElement totalDistance;
    
    @FindBy(xpath = "//div[contains(@id,'tableChart')]/div/div/div[2]/div[9]/div/div/span")
    public WebElement idleDurationexecConsole;
    
    @FindBy(xpath = "//div[@id=\"dashboard-5e343324-ee23-42b6-b172-9c3cb8e0ff76\"]/div[1]")
    public WebElement driverSafetydropdown;
    
    
    
    public DriverSafetyPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    /**
     * Verify Trimble pulse image is displayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyTrimblepulseImg () throws Exception
    {
	waitForElementPresent(trimblePulseImg);
	return trimblePulseImg.isDisplayed();
    }
    
    /**
     * Click the Executive Driver safety console link
     * 
     * @throws Exception
     */
    public void clickExecutidriverSafetyconsole () throws Exception
    {
	waitForElementPresent(lnkExecDSConsole);
	lnkExecDSConsole.click();
    }
    
    /**
     * Check Executive console page is displayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyExectiveconsolePage () throws Exception
    {
	waitForElementPresent(driversafetyHomepage);
	return driversafetyHomepage.isDisplayed();
    }
    
    /**
     * Verify Last 30 Days filter should be displayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyLastthirtyDaysfilter () throws Exception
    {
	waitForElementPresent(last30daysFilter);
	return last30daysFilter.isDisplayed();
    }
    
    /**
     * Get text from 30days Days filter
     * 
     * @return
     * @throws Exception
     */
    public String getTextthirtyDayfilter () throws Exception
    {
	waitForElementPresent(last30daysFilter);
	return last30daysFilter.getText();
    }
    
    /**
     * verify Start Date filter is dusplayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyStartdateDisplayed () throws Exception
    {
	waitForElementPresent(startDatefilter);
	return isElementDisplayed(startDatefilter);
    }
    
    /**
     * verify End Date filter is dusplayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyEnddateDisplayed () throws Exception
    {
	waitForElementPresent(endDatefilter);
	return isElementDisplayed(endDatefilter);
    }
    
    /**
     * verify End Date filter is dusplayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyThritydaysFilterdisplayed () throws Exception
    {
	waitForElementPresent(last30daysFilter);
	return isElementDisplayed(last30daysFilter);
    }
    
    /**
     * Click Folder Icon
     * 
     * @throws Exception
     */
    public void clickFoldericon () throws Exception
    {
	folderIcon.click();
	checkPageIsReady();
    }
    
    /**
     * Click Driver safety dropdown
     * @throws Exception 
     */
    public void clickDriversafetyDropdown() throws Exception
    {
	driverSafetydropdown.click();
	checkPageIsReady();
	
    }
    /**
     * Click Scorecard Report - Combined Groups
     * 
     * @throws Exception
     */
    public void clickCombinedscoreCard () throws Exception
    {
	combinedScorecard.click();
	checkPageIsReady();
    }
    
    /**
     * Click Scorecard Report - Separated Groups
     * 
     * @throws Exception
     */
    public void clickSeparatedscoreCard () throws Exception
    {
	separatedScorecard.click();
	checkPageIsReady();
    }
    
    /**
     * Click Scorecard Report - Separated Groups
     * 
     * @throws Exception
     */
    public void clickExectiveconsole() throws Exception
    {
	executiveConsole.click();
	checkPageIsReady();
    }
    
    /**
     * verify Trimble logo is displayed
     * 
     * @throws Exception
     */
    public boolean verifyTrimblelogo () throws Exception
    {
	waitForElementPresent(trimbleLogo);
	return isElementDisplayed(trimbleLogo);
    }
    
    /**
     * Get text last 30days date filter
     * 
     * @return
     * @throws Exception
     */
    public String getTextlastThirtydays () throws Exception
    {
	waitForElementPresent(last30daysFilter);
	return getText(last30daysFilter);
    }
    
    /**
     * Get Text of Start Date
     * 
     * @throws Exception
     */
    public String getTextstartDate () throws Exception
    {
	waitForElementPresent(startDatefilter);
	return getText(startDatefilter);
    }
    
    /**
     * Get Text of End Date
     * 
     * @throws Exception
     */
    public String getTextendDate () throws Exception
    {
	waitForElementPresent(endDatefilter);
	return getText(endDatefilter);
    }
    
    /**
     * Get text last 30days date filter for individual scorecard
     * 
     * @return
     * @throws Exception
     */
    public String getTextlastThirtydays_Indvscorecard () throws Exception
    {
	waitForElementPresent(last30daysFilterIndiviudalscorecard);	
	return getText(last30daysFilterIndiviudalscorecard);
    }
    
    /**
     * Get Text of Start Date for individual scorecard
     * 
     * @throws Exception
     */
    public String getTextstartDate_Indvscorecard () throws Exception
    {
	waitForElementPresent(startDatefilterIndiviudalscorecard);
	return getText(startDatefilterIndiviudalscorecard);
    }
    
    /**
     * Get Text of End Date for individual scorecard
     * 
     * @throws Exception
     */
    public String getTextendDate_Indvscorecard () throws Exception
    {
	waitForElementPresent(endDatefilterIndiviudalscorecard);
	return getText(endDatefilterIndiviudalscorecard);
    }
    
    /**
     * Verify Overallscore displayed in Ascending Order
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyOverallscoreAsc () throws Exception
    {
	waitForElementPresent(overallScoreasc);
	return isElementDisplayed(overallScoreasc);
	
    }
    
    /**
     * Get Text of Default Organization
     * 
     * @throws Exception
     */
    public String getTextdefaultOrg () throws Exception
    {
	checkPageIsReady();	
	return getText(defaultOrg);
    }
    
    /**
     * Verify Report is able to export
     * 
     * @throws Exception
     */
    public void clickExporticon () throws Exception
    {
	waitForElementPresent(exportIcon);
	exportIcon.click();
    }
    
    /**
     * Click the Export PDF dropdown.
     * 
     * @throws Exception
     */
    public void clickExportPDF () throws Exception
    {
	waitForElementPresent(exportPDF);
	exportPDF.click();
    }
    
    /**
     * Verify Export is in Progress message.
     * 
     * @throws Exception
     */
    public String getTextexportInprogress () throws Exception
    {
	waitForElementPresent(exportInprogress);
	return getText(exportInprogress);
    }
    
    /**
     * Click the Export PDF dropdown.
     * 
     * @throws Exception
     */
    public void clickExportdetailPDF () throws Exception
    {
	waitForElementPresent(exportDetailPDF);
	exportDetailPDF.click();
    }
    
    
    
    /**
     * Verify PDF is exported correctly
     * 
     * @param downloadPath
     * @param fileName
     * @return
     */
    public boolean isFileDownloaded (String downloadPath, String fileName)
    {
	boolean flag = false;
	File dir = new File(downloadPath);
	File[] dir_contents = dir.listFiles();
	
	for (int i = 0; i < dir_contents.length; i++)
	{
	    if (dir_contents[i].getName().equals(fileName))
		return flag = true;
	}
	
	return flag;
    }
    
    /**
     * @throws Exception
     */
    public void sortDataTableBasedOnUserSelectedSortColumn () throws Exception
    {
	
	waitForElementPresent(sortedColumndataTable);
	for (int i = 1; i <= sortedColumndataTable.size(); i++)
	{
	    waitForElementPresent(driver.findElement(
		    By.xpath("//*[@id='table-view-27']/div[1]/div/div[1]/div["
			    + i + "]/div[3]/i")));
	    WebElement sorted = driver.findElement(
		    By.xpath("//*[@id='table-view-27']/div[1]/div/div[1]/div["
			    + i + "]/div[3]/i"));
	    
	    if (!sorted.getAttribute("class").contains("ASC"))
	    {
		clickElement(driver.findElement(By
			.xpath("//*[@id='table-view-27']/div[1]/div/div[1]/div["
				+ i + "]/div[3]/i")));
		checkPageIsReady();
		Assert.assertTrue(Constants.SORTED_ASC_DESC_WORKING_CORRECTLY,
			sorted.getAttribute("class").contains("ASC"));
	    }
	    
	    if (!sorted.getAttribute("class").contains("DESC"))
	    {
		clickElement(driver.findElement(By
			.xpath("//*[@id='table-view-27']/div[1]/div/div[1]/div["
				+ i + "]/div[3]/i")));
		checkPageIsReady();
		Assert.assertTrue(Constants.SORTED_ASC_DESC_WORKING_CORRECTLY,
			sorted.getAttribute("class").contains("DESC"));
		
	    }
	}
    }
    
    /**
     * verify the score grid column will be displayed in Ascending and
     * Descending
     * 
     * @throws Exception
     */
    public void sortTableascDescanyColumn () throws Exception
    {
	checkPageIsReady();
	waitForElementPresent(sortedParticularcolumn);
	clickElement(sortedParticularcolumn);
	if (!sortedParticularcolumn.getAttribute("class").contains("ASC"))
	{
	    checkPageIsReady();
	    Assert.assertTrue(Constants.SORTED_ASC_DESC_WORKING_CORRECTLY,
		    sortedParticularcolumn.getAttribute("class")
			    .contains("ASC"));
	    
	}
	clickElement(sortedParticularcolumn);
	if (!sortedParticularcolumn.getAttribute("class").contains("DESC"))
	{
	    checkPageIsReady();
	    Assert.assertTrue(Constants.SORTED_ASC_DESC_WORKING_CORRECTLY,
		    sortedParticularcolumn.getAttribute("class")
			    .contains("DESC"));
	}
    }
    
    /**
     * Verify the value should display without decimal point
     */
    public List<String> verifyWOdecimalPoint ()
    {
	List<String> acutal = new ArrayList<String>();
	checkPageIsReady();
	for (int i = 0; i < gridValues.size(); i++)
	{
	    List<WebElement> values = gridValues.get(i)
		    .findElements(By.tagName("span"));
	    String value = values.get(0).getText();
	    Double j = Double.parseDouble(value);
	    try
	    {
		if (j % 1 == 0)
		{
		    ProLogger.info(
			    Constants.GRIDVALUES_DISPLAYED_WODECMIAL_VALUE);
		}
	    }
	    catch (Exception e)
	    {
		ProLogger.error(
			Constants.GRIDVALUES_DISPLAYED_WITHDECMIAL_VALUE,
			e.getMessage());
	    }
	    acutal.add(values.get(0).getText());
	}
	
	return acutal;
    }
    
    /**
     * Verify Barchart Target is present
     */
    public void clickBarcharttarget () throws Exception
    {
	waitForElementPresent(barchartTarget);
	barchartTarget.click();
    }
    
    /**
     * Get the Class attribute name
     * 
     * @return
     * @throws Exception
     */
    public String getAttributetargetLine () throws Exception
    {
	waitForElementPresent(barchartTarget);
	checkPageIsReady();
	return barchartTarget.getAttribute("class");
    }
    
    /**
     * Check Individual Scorecard page is displayed
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyIndividualscorecardPage () throws Exception
    {
	waitForElementPresent(driversafetyHomepage);
	return driversafetyHomepage.isDisplayed();
    }
    
    /**
     * Get the text from Driver name
     * 
     * @return
     * @throws Exception
     */
    public String getTextdriverName () throws Exception
    {
	waitForElementPresent(executivePagedriverName);
	checkPageIsReady();
	return executivePagedriverName.getText();
    }
    
    /**
     * Wait for windows to Switch To
     * 
     * @param driver
     * @throws InterruptedException
     */
    public void waitFornewWindowandSwitchtoIt (WebDriver driver)
	    throws InterruptedException
    {
	checkPageIsReady();
	Set<String> window_handles = driver.getWindowHandles();
	Iterator<String> iterate = window_handles.iterator();
	String first = iterate.next();
	String second = iterate.next();
	driver.switchTo().window(second);
    }
    
    /**
     * Get text from overall score in dashlet of driver name
     * 
     * @return
     * @throws Exception
     */
    public String getTextoverallScoreofDrivername () throws Exception
    {
	waitForElementPresent(overallScoreforDrivers);
	return getText(overallScoreforDrivers);
    }
    
    /**
     * Get text from Total Distance
     * 
     * @return
     * @throws Exception
     */
    public String getTexttotalDistance () throws Exception
    {
	waitForElementPresent(totalDistance);
	String value = getText(totalDistance);
	Double j = Double.parseDouble(value);
	String numWihoutDecimal = String.valueOf(j).split("\\.")[0];
	return numWihoutDecimal;
    }
    
    /**
     * Get text from Total Distance
     * 
     * @return
     * @throws Exception
     */
    public String getTexttotalDistanceRoundoff () throws Exception
    {
	waitForElementPresent(totalDistance);
	String value = getText(totalDistance);
	Double j = Double.parseDouble(value);
	double roundOff = Math.round(j);
	String numWihoutDecimal = String.valueOf(roundOff).split("\\.")[0];
	return numWihoutDecimal;
    }
    
    /**
     * Get Text from Idle Duration in Executive Console
     * @return
     * @throws Exception
     */
    public String getTextidleDuration() throws Exception{
	waitForElementPresent(idleDurationexecConsole);
	return getText(idleDurationexecConsole);
    }
    
}
