/**
 * 
 */
package com.trimble.taf.dataprovider;

import com.trimble.taf.utils.InputFileReader;

/**
 * @author Saravanakumar
 */
public abstract class AbstractDataProvider
{
    
    
    protected static InputFileReader readerDAO = new InputFileReader(
	    "\\src\\test\\resources\\testdata\\excel\\Checkout.xls");
    
    protected static final String theWorkingDir = System
	    .getProperty("user.dir");
    
    public static String[][] getExcelData (String anExcelResource,
	    String aSheetName)
    {
	int rowCount = 0, colCount = 0;
	rowCount = readerDAO.getRowCount(aSheetName);
	colCount = readerDAO.getColumnCount(aSheetName);
	String[][] listData = new String[rowCount - 1][colCount];
	for (int i = 0; i < rowCount - 1; i++)
	{
	    for (int j = 0; j < colCount; j++)
	    {
		listData[i][j] = readerDAO.getCellData(aSheetName, j, i + 2);
	    }
	}
	return listData;
    }
}
