package edu.sms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.sms.entity.Student;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	//custom method to fetch student details using student name
	@Query("from Student where name=:x")
	List<Student> getStudentByName(@Param("x") String name);
	
	
	//custom method to fetch student details using student email
	Optional<Student> findByEmail(String email);
	
	@Query("from Student where department=(from Department where deptName=:e)")
	List<Student> getStudentsUsingDeptName(@Param("e") String deptName);
	
	//custom method to find student details using email and contact
	Student findByEmailOrContact(String email, String contact);
}
