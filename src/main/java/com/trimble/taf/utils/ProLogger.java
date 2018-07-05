/**
 * 
 */
package com.trimble.taf.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * @author smarudh
 */
public class ProLogger
{
    
    
    private static Logger logger = null;
    
    private static Logger getLogger ()
    {
	if (logger == null)
	{
	    LoggerContext context = (LoggerContext) LoggerFactory
		    .getILoggerFactory();
	    File file = new File(System.getProperty("user.dir")
		    + "/src/main/resources/logback.xml");
	    try
	    {
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(context);
		context.reset();
		configurator.doConfigure(file);
		logger = context.getLogger("com.framework");
	    }
	    catch (JoranException je)
	    {
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);
	    }
	    catch (Exception e)
	    {
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);
	    }
	}
	return logger;
    }
    
    /**
     * Log errors to the log file
     * 
     * @param tag
     * @param args
     *            - Array of objects that need to be logged
     */
    public static void error (String tag, Object[] args)
    {
	getLogger().error(tag, args);
    }
    
    /**
     * Log errors to the log file
     * 
     * @param tag
     * @param args
     *            - additional log messages
     */
    public static void error (String tag, String args)
    {
	getLogger().error(tag, args);
    }
    
    /**
     * Log Warning messages to the log file
     * 
     * @param tag
     * @param args
     *            - Array of objects that need to be logged
     */
    public static void warning (String tag, Object[] args)
    {
	getLogger().warn(tag, args);
    }
    
    /**
     * Log Warning messages to the log file
     * 
     * @param tag
     * @param args
     *            - additional log messages
     */
    public static void warning (String tag, String args)
    {
	getLogger().warn(tag + " {}", args);
    }
    
    /**
     * Log Debug messages to the log file
     * 
     * @param tag
     * @param args
     *            - Array of objects that need to be logged
     */
    public static void debug (String tag, Object[] args)
    {
	getLogger().debug(tag, args);
    }
    
    /**
     * Log Debug messages to the log file
     * 
     * @param tag
     * @param args
     *            - additional log messages
     */
    public static void debug (String tag, String args)
    {
	getLogger().debug(tag + " {}", args);
    }
    
    /**
     * Log Assertion messages to the log file
     * 
     * @param tag
     * @param args
     *            - Array of objects that need to be logged
     */
    public static void assertion (String tag, Object[] args)
    {
	getLogger().trace(tag, args);
    }
    
    /**
     * Log Assertion messages to the log file
     * 
     * @param tag
     * @param args
     *            - additional log messages
     */
    public static void assertion (String tag, String args)
    {
	getLogger().trace(tag + " {}", args);
    }
    
    /**
     * Log Info messages to the log file
     * 
     * @param tag
     * @param args
     *            - additional log messages
     */
    public static void info (String tag, String arg)
    {
	getLogger().info(tag + " {}", arg);
    }
    
    /**
     * Log Info messages to the log file
     * 
     * @param tag
     * @param args
     *            - Array of objects that need to be logged
     */
    public static void info (String tag, Object[] args)
    {
	getLogger().info(tag, args);
    }
    
    /**
     * Log info Message to the Log file
     * 
     * @param tag
     */
    public static void info (String tag)
    {
	getLogger().info(tag);
    }
}
