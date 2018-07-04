/**
 * 
 */
package com.trimble.taf.listeners;

import java.util.Map;

import org.testng.collections.Maps;

import com.trimble.taf.testng.SystemInfo;


/**
 * @author smarudh
 */
public class MySystemInfo implements SystemInfo
{
    
    @Override
    public Map<String, String> getSystemInfo ()
    {
	Map<String, String> systemInfo = Maps.newHashMap();
	systemInfo.put("Test Env", "QA");
	systemInfo.put("Browser", "firefox");
	return systemInfo;
    }
}
