package com.codetutr.vehicleTrackingSystem.Exception;

public class MyCountryException extends RuntimeException 
{
private static final long serialVersionUID = 1L;

   private ExceptionCode code;
   private ErrorType errorType;
	
	public MyCountryException(String message)
	{
		super(message);
		this.code = ExceptionCode.GENERAL;
	}
	
	public MyCountryException(String message, ExceptionCode code, Throwable cause)
	{
		super(message, cause);
		this.code = code;
	}
	
	public MyCountryException(String message, ExceptionCode code)
	{
		super(message);
		this.code = code;
	}
	
	public MyCountryException(String message, ErrorType errorType)
	{
		super(message);
		this.errorType = errorType;
	}

	
	// just getter here not setter
	
	/**
	 * @return the code
	 */
	
	public ExceptionCode getErrorCode() 
	{
		return code;
	}
	
	
	
	/**
	 * @return the errorType
	 */
	public ErrorType getErrorType() 
	{
		return errorType;
	}

	
	
	@Override
	public String toString() 
	{
		return "MyCountryException [code=" + code + ", errorType=" + errorType + "]";
	}

}
