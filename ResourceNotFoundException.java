package edu.sms.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String resourceName; //Student, Department, Staff
	private String fieldName; //id, name, email
	private Object fieldObject; //99, shawin, shawin@gmail.com
	
	//Student not found with id: '99'
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldObject) {
		super(String.format("%s not found with %s: '%s'",resourceName,fieldName,fieldObject));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldObject = fieldObject;
	}
	
	

}
