package edu.sms.dto;

import java.util.List;


import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.sms.entity.Staff;
import edu.sms.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {

	private int deptId;
	
	@NotNull(message="Dept. name is required")
	@Size(max=20, message="Max. 20 characters allowed")
	@Size(min=3, message="Min. 2 characters required")
	@NotBlank(message="Please enter valid department name")
	private String deptName;
	
	@NotNull(message="Total no. of staff is required")
	private int totalNoOfStaff;
	
	@NotNull(message="Total no. of students is required")
	private int totalNoOfStudents;
	
	@OneToMany
	private List<Student> students;
	
	@OneToMany
	private List<Staff> staffs;
}
