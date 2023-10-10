package edu.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sms.dto.DepartmentDTO;
import edu.sms.entity.Department;
import edu.sms.service.DepartmentService;
import edu.sms.util.DepartmentConverter;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@PostMapping("/saveDept")
	public DepartmentDTO saveDepartment(@Valid @RequestBody DepartmentDTO deptDto)
	{
		Department dept = deptConverter.convertDeptDtoToEntity(deptDto);
		return deptService.saveDept(dept);
	}
	
	@PostMapping("/assignStd/{stdId}/toDept/{deptId}")
	public ResponseEntity<String> assignStdToDept(@PathVariable("stdId") int stdId, 
			@PathVariable("deptId") int deptId)
	{
		deptService.assignStdToDept(stdId, deptId);
		return new ResponseEntity<String>("Student with id "+stdId+" assigned "
				+ "to department with id "+deptId, HttpStatus.OK);
	}
	
}
