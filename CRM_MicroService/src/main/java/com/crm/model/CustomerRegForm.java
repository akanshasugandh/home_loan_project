package com.crm.model;

import java.util.Date;

import jakarta.persistence.Entity;
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
public class CustomerRegForm {
	
	@Id
	private int CustomerRegId;
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	private String gender;
	private long contactNumber;
	private String emailId;
	private String maritalStatus;
	private String aadharCardNumber;
	private String pancardNumber;
	private String permanentAddress;
	private String currentAddress;
	private String occupation;
	private int cibilScore;
	private String cibilStatus;
	private String loanStatus;
}
