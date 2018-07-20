/**
 * 
 */
package com.trimble.birst.tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.trimble.taf.pagefactory.application.DriverSafetyPage;
import com.trimble.taf.pagefactory.application.MyspacesPage;
import com.trimble.taf.pagefactory.global.AbstractPage;
import com.trimble.taf.utils.Constants;
import com.trimble.taf.utils.ProLogger;
import com.trimble.taf.utils.PropertyUtils;

import cucumber.api.java.en.Then;

/**
 * @author psah
 *
 */
public class IndividualScoresteps
{
    public WebDriver driver;
    
    public static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("testconfig.properties");
    
    public MyspacesPage mySpacepage;
    
    public DriverSafetyPage driverSafetypage;
    
    

}
