package edu.sms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="dept")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	@Column(length=20, nullable=false, unique=true)
	private String deptName;
	
	@Column(nullable=false)
	private int totalNoOfStaff;
	
	@Column(nullable=false)
	private int totalNoOfStudents;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Student> students;
	
	@OneToMany
	private List<Staff> staffs;
	
}
