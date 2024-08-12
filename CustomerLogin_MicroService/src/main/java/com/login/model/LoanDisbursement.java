package com.login.model;

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
public class LoanDisbursement 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer agreementId;
	private String applicantName;
	private Double totalLoanSanctionedAmount;
	private Double transferedAmount;
	
	@Temporal(TemporalType.DATE)
	private Date amountPaidDate;
	
	private String paymentStatus;
	private Long bankAccountNumber;
	private String bankBranchName;
	private String bankIfscNumber;
}
