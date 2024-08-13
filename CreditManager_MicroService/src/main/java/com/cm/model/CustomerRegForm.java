package com.cm.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private int age;
	
	private String gender;
	private long contactNumber;
	private String emailId;
	private String password;
	private String maritalStatus;
	private String aadharCardNumber;
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
 