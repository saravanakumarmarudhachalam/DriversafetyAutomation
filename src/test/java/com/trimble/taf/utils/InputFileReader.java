/**
 * 
 */
package com.trimble.taf.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * @author Saravanakumar
 */
public class InputFileReader
{
    
    private FileInputStream fis = null;
    
    private Workbook workbook = null;
    
    private Sheet sheet = null;
    
    private Row row = null;
    
    private Cell cell = null;
    
    public InputFileReader(String path) {

		try {
			ProLogger.debug("{}"," Reading the Excel file");
			fis = new FileInputStream(path);
			this.workbook = WorkbookFactory.create(fis);
			fis.close();
		} catch (Exception e) {
			ProLogger.error("{}",e.getMessage());
		}

	}
    
    private static volatile InputFileReader instance = null;
    
    protected static synchronized InputFileReader getInstance (String excelFilePath)
    {
	if (instance == null)
	{
	    synchronized (InputFileReader.class)
	    {
		if (instance == null)
		{
		    instance = new InputFileReader(excelFilePath);
		}
	    }
	}
	return instance;
    }
    
    // returns the row count in a sheet
    public int getRowCount (String sheetName)
    {
	ProLogger.debug("{}", " inside getRowCount() method");
	int index = workbook.getSheetIndex(sheetName);
	if (index == -1)
	    return 0;
	else
	{
	    sheet = workbook.getSheetAt(index);
	    int number = sheet.getLastRowNum() + 1;
	    return number;
	}
	
    }
    
    protected List<String> getColumnData (String sheetName, int colNum)
    {
	ProLogger.debug("{}", " inside getColumnData() method");
	
	List<String> list = null;
	try
	{
	    
	    list = new ArrayList<String>();
	    int index = workbook.getSheetIndex(sheetName);
	    if (index == -1)
		return list;
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(0);
	    
	    for (Row row : sheet)
	    {
		if (row.getRowNum() != 0)
		{
		    cell = row.getCell(colNum);
		    if (cell != null)
		    {
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			    list.add(cell.getStringCellValue());
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
				|| cell.getCellType() == Cell.CELL_TYPE_FORMULA)
			{
			    
			    String cellText = String.valueOf(cell
				    .getNumericCellValue());
			    if (DateUtil.isCellDateFormatted(cell))
			    {
				// format in form of M/D/YY
				double d = cell.getNumericCellValue();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(DateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal
					.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.MONTH) + 1 + "/"
					+ cal.get(Calendar.DAY_OF_MONTH) + "/"
					+ cellText;
			    }
			    
			    list.add(cellText);
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
			    list.add("");
			else
			    list.add(
				    String.valueOf(cell.getBooleanCellValue()));
		    }
		}
	    }
	    return list;
	    
	}
	catch (Exception e)
	{
	    
	    return list;
	}
	
    }
    
    protected List<String> getColumnData (String sheetName, String colName)
    {
	ProLogger.debug("{}", " inside getColumnData() method");
	
	List<String> list = null;
	try
	{
	    
	    list = new ArrayList<String>();
	    int index = workbook.getSheetIndex(sheetName);
	    if (index == -1)
		return list;
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(0);
	    if (row == null)
		return list;
	    
	    int colNum = 0;
	    for (int i = 0; i < row.getLastCellNum(); i++)
	    {
		// System.out.println(row.getCell(i).getStringCellValue().trim());
		if (row.getCell(i).getStringCellValue().trim()
			.equals(colName.trim()))
		{
		    colNum = i;
		}
		
	    }
	    
	    if (colNum == -1)
		return list;
	    for (Row row : sheet)
	    {
		
		if (row.getRowNum() != 0)
		{
		    cell = row.getCell(colNum);
		    if (cell != null)
		    {
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			    list.add(cell.getStringCellValue());
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
				|| cell.getCellType() == Cell.CELL_TYPE_FORMULA)
			{
			    
			    String cellText = String.valueOf(cell
				    .getNumericCellValue());
			    if (DateUtil.isCellDateFormatted(cell))
			    {
				// format in form of M/D/YY
				double d = cell.getNumericCellValue();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(DateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal
					.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.MONTH) + 1 + "/"
					+ cal.get(Calendar.DAY_OF_MONTH) + "/"
					+ cellText;
			    }
			    
			    list.add(cellText);
			}
			else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
			    list.add("");
			else
			    list.add(
				    String.valueOf(cell.getBooleanCellValue()));
		    }
		}
	    }
	    return list;
	    
	}
	catch (Exception e)
	{
	    
	    return list;
	}
	
    }
    
    // returns the data from a cell
    protected String getCellData (String sheetName, String colName, int rowNum)
    {
	ProLogger.debug("{}", " inside getCellData() method");
	try
	{
	    if (rowNum <= 0)
		return "";
	    
	    int index = workbook.getSheetIndex(sheetName);
	    int col_Num = -1;
	    if (index == -1)
		return "";
	    
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(0);
	    for (int i = 0; i < row.getLastCellNum(); i++)
	    {
		// System.out.println(row.getCell(i).getStringCellValue().trim());
		if (row.getCell(i).getStringCellValue().trim()
			.equals(colName.trim()))
		    col_Num = i;
	    }
	    if (col_Num == -1)
		return "";
	    
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(rowNum - 1);
	    if (row == null)
		return "";
	    cell = row.getCell(col_Num);
	    
	    if (cell == null)
		return "";
	    // System.out.println(cell.getCellType());
	    if (cell.getCellType() == Cell.CELL_TYPE_STRING)
		return cell.getStringCellValue();
	    else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
		    || cell.getCellType() == Cell.CELL_TYPE_FORMULA)
	    {
		
		String cellText = String.valueOf(cell.getNumericCellValue());
		if (DateUtil.isCellDateFormatted(cell))
		{
		    // format in form of M/D/YY
		    double d = cell.getNumericCellValue();
		    
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(DateUtil.getJavaDate(d));
		    cellText = (String.valueOf(cal.get(Calendar.YEAR)))
			    .substring(2);
		    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/"
			    + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
		    
		    // System.out.println(cellText);
		    
		}
		
		return cellText;
	    }
	    else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		return "";
	    else
		return String.valueOf(cell.getBooleanCellValue());
	    
	}
	catch (Exception e)
	{
	    
	    return "row " + rowNum + " or column " + colName
		    + " does not exist in file";
	}
    }
    
    // returns the data from a cell
    public String getCellData (String sheetName, int colNum, int rowNum)
    {
	ProLogger.debug("{}", " inside getCellData() method");
	try
	{
	    if (rowNum <= 0)
		return "";
	    
	    int index = workbook.getSheetIndex(sheetName);
	    
	    if (index == -1)
		return "";
	    
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(rowNum - 1);
	    if (row == null)
		return "";
	    cell = row.getCell(colNum);
	    if (cell == null)
		return "";
	    
	    if (cell.getCellType() == Cell.CELL_TYPE_STRING)
		return cell.getStringCellValue();
	    else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
		    || cell.getCellType() == Cell.CELL_TYPE_FORMULA)
	    {
		
		String cellText = String.valueOf(cell.getNumericCellValue());
		if (DateUtil.isCellDateFormatted(cell))
		{
		    // format in form of M/D/YY
		    double d = cell.getNumericCellValue();
		    
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(DateUtil.getJavaDate(d));
		    cellText = (String.valueOf(cal.get(Calendar.YEAR)))
			    .substring(2);
		    cellText = cal.get(Calendar.MONTH) + 1 + "/"
			    + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
		    
		    // System.out.println(cellText);
		    
		}
		
		return cellText;
	    }
	    else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
		return "";
	    else
		return String.valueOf(cell.getBooleanCellValue());
	}
	catch (Exception e)
	{
	    
	    return "row " + rowNum + " or column " + colNum
		    + " does not exist  in file";
	}
    }
    
    // find whether sheets exists
    protected boolean isSheetExist (String sheetName)
    {
	ProLogger.debug("{}", " inside isSheetExist() method");
	int index = workbook.getSheetIndex(sheetName);
	if (index == -1)
	{
	    index = workbook.getSheetIndex(sheetName.toUpperCase());
	    if (index == -1)
		return false;
	    else
		return true;
	}
	else
	    return true;
    }
    
    // returns number of columns in a sheet
    public int getColumnCount (String sheetName)
    {
	// Utils.logger.info(" inside getColumnCount() method");
	if (!isSheetExist(sheetName))
	    return -1;
	
	sheet = workbook.getSheet(sheetName);
	row = sheet.getRow(0);
	
	if (row == null)
	    return -1;
	
	return row.getLastCellNum();
	
    }
    
    protected int getCellRowNum (String sheetName, String colName,
	    String cellValue)
    {
	// Utils.logger.info(" inside getCellRowNum() method");
	
	for (int i = 2; i <= getRowCount(sheetName); i++)
	{
	    if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue))
	    {
		return i;
	    }
	}
	return -1;
	
    }
    
    // returns the data from a cell
    protected HashMap<String, String> getRowData (String sheetName, int rowNum)
    {
	
	// Utils.logger.info(" inside getRowData() method");
	HashMap<String, String> hashMap = null;
	try
	{
	    
	    hashMap = new HashMap<String, String>();
	    
	    if (rowNum <= 0)
		return hashMap;
	    
	    int index = workbook.getSheetIndex(sheetName);
	    
	    if (index == -1)
		return hashMap;
	    
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(rowNum - 1);
	    Row headerRow = sheet.getRow(0);
	    
	    if (headerRow == null || row == null)
		return hashMap;
	    
	    for (int i = 0; i < headerRow.getLastCellNum(); i++)
	    {
		
		hashMap.put(this.getCellValue(headerRow.getCell(i)),
			this.getCellValue(row.getCell(i)));
	    }
	    
	    return hashMap;
	    
	}
	catch (Exception e)
	{
	    
	    if (e.getMessage() != null && e.getMessage().isEmpty())
	    {
		ProLogger.error("{}", e.getMessage());
	    }
	    else
	    {
		ProLogger.error("{}", "row " + rowNum + " does not exist  in file");
	    }
	    return hashMap;
	}
    }
    
    private String getCellValue (Cell cell)
    {
	
	if (cell == null)
	    return "";
	// System.out.println(cell.getCellType());
	if (cell.getCellType() == Cell.CELL_TYPE_STRING)
	    return cell.getStringCellValue();
	else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
		|| cell.getCellType() == Cell.CELL_TYPE_FORMULA)
	{
	    
	    String cellText = String.valueOf(cell.getNumericCellValue());
	    if (DateUtil.isCellDateFormatted(cell))
	    {
		// format in form of M/D/YY
		double d = cell.getNumericCellValue();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.getJavaDate(d));
		cellText = (String.valueOf(cal.get(Calendar.YEAR)))
			.substring(2);
		cellText = cal.get(Calendar.DAY_OF_MONTH) + "/"
			+ cal.get(Calendar.MONTH) + 1 + "/" + cellText;
		
		// System.out.println(cellText);
		
	    }
	    
	    return cellText;
	}
	else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
	    return "";
	else
	    return String.valueOf(cell.getBooleanCellValue());
	
    }
}
