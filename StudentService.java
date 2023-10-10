package edu.sms.service;

import java.util.List;

import edu.sms.dto.StudentDTO;
import edu.sms.entity.Student;
import edu.sms.exceptions.ResourceNotFoundException;

public interface StudentService {

	//method to save student details in database
	StudentDTO saveStudent(Student std);
	
	//method to fetch all student details
	List<StudentDTO> getAllStudents();
	
	//method to fetch student details using id
	StudentDTO getStudentById(int stdId) throws ResourceNotFoundException;
	
	//method to update student details
	StudentDTO updateStudent(int stdId, Student std) throws ResourceNotFoundException;
	
	//method to delete student details
	void deleteStdById(int id);
	
	//method to fetch student details using student name
	List<StudentDTO> getStudentByName(String name);
	
	//method to get student details using email
	StudentDTO getStudentByEmail(String email);
	
	//method get student details belonging to a department and fetching their data
	//using department name
	List<StudentDTO> getStudentsFromDept(String deptName);
	
}
