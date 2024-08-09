package com.cm.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuarantorDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int guarantorId;
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private int age;
	private long contactNo;
	private String aadharCardNo;
	private String panCardNo;
	private String address;
	private String emailId;
	private String relationshipToCustomer;
}
