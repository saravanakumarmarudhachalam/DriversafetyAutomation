/**
 * 
 */
package com.trimble.taf.pagefactory.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.ChangedCharSetException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class SuperVisorConsole extends AbstractPage
{
    /**
     * @param driver
     */
    public SuperVisorConsole(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//span[text() = \"Supervisor Console\"]")
    public WebElement superVisorconsoleDashboard;
    
    public void invokeSupervisorconsole() throws Exception
    {
	superVisorconsoleDashboard.click();
	checkPageIsReady();
	
    }
    
    
    
    
    
}