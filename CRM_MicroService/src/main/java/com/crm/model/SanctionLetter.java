package com.crm.model;

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
public class SanctionLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sanctionId;
	private String applicantName;

	@Temporal(TemporalType.DATE)
	private Date sanctionDate;
	
	private double sanctionAmount;
	private int loanTenure;
	private Float rateofInterest; 
	private double monthlyEMIAmount;
	private byte[] sanctionDocpdf;
}
