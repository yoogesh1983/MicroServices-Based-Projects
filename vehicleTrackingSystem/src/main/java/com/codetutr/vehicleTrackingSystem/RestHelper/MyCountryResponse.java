package com.codetutr.vehicleTrackingSystem.RestHelper;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.codetutr.vehicleTrackingSystem.Exception.ErrorType;
import com.codetutr.vehicleTrackingSystem.Utility.ShortString;


public class MyCountryResponse<T> implements ShortString
{
	private String transactionId;
	private String hostName;
	private T data;
	private ArrayList<ErrorType> errors;
	
	public MyCountryResponse() { }

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ArrayList<ErrorType> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<ErrorType> errors) {
		this.errors = errors;
	}
	

	@Override
	public String toString() 
	{
		return ReflectionToStringBuilder.toString(this);
		
	}
	
	

	@Override
	public String toShortString() {
		
		String shortString  = null;
		
		if(data ==null)
		{
			shortString = toString();
		}
		
		else
		{
			ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this);
			builder = builder.setExcludeFieldNames("data");
			
			if( data instanceof ShortString)
			{
				// call the toShortString() method for the data object
				shortString = StringUtils.chop(builder.toString()) + ",data=" + ((ShortString)data).toShortString() + "]";
			}
			
			else
			{
				// only use the data object className and hashCode
				shortString = StringUtils.chop(builder.toString()) + ",data=" + data.getClass().getName() + "@" + data.hashCode() + "]";
		    }
		}
		
		return shortString;
	}
	

}
