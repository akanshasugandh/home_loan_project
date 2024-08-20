package com.cm.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.model.CustomerRegForm;
import com.cm.model.SanctionLetter;
import com.cm.repository.CustomerRegFormRepository;
import com.cm.repository.SanctionLRepository;
import com.cm.servicei.SanctionLServiceI;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class SanctionLServiceImpl implements SanctionLServiceI {

	@Autowired
	SanctionLRepository repository;
	@Autowired
	CustomerRegFormRepository crepository;
	
	@Override
	public void saveSanction(SanctionLetter sl) {
		repository.save(sl);
	}
	
	@Override
	public CustomerRegForm saveSanctionLetter(SanctionLetter sl, int customerRegId) 
	{
		
		Optional<CustomerRegForm> opletter= crepository.findById(customerRegId);
		CustomerRegForm cf = opletter.get();
		if(opletter.isPresent()) 
		{
			cf.getSanctionLetter().setSanctionDate(sl.getSanctionDate());
			cf.getSanctionLetter().setApplicantName(cf.getFirstName());
			cf.getSanctionLetter().setSanctionAmount(sl.getSanctionAmount());
			cf.getSanctionLetter().setRateofInterest(sl.getRateofInterest());
			cf.getSanctionLetter().setLoanTenure(sl.getLoanTenure());
			cf.getSanctionLetter().setMonthlyEMIAmount(sl.getMonthlyEMIAmount());
		
			String title = "AMPRR Finance Ltd.";

			Document document = new Document(PageSize.A4);

			String content1 = "\n\n Dear " + cf.getFirstName()
					+ ","
					+ "\nAMPRR Finance Ltd. is Happy to informed you that your loan application has been approved. ";

			String content2 = "\n\nWe are pleased to inform you that hope that your loan application has been approved. "
					+ "We understand the importance of this loan and the role it plays in helping you reach your financial goals."
					+ "\n\nThe amount of(loan amount)has been approved,and we will begin processing the transfer immediately."
					+ "We want to make sure that you have everything you need.so please don't hesitate to contact usif there are any additional"
					+ "questions or concerns."
					+ "\n\nThank you for choosing us for your financial needs we wish you all the best as you take this next step in growing business!"
					+ "\n\nSincerely,\n\n" + "Parag Patel (Credit Manager)";

			ByteArrayOutputStream opt = new ByteArrayOutputStream();
			
			PdfWriter.getInstance(document, opt);
			document.open();

			Image img = null;
			try {
				img = Image.getInstance("C:\\Users\\rames\\Downloads\\logo.jpg");
				img.scalePercent(50, 50);
				img.setAlignment(Element.ALIGN_RIGHT);
				document.add(img);

			} catch (BadElementException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
			Paragraph titlepara = new Paragraph(title, titlefont);
			titlepara.setAlignment(Element.ALIGN_CENTER);
			document.add(titlepara);

			Font titlefont2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent1 = new Paragraph(content1, titlefont2);
			document.add(paracontent1);

			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 2, 2 });
			table.setSpacingBefore(10);

			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(CMYKColor.WHITE);
			cell.setPadding(5);

			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font.setColor(5, 5, 161);

			Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(5, 5, 161);

			cell.setPhrase(new Phrase("Loan Amount Sanctioned", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf("₹ " + cf.getSanctionLetter().getSanctionAmount()),
					font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Loan Tenure", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase(String.valueOf(cf.getSanctionLetter().getLoanTenure()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Interest Rate", font));
			table.addCell(cell);

			cell.setPhrase(
					new Phrase(String.valueOf(cf.getSanctionLetter().getRateofInterest()) + " %", font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Sanction letter generated Date", font));
			table.addCell(cell);

			cf.getSanctionLetter().setSanctionDate(new Date());
			cell.setPhrase(
					new Phrase(String.valueOf(cf.getSanctionLetter().getSanctionDate()), font1));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Total loan Amount with Interest", font));
			table.addCell(cell);

			document.add(table);

			Font titlefont3 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
			Paragraph paracontent2 = new Paragraph(content2, titlefont3);
			document.add(paracontent2);
			document.close();
			
			ByteArrayInputStream byt = new ByteArrayInputStream(opt.toByteArray());
			byte[] bytes = byt.readAllBytes();
			cf.getSanctionLetter().setSanctionDocpdf(bytes);
	
			return crepository.save(cf);
		}
		else 
		{
			return null;
		}
	}
}
