package edu.sms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
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
public class Staff extends User{

	@Column(length=20, nullable=false)
	private String designation;
	
	@Column(nullable=false)
	private LocalDate joiningDate;
	
	@Column(nullable=false)
	private double salary;
	
	@Column(length=20, nullable=false)
	private String qualification;
	
	@ManyToOne
	private Department department;
	
}
