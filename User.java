package edu.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

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
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=30, nullable=false)
	private String name;
	
	@Column(length=30, nullable=false, unique = true)
	private String userName;
	
	@Column(length=30, nullable=false)
	private String password;
	
	@Column(length=30, nullable=false, unique=true)
	private String email;
	
	@OneToOne   //one user can have one address
	private Address address;
	
	@OneToOne  //one user can have only one role
	private Role role;
}
