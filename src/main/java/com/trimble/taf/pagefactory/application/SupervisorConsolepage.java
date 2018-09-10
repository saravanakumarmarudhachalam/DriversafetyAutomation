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
    
    public void invokeSupervisorconsole () throws Exception
    {
	superVisorconsoleDashboard.click();
	checkPageIsReady();
	
    }
    
}
