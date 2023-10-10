package edu.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sms.dto.StudentDTO;
import edu.sms.entity.Student;
import edu.sms.service.StudentService;
import edu.sms.util.StudentConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class StudentController {

	@Autowired
	StudentService stdService;
	
	@Autowired
	StudentConverter stdConverter;
	
	@PostMapping("/saveStudent")
	public StudentDTO createStudent(@Valid @RequestBody StudentDTO stDto)
	{
		final Student std = stdConverter.convertStdDtoToEntity(stDto);
		return stdService.saveStudent(std);
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentDTO> getAllStudents()
	{
		return stdService.getAllStudents();
	}
	
	@GetMapping("/getStudentById/{id}")
	public StudentDTO getStdById(@PathVariable("id") int stdId)
	{
		return stdService.getStudentById(stdId);
	}
	
	@PutMapping("/updateStudent/{stdId}")
	public StudentDTO updateStudent(@PathVariable("stdId") int stdId,
			@RequestBody @Valid StudentDTO stdDto)
	{
		final Student std = stdConverter.convertStdDtoToEntity(stdDto);
		return stdService.updateStudent(stdId, std);
	}
	
	@DeleteMapping("/deleteStdById/{id}")
	public ResponseEntity<String> deleteStdById(
			@PathVariable("id") int id)
	{
		stdService.deleteStdById(id);
		return new ResponseEntity<String>("Student with id "
		+id+" deleted successfully!", HttpStatus.OK);
	}
	
	
	@GetMapping("/getStudentByName/{name}")
	public List<StudentDTO> getStdByName(@PathVariable("name") String stdName)
	{
		return stdService.getStudentByName(stdName);
	}
	
	
	@GetMapping("/getStudentByEmail/{email}")
	public StudentDTO getStdByEmail(@PathVariable("email") String stdEmail)
	{
		return stdService.getStudentByEmail(stdEmail);
	}
	
	@GetMapping("/getStudentFromDept/{name}")
	public List<StudentDTO> getStdFromDept(@PathVariable("name") String deptName)
	{
		return stdService.getStudentsFromDept(deptName);
	}
	
}
