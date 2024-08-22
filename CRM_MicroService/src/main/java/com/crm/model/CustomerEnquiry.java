package com.crm.model;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	
	@NotBlank(message = "Customer First Name cannot be blank.")
	@NotNull(message = "Customer First Name cannot be null.")
	private String firstName;
	
	@NotBlank(message = "Customer Last Name cannot be blank.")
	private String lastName;
	
	@Max(value=65, message = "Customer Age cannot be greater than 65 years.")
	@Min(value=21, message = "Customer Age cannot be less than 21 years.")
	private int age;
	
	@NotBlank(message="gender cannot be blank.")
	private String gender;

	@Digits(fraction=0,integer=10,message="Please enter atleast 10 digit number.")
	private long contactNumber;
	
	@Email(message = "Enter Valid Email Id")
	private String emailId;
	
	@NotEmpty(message = "Customer Adharcard Number cannot be empty.")
	@Pattern(regexp = "^[2-9][0-9]{3}[0-9]{4}[0-9]{4}$", message = "Please enter a valid Adharcard number.")
	private String aadharCardNumber;
	
	@NotEmpty(message = "Customer Pancard Number cannot be empty.")
	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Please enter a valid Pancard number.")
	private String pancardNumber;
	
	@Size(min=10,max=100,message="Address length must be between 10 to 100 characters.")
	private String address;
	
	private int cibilScore;
	private String cibilStatus;
	private String loanStatus;
	
	@Temporal(TemporalType.DATE)
	private Date customerEnquiryDate;
	
	@Temporal(TemporalType.TIME)
	private Time customerEnquiryTime;
	
}
