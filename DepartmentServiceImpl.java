package edu.sms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sms.dto.DepartmentDTO;
import edu.sms.entity.Department;
import edu.sms.entity.Student;
import edu.sms.exceptions.ResourceNotFoundException;
import edu.sms.repository.DepartmentRepository;
import edu.sms.repository.StudentRepository;
import edu.sms.service.DepartmentService;
import edu.sms.util.DepartmentConverter;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;
	
	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@Override
	public DepartmentDTO saveDept(Department dept) {
		
		deptRepository.save(dept);
		
		return deptConverter.convertDeptEntityToDto(dept);
	}

	@Override
	public void assignStdToDept(int stdId, int deptId) {
		
		Student std = stdRepository.findById(stdId).orElseThrow(()->
		new ResourceNotFoundException("Student", "id", stdId));
		
		Department dept = deptRepository.findById(deptId).orElseThrow(()->
		new ResourceNotFoundException("Department", "id", deptId));
		
		std.setDepartment(dept);
		
//		List<Student> list = dept.getStudents();
//		list.add(std);
//		dept.setStudents(list);
		
		dept.setTotalNoOfStudents(dept.getTotalNoOfStudents()+1);
		
		
		stdRepository.save(std);
		
		deptRepository.save(dept);
		
	}

}
