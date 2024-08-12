package com.login.model;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails 
{
	@Value("$spring.mail.username")
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String txtMsg;
}
