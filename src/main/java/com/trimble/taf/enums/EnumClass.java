package com.trimble.taf.enums;

/**
 * @author Saravanakumar
 */

public class EnumClass
{
    
    public enum Browsers
    {
	FIREFOX, CHROME, INTERNETEXPLORER, SAFARI
    }
    
    public enum RunModes
    {
	LOCAL, GRID, MULTIBROWSER, GRIDMULTIBROWSER,
    }
    
    public enum Status
    {
	NotStarted, InProgress, Completed
    }
    
    public enum StepResults
    {
	PASS, FAIL, WARNING
    }
    
    public enum Priorities
    {
	P1, P2, P3
    }
    
    public enum OverAllResults
    {
	NA("0"), PASS("1"), FAIL("2"), WARNING("3");
	
	private String value;
	
	/**
	 * @param val
	 */
	private OverAllResults(String val)
	{
	    this.value = val;
	}
	
	/**
	 * @return value of OverAllResult
	 */
	public String getValue ()
	{
	    return value;
	}
    }
}
