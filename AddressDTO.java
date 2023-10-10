package edu.sms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

	private int aId;
	
	private String location;
	
	@NotNull(message="Pincode is required")
	@Size(min=6, max=6, message="6 characters required")
	@Pattern(regexp = "[0-9]{6}", message = "Invalid pin code")
	private String pincode;
	
	private String state;
}
