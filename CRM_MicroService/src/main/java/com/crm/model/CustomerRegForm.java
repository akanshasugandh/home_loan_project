package com.crm.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegForm 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CustomerRegId;
	
	@NotBlank(message = "First Name cannot be blank.")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be blank.")
	private String lastName;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@Past(message="Enter a valid date")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Max(value=65, message = "Age cannot be greater than 65 years.")
	@Min(value=21, message = "Age cannot be less than 21 years.")
	private int age;
	
	@NotEmpty(message="gender cannot be empty.")
	private String gender;
	

	@Digits(fraction=0,integer=10,message="Please enter atleast 10 digit number.")
	private long contactNumber;
	
	@Email(message = "Enter Valid Email Id")
	private String emailId;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{6,10}$", message = "Password must be between 6 to 10 characters long.")
	private String password;
	
	@NotBlank(message="Marital Status cannot be blank")
	private String maritalStatus;
	
	@NotEmpty(message = "Adharcard Number cannot be empty.")
	@Pattern(regexp = "^[2-9][0-9]{3}[0-9]{4}[0-9]{4}$", message = "Please enter a valid Adharcard number.")
	private String aadharCardNumber;
	
	@NotEmpty(message = "Pancard Number cannot be empty.")
	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Please enter a valid Pancard number.")
	private String pancardNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerEmployment employment;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankinfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyInfo;
	
	private int cibilScore;
	private String cibilStatus;
	private String loanStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Document documents;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerEnquiry customerData;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursement;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Ledger ledger;
	
}
