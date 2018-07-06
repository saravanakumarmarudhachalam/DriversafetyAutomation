package com.trimble.taf.pagefactory.application;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.trimble.taf.pagefactory.global.AbstractPage;

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
    public WebElement executiveConsolehomePage;
    
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
    
    @FindBy(xpath = "//span[text() = \"Individual Scorecard\"]")
    public WebElement individualScorecard;
    
    @FindBy(xpath = "//span[text() = \"Scorecard Report - combined groups\"]")
    public WebElement combinedScorecard;
    
    @FindBy(xpath = "//span[text() = \"Scorecard Report - separated groups\"]")
    public WebElement separatedScorecard;
    
    @FindAll({
	    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(6) > div.dashlet-wrapper.ng-scope > report > image-report > img"),
	    @FindBy(css = "#xpath-dashboard-canvas > div > dashlet:nth-child(11) > div.dashlet-wrapper.ng-scope > report > image-report")
    })
    public WebElement trimbleLogo;
    
    @FindBy(css = "i[class='table-sorting ASC']")
    public WebElement overallScoreasc;
    
    @FindBy(css = "i[class='table-sorting DESC']")
    public WebElement overallScoreDsc;
    
    @FindBy(css = "td[id = org-name]")
    public WebElement defaultOrg;
    
    @FindBy(xpath = "//*[@id=\"global-header\"]/header/ng-include/div/div/ul/li[3]/a/i")
    public WebElement exportIcon;
    
    @FindBy(xpath = "//span[text() = \"PDF\"]")
    public WebElement exportPDF;
    
    @FindBy(xpath = "//span[text() = \"PDF (with Details)\"]")
    public WebElement exportDetailPDF;
    
    @FindBy(xpath = "//*[@id=\"info-dashboardExportInProgress\"]/div/span/span[1]")
    public WebElement exportInprogress;
    
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
	waitForElementPresent(executiveConsolehomePage);
	return executiveConsolehomePage.isDisplayed();
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
     * Click the Overall score column to sort the column in Descending Order
     * 
     * @return
     * @throws Exception
     */
    public void clickOverallScore () throws Exception
    {
	waitForElementPresent(overallScoreasc);
	overallScoreasc.click();
	
    }
    /**
     * Verify Overallscore displayed in Descending Order
     * 
     * @return
     * @throws Exception
     */
    public boolean verifyOverallscoreDsc () throws Exception
    {
	waitForElementPresent(overallScoreDsc);
	return isElementDisplayed(overallScoreDsc);
	
    }
    
    /**
     * Get Text of Default Organization
     * 
     * @throws Exception
     */
    public String getTextdefaultOrg () throws Exception
    {
	waitForElementPresent(defaultOrg);
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
}
