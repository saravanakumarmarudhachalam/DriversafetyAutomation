/**
 * 
 */
package com.trimble.taf.testng;

import java.util.Map;

/**
 * @author smarudh
 */
public interface SystemInfo
{
    
    
    /**
     * Add a map of system information and return as a map
     * 
     * @return The map of system information
     */
    Map<String, String> getSystemInfo ();
}
