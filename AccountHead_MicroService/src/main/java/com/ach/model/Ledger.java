package com.ach.model;

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
public class Ledger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ledgerId;
	@Temporal(TemporalType.DATE)
	private Date ledgerCreatedDate;
	private Double totalPrincipalAmount;
	private Double payableAmountWithInterest;
	private Integer tenure;
	private Double monthlyEMI;
	private Double amountPaidTillDate;
	private Double remainingAmount;
	@Temporal(TemporalType.DATE)
	private Date nextEmiStartDate;
	@Temporal(TemporalType.DATE)
	private Date nextEmiEndDate;
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	@Temporal(TemporalType.DATE)
	private Date loanEndDate;
	private String loanStatus;
	
}
