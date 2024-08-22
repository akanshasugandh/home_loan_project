package com.crm.controller;

import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;

import com.crm.model.CustomerEnquiry;
import com.crm.model.CustomerRegForm;
import com.crm.model.Document;
import com.crm.model.EmailDetails;
import com.crm.servicei.CustomerEnquiryServiceI;
import com.crm.servicei.CustomerRegiFormServiceI;
import com.crm.servicei.EmailServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
public class CustomerRegiFormController
{
	@Autowired CustomerRegiFormServiceI servicei;
	@Autowired CustomerEnquiryServiceI enqServicei;
	@Autowired private EmailServiceI emailservicei;
	
	private static Logger log=LoggerFactory.getLogger(CustomerRegiFormController.class);
	
	@PostMapping(value = "/saveCustRegForm/{customerEnquiryId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveCustomerRegForm(@RequestPart("photo") MultipartFile photo, 
			@RequestPart("aadharCard") MultipartFile aadharCard,
			@RequestPart("pancard") MultipartFile pancard,
			@RequestPart("incomeProof") MultipartFile incomeProof,
			@RequestPart("propertyPapers") MultipartFile propertyPapers,
			@RequestPart("bankStatement") MultipartFile bankStatement,
			@RequestPart("nOC") MultipartFile nOC,
			@RequestPart("data") String customerRegDetails,
			@Valid @PathVariable int customerEnquiryId)
			
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
		catch (ConstraintViolationException e) {
			System.out.println(e.getMessage());
			throw new ConstraintViolationException(e.getMessage(), null);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Unable to save Customer Registration details!", HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/getByCustomerRegId/{CustomerRegId}")
	public ResponseEntity<CustomerRegForm> getByCustomerRegId(@PathVariable int CustomerRegId)
	{
		CustomerRegForm crf=servicei.getByRegId(CustomerRegId);
		log.info("info()....get Registration Details by Customer's registration Id....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
	
	@GetMapping("/getByCuRegName/{firstName}")
	public ResponseEntity<CustomerRegForm> getByCuRegName(@PathVariable String firstName)
	{
		CustomerRegForm crf=servicei.getByCuRegName(firstName);
		log.info("info()....get Registration Details by customer name....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
	
	@GetMapping("/getByCuRegEmailId/{emailId}")
	public ResponseEntity<CustomerRegForm> getByCuRegEmailId(@PathVariable String emailId)
	{
		CustomerRegForm crf=servicei.getByCuRegEmailId(emailId);
		log.info("info()....get Registration Details by customer emailId....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
	
	@GetMapping("/getByCuRegPassword/{password}")
	public ResponseEntity<CustomerRegForm> getByCuRegPassword(@PathVariable String password)
	{
		CustomerRegForm crf=servicei.getByCuRegPassword(password);
		log.info("info()....get Registration Details by customer password....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
	
	@GetMapping("/getByCuRegAadharNum/{aadharCardNumber}")
	public ResponseEntity<CustomerRegForm> getByCuRegAadharNum(@PathVariable String aadharCardNumber)
	{
		CustomerRegForm crf=servicei.getByCuRegAadharNum(aadharCardNumber);
		log.info("info()....get Registration Details by customer aadharCardNumber....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
	
	@GetMapping("/getByCuRegPancardNum/{pancardNumber}")
	public ResponseEntity<CustomerRegForm> getByCuRegPancardNum(@PathVariable String pancardNumber)
	{
		CustomerRegForm crf=servicei.getByCuRegPancardNum(pancardNumber);
		log.info("info()....get Registration Details by customer pancardNumber....");
		return new ResponseEntity<CustomerRegForm>(crf, HttpStatus.OK);
	}
	
	
	// Get Data in Ascending order
    @GetMapping("/getFirstNameAsc")
	public ResponseEntity<List<CustomerRegForm>> getFirstNameAsc()
	{
	    List<CustomerRegForm> al = servicei.getFirstNameAsc();
		log.info("info()....get Registration Details by customer FirstName in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		
	@GetMapping("/getLastNameAsc")
	public ResponseEntity<List<CustomerRegForm>> getLastNameAsc()
	{
		List<CustomerRegForm> al = servicei.getLastNameAsc();
		log.info("info()....get Registration Details by customer LastName in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		
	@GetMapping("/getAgeByAsc")
	public ResponseEntity<List<CustomerRegForm>> getAgeByAsc()
	{
		List<CustomerRegForm> al = servicei.getAgeByAsc();
		log.info("info()....get Registration Details by customer Age in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		
	@GetMapping("/getContactNumberByAsc")
	public ResponseEntity<List<CustomerRegForm>> getontactNumberByAsc()
	{
		List<CustomerRegForm> al = servicei.getcontactNumberByAsc();
		log.info("info()....get Registration Details by customer contactNumber in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getEmailIdByAsc")
	public ResponseEntity<List<CustomerRegForm>> getEmailIdByAsc()
	{
		List<CustomerRegForm> al = servicei.getEmailIdByAsc();
		log.info("info()....get Registration Details by customer EmailId in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getAadharCardNumberByAsc")
	public ResponseEntity<List<CustomerRegForm>> getaadharCardNumberByAsc()
	{
		List<CustomerRegForm> al = servicei.getaadharCardNumberByAsc();
		log.info("info()....get Registration Details by customer AdharNumber in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getPancardNumberByAsc")
	public ResponseEntity<List<CustomerRegForm>> getpancardNumberByAsc()
	{
		List<CustomerRegForm> al = servicei.getPancardNumberByAsc();
		log.info("info()....get Registration Details by customer PancardNumber in Ascending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	// Get Data in Descending order
	@GetMapping("/getFirstNameDesc")
	public ResponseEntity<List<CustomerRegForm>> getFirstNameDesc()
	{
	    List<CustomerRegForm> al = servicei.getFirstNameDesc();
	    log.info("info()....get Registration Details by customer FirstName in Descending order....");
	    return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
			
	@GetMapping("/getLastNameDesc")
	public ResponseEntity<List<CustomerRegForm>> getLastNameDesc()
	{
		List<CustomerRegForm> al = servicei.getLastNameDesc();
		log.info("info()....get Registration Details by customer LastName in Descending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
			
	@GetMapping("/getAgeByDesc")
	public ResponseEntity<List<CustomerRegForm>> getAgeByDesc()
	{
		List<CustomerRegForm> al = servicei.getAgeByDesc();
		log.info("info()....get Registration Details by customer Age in Descending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getContactNumberByDesc")
	public ResponseEntity<List<CustomerRegForm>> getcontactNumberByDesc()
	{
		List<CustomerRegForm> al = servicei.getcontactNumberByDesc();
		log.info("info()....get Registration Details by customer contactNumber in Descending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getEmailIdByDesc")
	public ResponseEntity<List<CustomerRegForm>> getEmailIdByDesc()
	{
		List<CustomerRegForm> al = servicei.getEmailIdByDesc();
		log.info("info()....get Registration Details by customer EmailId in Descending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getAadharCardNumberByDesc")
	public ResponseEntity<List<CustomerRegForm>> getaadharCardNumberByDesc()
	{
		List<CustomerRegForm> al = servicei.getaadharCardNumberByDesc();
		log.info("info()....get Registration Details by customer AdharNumber in Descending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
		 
	@GetMapping("/getPancardNumberByDesc")
	public ResponseEntity<List<CustomerRegForm>> getpancardNumberByDesc()
	{
		List<CustomerRegForm> al = servicei.getPancardNumberByDesc();
		log.info("info()....get Registration Details by customer pancardNumber in Descending order....");
		return new ResponseEntity<List<CustomerRegForm>>(al, HttpStatus.OK);
	}
	
}
