package edu.sms.dto;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

import edu.sms.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDTO extends UserDTO{

	private String designation;
	
	
	private LocalDate joiningDate;
	
	
	private double salary;
	
	
	private String qualification;
	
	@ManyToOne
	private Department department;
}
