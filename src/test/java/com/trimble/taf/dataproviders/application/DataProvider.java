/**
 * 
 */
package com.trimble.taf.dataproviders.application;

import com.trimble.taf.dataprovider.AbstractDataProvider;
import com.trimble.taf.utils.PropertyUtils;

/**
 * @author Saravanakumar
 */

public class DataProvider extends AbstractDataProvider
{
    
private static final String CURRENT_DIR = System.getProperty("user.dir");
    
    private static PropertyUtils propertyUtils = PropertyUtils
	    .getInstance("\\src\\test\\resources\\config\\testconfig.properties");
    
    private static final String theExcelResource = CURRENT_DIR + propertyUtils
	    .getProperty("inputData");
    
    @org.testng.annotations.DataProvider
    public static Object[][] getDataForCheckoutNow () throws Exception
    {
	String theSheetName = "Checkoutnow";
	Object[][] testData = getExcelData(theExcelResource, theSheetName);
	return testData;
    }
    
   @org.testng.annotations.DataProvider
    public static Object[][] getDataForContinueShopping () throws Exception
    {
	String theSheetName = "ContinueShopping";
	Object[][] testData = getExcelData(theExcelResource, theSheetName);
	return testData;
    }
}
