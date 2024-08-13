package com.ach.model;

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
public class BankDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankCustomerId;
	private long bankAccountNo;
	private String accountType;
	private String branchName;
	private String branchAddress;
	private String ifscCode;
	private String micrCode;
}
