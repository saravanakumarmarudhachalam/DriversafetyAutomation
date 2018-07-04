package com.trimble.taf.exception;

/**
 * Thrown incase of page refresh failures and element refresh errors.
 * @author smarudh
 *
 */
public class PageRefreshException extends FrameworkException {

    //just for removing warning, the exceptions are not be expected to be java serialized
    private static final long serialVersionUID = -1L;
    
    /**
     * @param message
     */
    public PageRefreshException(Class<?> pageClass,String fieldName) {
        super("Error while refreshing the field " + fieldName + " in page " + pageClass.getName());
    }

}
