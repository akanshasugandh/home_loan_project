package com.login.controller;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.model.CustomerRegForm;
import com.login.model.Document;
import com.login.model.EmailDetails;
import com.login.model.Ledger;
import com.login.servicei.CustomerLoginServiceI;
import com.login.servicei.CustomerRegFormServiceI;
import com.login.servicei.EmailServiceI;

@RestController
public class CustomerLoginController 
{
	@Autowired CustomerRegFormServiceI regFormServiceI;
	@Autowired CustomerLoginServiceI loginServiceI;
	@Autowired private EmailServiceI emailservicei;
	
	long Otp;
	int count=0;
	private static Logger log=LoggerFactory.getLogger(CustomerLoginController.class);
	
	@GetMapping("/getAllRegEnquiry")
	public List<CustomerRegForm> getCustomerRegForm()
	{
		log.info("info()...getAllEnquiry().........");
		List<CustomerRegForm> al=loginServiceI.getCustomerRegForm(); 
		return al;
	}

	@GetMapping("/login/{emailId}/{password}/{getOtp}")
	public ResponseEntity<String> UsernamePwd(@PathVariable String emailId,@PathVariable String password,@PathVariable int getOtp)
	{
		CustomerRegForm cr=loginServiceI.customerLogin(emailId, password,getOtp);
		log.info("info()...get email password Otp().........");
		if(getOtp==Otp)
		{
			return new ResponseEntity<String> ("Valied OTP",HttpStatus.OK); 
		}
		else
		{
			return new ResponseEntity<String> ("Invalied OTP",HttpStatus.OK);
		}
	}
	
	@PostMapping("/sendOtp/{emailId}/{CustomerRegId}")
	public String getOtp(@PathVariable String emailId,@PathVariable int CustomerRegId)
	{
		log.info("info()...get Otp().........");
		Random r=new Random();
		Otp=1000+r.nextInt(9999);
		emailservicei.sendEmailOtp(emailId, Otp);
		return String.valueOf(Otp);	
	}
	
	@GetMapping("/viewSanctionAccepted/{sanctionId}")
	public ResponseEntity<String> sanAccepted(@PathVariable int sanctionId)
	{
		CustomerRegForm byCuId = loginServiceI.getByCuId(sanctionId);
		byCuId.setLoanStatus("sanAccepted");
		loginServiceI.saveRegForm(byCuId);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(byCuId.getEmailId());
		emailservicei.sendEmailAcc(ed);
		log.info("info()...view Sanction Accepted().........");
		return new ResponseEntity<String>("sanAccepted", HttpStatus.OK);
	}
	
	@GetMapping("/viewSanctionRejected/{sanctionId}")
	public ResponseEntity<String> sanRejected(@PathVariable int sanctionId)
	{
		CustomerRegForm byCuId = loginServiceI.getByCuIdr(sanctionId);
		byCuId.setLoanStatus("sanRejected");
		loginServiceI.saveRegForm(byCuId);
		EmailDetails ed=new EmailDetails();
		ed.setToEmail(byCuId.getEmailId());
		emailservicei.sendEmailRej(ed);
		log.info("info()...view Sanction Rejected().........");
		return new ResponseEntity<String>("sanRejected", HttpStatus.OK);
	}
	
	@PutMapping(value="updateData/{CustomerRegId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String>updateCustomerdata(@PathVariable int CustomerRegId ,@RequestPart("photo") MultipartFile photo, 
			@RequestPart("aadharCard") MultipartFile aadharCard,
			@RequestPart("pancard") MultipartFile pancard,
			@RequestPart("incomeProof") MultipartFile incomeProof,
			@RequestPart("propertyPapers") MultipartFile propertyPapers,
			@RequestPart("bankStatement") MultipartFile bankStatement,
			@RequestPart("nOC") MultipartFile nOC,
			@RequestPart("data") String customerRegDetails)
	
		{
			CustomerRegForm cu = regFormServiceI.getByCuRegId(CustomerRegId);
			ObjectMapper om=new ObjectMapper();	
			try 
			{
				CustomerRegForm crm=om.readValue(customerRegDetails, CustomerRegForm.class);
				cu.setAadharCardNumber(crm.getAadharCardNumber());
				cu.setAddress(crm.getAddress());
				cu.setAge(crm.getAge());
				cu.setCibilScore(crm.getCibilScore());
				cu.setCibilStatus(crm.getCibilStatus());
				cu.setContactNumber(crm.getContactNumber());
				cu.setCustomerData(crm.getCustomerData());
				cu.setDateOfBirth(crm.getDateOfBirth());
				cu.setEmailId(crm.getEmailId());
				cu.setFirstName(crm.getFirstName());
				cu.setGender(crm.getGender());
				cu.setLastName(crm.getLastName());
				cu.setLoanStatus(crm.getLoanStatus());
				cu.setMaritalStatus(crm.getMaritalStatus());
				cu.setPancardNumber(crm.getPancardNumber());
				cu.setPassword(crm.getPassword());
				cu.getBankinfo().setBankAccountNo(crm.getBankinfo().getBankAccountNo());
				cu.getBankinfo().setAccountType(crm.getBankinfo().getAccountType());
				cu.getBankinfo().setBankCustomerId(crm.getBankinfo().getBankCustomerId());
				cu.getBankinfo().setBranchAddress(crm.getBankinfo().getBranchAddress());
				cu.getBankinfo().setIfscCode(crm.getBankinfo().getIfscCode());
				cu.getBankinfo().setMicrCode(crm.getBankinfo().getMicrCode());
				cu.getGuarantorDetails().setGuarantorId(crm.getGuarantorDetails().getGuarantorId());
				cu.getGuarantorDetails().setRelationshipToCustomer(crm.getGuarantorDetails().getRelationshipToCustomer());
				cu.getGuarantorDetails().setFirstName(crm.getGuarantorDetails().getFirstName());
				cu.getGuarantorDetails().setLastName(crm.getGuarantorDetails().getLastName());
				cu.getGuarantorDetails().setAadharCardNo(crm.getGuarantorDetails().getAadharCardNo());
				cu.getGuarantorDetails().setAddress(crm.getGuarantorDetails().getAddress());
				cu.getGuarantorDetails().setAge(crm.getGuarantorDetails().getAge());
				cu.getGuarantorDetails().setContactNo(crm.getGuarantorDetails().getContactNo());
				cu.getGuarantorDetails().setDateOfBirth(crm.getGuarantorDetails().getDateOfBirth());
				cu.getGuarantorDetails().setEmailId(crm.getEmailId());
				cu.getGuarantorDetails().setPanCardNo(crm.getGuarantorDetails().getPanCardNo());
				cu.getPropertyInfo().setPropertLocation(crm.getPropertyInfo().getPropertLocation());
				cu.getPropertyInfo().setPropertyCost(crm.getPropertyInfo().getPropertyCost());
				cu.getPropertyInfo().setPropertyDetailsId(crm.getPropertyInfo().getPropertyDetailsId());
				cu.getPropertyInfo().setPropertyType(crm.getPropertyInfo().getPropertyType());
				Document doc=new Document();
				doc.setPhoto(photo.getBytes());
				doc.setAadharCard(aadharCard.getBytes());
				doc.setPancard(pancard.getBytes());
				doc.setIncomeProof(incomeProof.getBytes());
				doc.setPropertyPapers(propertyPapers.getBytes());
				doc.setBankStatement(bankStatement.getBytes());
				doc.setNOC(nOC.getBytes());
				cu.setDocuments(doc);

			loginServiceI.updateCustomerdata(cu);
			log.info("info()...Update Data().........");
			return new ResponseEntity<String> ("Data Updated..!!",HttpStatus.OK);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				return new ResponseEntity<String>("Unable to save Customer Update Registration details!", HttpStatus.OK);
			}
	}
	
	@GetMapping("/CurrentEMIStatus/{CustomerRegId}")
	public ResponseEntity<String> CurrentEMIStatus(@RequestBody Ledger led, @PathVariable int CustomerRegId)
	{
		CustomerRegForm cureg=regFormServiceI.getByCuRegId(CustomerRegId);
		
		return new ResponseEntity<String>("EMI paid", HttpStatus.OK);
	}
	
	@PutMapping("/EMIStatusPay/{CustomerRegId}")
	public ResponseEntity<String> EMIStatusPay(@RequestBody Ledger led, @PathVariable int CustomerRegId)
	{
		CustomerRegForm cureg=regFormServiceI.getByCuRegId(CustomerRegId);
		Ledger ldg=new Ledger();
		ldg.setAmountPaidTillDate(cureg.getLedger().getAmountPaidTillDate()+cureg.getSanctionLetter().getMonthlyEMIAmount());
		ldg.setCurrentMonthEmiStatus("Paid");
		ldg.setLedgerCreatedDate(new Date());
		ldg.setLoanEndDate(led.getLoanEndDate());
		ldg.setLoanStatus(cureg.getLoanStatus());
		ldg.setMonthlyEMI(cureg.getSanctionLetter().getMonthlyEMIAmount());
		ldg.setNextEmiStartDate(led.getNextEmiStartDate());
		ldg.setNextEmiEndDate(led.getNextEmiEndDate());
		ldg.setPreviousEmiStatus(led.getPreviousEmiStatus());
		ldg.setPayableAmountWithInterest((cureg.getLedger().getPayableAmountWithInterest()));
		ldg.setRemainingAmount((cureg.getLedger().getPayableAmountWithInterest()-ldg.getAmountPaidTillDate()));
		ldg.setTenure(cureg.getLedger().getTenure());
		ldg.setTotalPrincipalAmount(cureg.getLoanDisbursement().getTotalLoanSanctionedAmount());
		ldg.setEmiCount(cureg.getLedger().getEmiCount()+1);
		if(cureg.getLedger().getEmiCount()==cureg.getLedger().getTenure())
		{
			ldg.setLoanStatus("LoanClosureSuccess");
		}
		cureg.setLedger(ldg);
		regFormServiceI.saveRegForm(cureg);
		log.info("info()...EMIStatusPay().........");
		return new ResponseEntity<String>("EMI Paid", HttpStatus.OK);
	}
	
	@PutMapping("/EMIStatusSkip/{CustomerRegId}")
	public ResponseEntity<String> EMIStatusSkip(@RequestBody Ledger led, @PathVariable int CustomerRegId)
	{
		CustomerRegForm cureg=regFormServiceI.getByCuRegId(CustomerRegId);
		Ledger ldg=new Ledger();
		
		ldg.setAmountPaidTillDate(cureg.getLedger().getAmountPaidTillDate());
		ldg.setCurrentMonthEmiStatus("Skipped");
		ldg.setLedgerCreatedDate(new Date());
		ldg.setLoanEndDate(led.getLoanEndDate());

		ldg.setMonthlyEMI(cureg.getSanctionLetter().getMonthlyEMIAmount());
		ldg.setNextEmiStartDate(led.getNextEmiStartDate());
		ldg.setNextEmiEndDate(led.getNextEmiEndDate());
		ldg.setPreviousEmiStatus(led.getPreviousEmiStatus());
		if(ldg.getCurrentMonthEmiStatus().equals("Skipped")) 
	    count++;
	    System.out.println("count= "+count);
		if(count==3)
		{
			ldg.setLoanStatus("Defaulter");
		}
		else
		{
			ldg.setLoanStatus(cureg.getLoanStatus());
		}
		ldg.setPayableAmountWithInterest((cureg.getLedger().getPayableAmountWithInterest()));
		ldg.setRemainingAmount((cureg.getLedger().getPayableAmountWithInterest()-ldg.getAmountPaidTillDate()));
		ldg.setTenure(cureg.getLedger().getTenure());
		ldg.setTotalPrincipalAmount(cureg.getLoanDisbursement().getTotalLoanSanctionedAmount());

		cureg.setLedger(ldg);
		regFormServiceI.saveRegForm(cureg);
		log.info("info()...EMIStatusSkip().........");
		return new ResponseEntity<String>("EMI Skipped", HttpStatus.OK);
	}
	
}

