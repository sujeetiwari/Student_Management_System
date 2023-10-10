package edu.sms.dto;


import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.sms.entity.Address;
import edu.sms.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private int id;
	
	@NotNull(message="Name is required")
	@Size(max=30, message="Max. 30 characters allowed")
	@Size(min=2, message="Min. 2 characters required")
	@NotBlank(message="Enter valid name")
	private String name; //  
	
	
	private String userName;
	
	
	private String password;
	
	@NotNull(message="Email is required")
	@Size(max=30, message="Max. 30 characters allowed")
	@Email(message="Invalid email")
	private String email;
	
	@OneToOne   //one user can have one address
	private Address address;
	
	@OneToOne  //one user can have only one role
	private Role role;
}
