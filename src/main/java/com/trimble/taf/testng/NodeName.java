/**
 * 
 */
package com.trimble.taf.testng;

/**
 * @author smarudh
 */
public class NodeName
{
    
    private static final ThreadLocal<String> nodeName = new ThreadLocal<>();
    
    public static String getNodeName ()
    {
	return nodeName.get();
    }
    
    public static void setNodeName (String name)
    {
	nodeName.set(name);
    }
    
}
