package edu.sms.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import edu.sms.dto.StudentDTO;
import edu.sms.entity.Address;
import edu.sms.entity.Role;
import edu.sms.entity.Student;
import edu.sms.exceptions.ResourceNotFoundException;
import edu.sms.repository.AddressRepository;
import edu.sms.repository.RoleRepository;
import edu.sms.repository.StudentRepository;
import edu.sms.service.StudentService;
import edu.sms.util.StudentConverter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	//logger created
	private static final Logger log = LoggerFactory.getLogger(Student.class);
	
	@Autowired
	StudentRepository stdRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AddressRepository addRepository;

	@Autowired
	StudentConverter stdConverter;

	@Override
	public StudentDTO saveStudent(Student std) throws ResourceNotFoundException,
	DataIntegrityViolationException{

		Student existStd = stdRepository.findByEmailOrContact(std.getEmail(), std.getContact());
		
		if(existStd!=null)
		{
			throw new DataIntegrityViolationException("Please check the email and contact details.");
		}
		
		
		String pass = std.getName().substring(0, 3).toLowerCase();
		std.setPassword(pass + "123");

		String user = std.getEmail().substring(0, std.getEmail().indexOf('@'));
		std.setUserName(user);

		Role role = roleRepository.findById(2).orElseThrow(() -> 
		new ResourceNotFoundException("Role", "Id", 2));
		std.setRole(role);

		// saving address details
		addRepository.save(std.getAddress());

		stdRepository.save(std); // saving the student details in the database

		log.info("New student details "+std.toString()+" saved at "+new Date());
		
		return stdConverter.convertStdEntityToDto(std);
	}

	@Override
	public List<StudentDTO> getAllStudents() {

		List<Student> students = stdRepository.findAll();

		List<StudentDTO> sDtos = new ArrayList<>();

		for (Student s : students) {
			StudentDTO sdto = stdConverter.convertStdEntityToDto(s);
			sDtos.add(sdto);
		}
		
		log.info("All students details fetched at "+new Date());

		return sDtos;
	}

	@Override
	public StudentDTO getStudentById(int stdId) throws ResourceNotFoundException {

//		Optional<Student> opStd = stdRepository.findById(stdId);
//		Student std = opStd.get();

		Student std = stdRepository.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", stdId));

		log.info("Student with id "+stdId+" information was retrieved at "+new Date());
		return stdConverter.convertStdEntityToDto(std);
	}

	@Override
	public StudentDTO updateStudent(int stdId, Student std) 
			throws ResourceNotFoundException {

		// fetch the existing student details
		Student existStd = stdRepository.findById(stdId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Student", "id", stdId));
	
			int addId = existStd.getAddress().getAId();

			Address add = addRepository.findById(addId)
					.orElseThrow(() -> 
				new ResourceNotFoundException("Address", "Id", addId));

			// updating existing details with new details
			add.setLocation(std.getAddress().getLocation());
			add.setState(std.getAddress().getState());
			add.setPincode(std.getAddress().getPincode());

			addRepository.save(add);

			existStd.setAddress(add);

		existStd.setContact(std.getContact());
		existStd.setDateOfBirth(std.getDateOfBirth());
		existStd.setDateOfJoining(std.getDateOfJoining());
		existStd.setEmail(std.getEmail());
		existStd.setGender(std.getGender());
		existStd.setName(std.getName());

		existStd.setPassword(std.getPassword());

		// save the new details
		stdRepository.save(existStd);

		return stdConverter.convertStdEntityToDto(existStd);
	}

	@Override
	public void deleteStdById(int id) {

		Student std = stdRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Student", "id", id));

		
		Address add = std.getAddress();
		
		if(add!=null)
		{
		std.setAddress(null);
		
		addRepository.delete(add);
		}
		else
		{
			log.error("Address details not found!");
		}
		// stdRepository.delete(std);
		stdRepository.deleteById(id);

	}

	@Override
	public List<StudentDTO> getStudentByName(String name) {
		
		List<Student> students = stdRepository.getStudentByName(name);
		
		List<StudentDTO> sDtos = new ArrayList<>();

		for (Student s : students) {
			StudentDTO sdto = stdConverter.convertStdEntityToDto(s);
			sDtos.add(sdto);
		}

		return sDtos;
	}

	@Override
	public StudentDTO getStudentByEmail(String email) throws ResourceNotFoundException{
		
		Student std = stdRepository.findByEmail(email).orElseThrow(()->
		new ResourceNotFoundException("Student", "email", email));
		
		return stdConverter.convertStdEntityToDto(std);
	}

	@Override
	public List<StudentDTO> getStudentsFromDept(String deptName) {
		
		List<Student> students = stdRepository.getStudentsUsingDeptName(deptName);
		
		List<StudentDTO> sDtos = new ArrayList<>();

		for (Student s : students) {
			StudentDTO sdto = stdConverter.convertStdEntityToDto(s);
			sDtos.add(sdto);
		}

		return sDtos;
	}

}
