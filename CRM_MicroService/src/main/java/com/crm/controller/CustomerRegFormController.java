package com.crm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.crm.model.CustomerEnquiry;
import com.crm.model.CustomerRegForm;
import com.crm.model.Document;
import com.crm.model.EmailDetails;
import com.crm.servicei.CustomerEnquiryServiceI;
import com.crm.servicei.CustomerRegFormServiceI;
import com.crm.servicei.EmailServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerRegFormController
{
	@Autowired CustomerRegFormServiceI servicei;
	@Autowired CustomerEnquiryServiceI enqServicei;
	@Autowired private EmailServiceI emailservicei;
	
	private static Logger log=LoggerFactory.getLogger(CustomerRegFormController.class);
	
	@PostMapping(value = "/saveCustRegForm/{customerEnquiryId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveCustomerRegForm(@RequestPart("photo") MultipartFile photo, 
			@RequestPart("aadharCard") MultipartFile aadharCard,
			@RequestPart("pancard") MultipartFile pancard,
			@RequestPart("incomeProof") MultipartFile incomeProof,
			@RequestPart("propertyPapers") MultipartFile propertyPapers,
			@RequestPart("bankStatement") MultipartFile bankStatement,
			@RequestPart("nOC") MultipartFile nOC,
			@RequestPart("data") String customerRegDetails,
			@PathVariable int customerEnquiryId)
			
		{
		ObjectMapper om=new ObjectMapper();	
		try 
		{
			CustomerRegForm crf=om.readValue(customerRegDetails, CustomerRegForm.class);
			Document doc=new Document();
			doc.setPhoto(photo.getBytes());
			doc.setAadharCard(aadharCard.getBytes());
			doc.setPancard(pancard.getBytes());
			doc.setIncomeProof(incomeProof.getBytes());
			doc.setPropertyPapers(propertyPapers.getBytes());
			doc.setBankStatement(bankStatement.getBytes());
			doc.setNOC(nOC.getBytes());
			crf.setDocuments(doc);
			
			CustomerEnquiry c=enqServicei.getByCuId(customerEnquiryId);
			crf.setFirstName(c.getFirstName());
			crf.setLastName(c.getLastName());
			crf.setAge(c.getAge());
			crf.setGender(c.getGender());
			crf.setContactNumber(c.getContactNumber());
			crf.setEmailId(c.getEmailId());
			crf.setAadharCardNumber(c.getAadharCardNumber());
			crf.setPancardNumber(c.getPancardNumber());
			crf.setCibilScore(c.getCibilScore());
			crf.setLoanStatus(c.getLoanStatus());
			crf.setCustomerData(c);
			crf.setCibilStatus("CIBIL_Pending");
			servicei.saveRegForm(crf);
			EmailDetails ed=new EmailDetails();
			ed.setToEmail(crf.getEmailId());
			emailservicei.sendEmail2(ed);
			log.info("info()....save Registration Details....");
			return new ResponseEntity<String>("Customer Registration details saved!", HttpStatus.OK);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Unable to save Customer Registration details!", HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/getCustRegForm/{CustomerRegId}")
	public ResponseEntity<CustomerRegForm> getByCustomerRegId(@PathVariable int CustomerRegId)
	{
		CustomerRegForm crf=servicei.getByRegId(CustomerRegId);
		log.info("info()....get Registration Details by registration Id....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
}
