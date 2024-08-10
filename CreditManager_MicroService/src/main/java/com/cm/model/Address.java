package com.cm.model;

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
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressDetailsId;
	private String areaName;
	private long pincode;
	private String city;
	private String state;
}

