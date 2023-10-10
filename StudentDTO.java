package edu.sms.dto;

import java.time.LocalDate;


import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import edu.sms.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends UserDTO{

	@NotNull(message="DOJ is required")
	private LocalDate dateOfJoining; //yyyy-mm-dd
	
	@NotNull(message="DOB is required")
	private LocalDate dateOfBirth;
	
	@NotNull(message="Contact is required")
	@Size(min=10, max=10, message="10 characters required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message="Invalid contact details")
	private String contact;
	
	@NotNull(message="Gender is required")
	@Size(min=4, message="Min. 4 characters required")
	@Size(max=10, message="Max. 10 characters allowed")
	private String gender;
	
	@ManyToOne
	private Department department;
}
