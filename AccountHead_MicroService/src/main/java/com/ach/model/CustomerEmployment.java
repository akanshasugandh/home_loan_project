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
public class CustomerEmployment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employementId;
	private String employementType;
	private double monthlyIncome;
	private String designation;
}
