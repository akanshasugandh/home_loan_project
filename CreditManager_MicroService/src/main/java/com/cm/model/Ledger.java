package com.cm.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ledger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ledgerId;
	private Date ledgerCreatedDate;
	private Double totalPrincipalAmount;
	private Double payableAmountWithInterest;
	private Integer tenure;
	private Double monthlyEMI;
	private Double amountPaidTillDate;
	private Double remainingAmount;
	private Date nextEmiStartDate;
	private Date nextEmiEndDate;
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	private Date loanEndDate;
	private String loanStatus;
	
}
