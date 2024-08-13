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
public class PropertyDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyDetailsId;
	private String propertLocation;
	private String propertyType;
	private double propertyCost;
}
