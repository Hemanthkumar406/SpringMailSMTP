package com.EmailSender.EmailSmtp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmailSender.EmailSmtp.Entity.EmailDetails;
import com.EmailSender.EmailSmtp.Services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	
	@PostMapping("/sendmail")
	public String sendMail(@RequestBody EmailDetails details)
	{
		String status = emailService.sendSimpleMail(details);
		
		return status;
	}
	
	@PostMapping("/sendmailwithattachment")
	public String sendMailWithAttachemant(@RequestBody EmailDetails details)
	{
		String status = emailService.sendMailWithAttachment(details);
		return status;
	}
}
