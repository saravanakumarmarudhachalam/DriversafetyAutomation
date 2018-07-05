package com.trimble.taf.pagefactory.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trimble.taf.pagefactory.global.AbstractPage;

/**
 * @author Saravanakumar
 */
public class LoginPage extends AbstractPage
{
    
    
    @CacheLookup
    @FindBy(id = "LoginForm2_UserName")
    private WebElement userNametxtBox;
    
    @CacheLookup
    @FindBy(id = "LoginForm2_Password")
    private WebElement passwordTxtbox;
    
    @CacheLookup
    @FindBy(id = "LoginForm2_LoginButton")
    private WebElement loginButton;
    
    public LoginPage(WebDriver driver)
    {
	super(driver);
	PageFactory.initElements(driver, this);
    }
    
    public void waitForPageToLoad (WebDriver driver)
    {
	waitForPageLoad(driver);
    }
    
    /**
     * Method to get Page Title
     * 
     * @return
     * @throws Exception
     */
    public String getTitle ()
    {
	return getPageTitle(driver);
    }
    
    /**
     * Method to enter Username
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public void enterUsername (String userName) throws Exception
    {
	waitForElementPresent(userNametxtBox);
	userNametxtBox.sendKeys(userName);
    }
    
    /**
     * Method to enter password
     * 
     * @param password
     * @throws Exception
     */
    public void enterPassword (String password) throws Exception
    {
	waitForElementPresent(passwordTxtbox);
	passwordTxtbox.sendKeys(password);
    }
    
    /**
     * Method to Click Login button
     * 
     * @throws Exception
     */
    public void clickLogin () throws Exception
    {
	waitForElementPresent(loginButton);
	loginButton.click();
	checkPageIsReady();
    }
    
}
