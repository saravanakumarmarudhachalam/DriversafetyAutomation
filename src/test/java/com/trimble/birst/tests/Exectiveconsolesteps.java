/**
 * 
 */
package com.trimble.birst.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.LoginPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author smarudh
 */
public class Exectiveconsolesteps
{
    
    
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    /**
     * Constructor
     */
    public Exectiveconsolesteps()
    {
	driver = ServiceHooks.driver;
	mySpacepage = new MyspacesPage(driver);
	driverSafetypage = new DriverSafetyPage(driver);
	// TODO Auto-generated constructor stub
    }
    
    @Then("^I verified overall score is displayed in ascending order$")
    public void verifyAscendingoverallScore () throws Throwable
    {
	Assert.assertTrue(driverSafetypage.verifyOverallscoreAsc(),
		Constants.OVERALLSCORE_ASCENDINGORDER_DISPLAYED);
	Reporter.log(Constants.OVERALLSCORE_ASCENDINGORDER_DISPLAYED);
    }
    
    @Then("^I clicked the Overall Score column to sort it in descending order$")
    public void clickOverallscoreColumn() throws Throwable
    {
	driverSafetypage.clickOverallScore();
    }
    
    @Then ("^I verified overall score is displayed in descending order$")
    public void verifyDescendingoverallScore () throws Throwable
    {
	Assert.assertTrue(driverSafetypage.verifyOverallscoreDsc(), Constants.OVERALLSCORE_DESCENDINGORDER_DISPLAYED);
	Reporter.log(Constants.OVERALLSCORE_DESCENDINGORDER_DISPLAYED);
    }
    
    @Then("^I verified Allen Myers text and overall score is displayed correctly$")
    public void verifyAllenmyerOverallscore() throws Throwable
    {
	Assert.assertEquals(driverSafetypage.getTextdefaultOrg(), Constants.DEFAULT_ORGANIZATION,Constants.DEFAULT_ORGANIZATION_DISPLAYED);
	Reporter.log(Constants.DEFAULT_ORGANIZATION_DISPLAYED);
    }
    
    @When("^I clicked Exporticon$")
    public void clickExporticon() throws Throwable
    {
	driverSafetypage.clickExporticon();
    }
    
    @And("^I clicked ExportPDF$")
    public void clickPDf () throws Throwable
    {
	driverSafetypage.clickExportPDF();
    }
    
    @Then("^I verified file has been exported correctly$")
    public void verifyExportpdfProgress() throws Throwable
    {
	Assert.assertEquals(driverSafetypage.getTextexportInprogress(), Constants.EXPORT_IN_PROGRESS,Constants.PDF_EXPORTED_CORRECTLY);
	Reporter.log(Constants.PDF_EXPORTED_CORRECTLY);
    }
    
    @And("^I clicked ExportPDFdetails$")
    public void clickPDfdetails () throws Throwable
    {
	driverSafetypage.clickExportdetailPDF();
    }
    
    @Then("^I validated PDF has been exported corretly$")
    public void verifyExportpdfDownloadloc() throws Throwable
    {
	Assert.assertTrue(driverSafetypage.isFileDownloaded(propertyUtils.getProperty("downloadPath"),
		"Executive Console.pdf"), Constants.FILE_DOWNLOAD);
	Reporter.log(Constants.FILE_DOWNLOAD);
    }
}
