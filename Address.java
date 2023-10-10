package edu.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Builder
public class Address {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int aId;
	
	@Column(length=50, nullable=false)
	private String location;
	
	@Column(length=6, nullable=false)
	private String pincode;
	
	@Column(length=15, nullable=false)
	private String state;
	
}
