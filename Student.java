package edu.sms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student extends User{

	@Column(nullable=false)
	private LocalDate dateOfJoining; //yyyy-mm-dd
	
	@Column(nullable=false)
	private LocalDate dateOfBirth;
	
	@Column(length=10, nullable=false, unique=true)
	private String contact;
	
	@Column(length= 10, nullable=false)
	private String gender;
	
	@ManyToOne
	private Department department;

	@Builder
	public Student(int id, String name, String userName, String password, String email, Address address, Role role,
			LocalDate dateOfJoining, LocalDate dateOfBirth, String contact, String gender, Department department) {
		super(id, name, userName, password, email, address, role);
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.gender = gender;
		this.department = department;
	}
	
	
	
	
}
