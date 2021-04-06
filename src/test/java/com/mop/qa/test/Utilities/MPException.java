package com.mop.qa.test.Utilities;

public class MPException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;
	  
	  public MPException() {}
	  
	  public MPException(String message) {
	    super(message);
	    this.message = message;
	  }
	  
	  public MPException(Throwable cause) {
	    super(cause);
	  }
	  
	  public String toString() {
	    return this.message;
	  }
	  
	  public String getMessage() {
	    return this.message;
	  }
	}
