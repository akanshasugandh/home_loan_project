package com.cm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentId;
	
	@Lob
	@Column(length = 999999999)
	private byte[] photo;
	
	@Lob
	@Column(length = 999999999)
	private byte[] aadharCard;
	
	@Lob
	@Column(length = 999999999)
	private byte[] pancard;
	
	@Lob
	@Column(length = 999999999)
	private byte[] incomeProof;
	
	@Lob
	@Column(length = 999999999)
	private byte[] propertyPapers;
	
	@Lob
	@Column(length = 999999999)
	private byte[] bankStatement;
	
	@Lob
	@Column(length = 999999999)
	private byte[] nOC;
}
