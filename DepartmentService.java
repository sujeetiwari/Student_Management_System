package edu.sms.service;

import edu.sms.dto.DepartmentDTO;
import edu.sms.entity.Department;

public interface DepartmentService {

	//method to save department details
	DepartmentDTO saveDept(Department dept);
	
	//method to assign student to a department
	void assignStdToDept(int stdId, int deptId);
}
