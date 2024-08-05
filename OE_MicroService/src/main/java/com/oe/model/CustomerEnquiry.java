package com.oe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEnquiry {

	@Id
	private int customerEnquiryId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private long contactNumber;
	private String emailId;
	private String aadharCardNumber;
	private String pancardNumber;
	private String address;
	private int cibilScore;
	private String cibilStatus;
	private String loanStatus;

}
