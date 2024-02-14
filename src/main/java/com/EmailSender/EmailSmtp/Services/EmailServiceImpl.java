package com.EmailSender.EmailSmtp.Services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.EmailSender.EmailSmtp.Entity.EmailDetails;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	
	private String sender;
	
	@Override
	public String sendSimpleMail(EmailDetails emailDetails) {
		
		try
		{
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("hemanthkuma406@gmail.com");
			mailMessage.setTo(emailDetails.getReciepent());
			mailMessage.setText(emailDetails.getMsgBody());
			mailMessage.setSubject(emailDetails.getSubject());
			
			javaMailSender.send(mailMessage);
			
			return "Mail Sent SuccessFully";
			
			
		}catch (Exception e) {
			// TODO: handle exception
			return "Error While Sending Mail";
		}
	}

	@Override
	public String sendMailWithAttachment(EmailDetails emailDetails) {
		//Creating mime Message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper;
		
		try
		{
			//setting Multiple as true for attachments to
			//be send
			messageHelper = new MimeMessageHelper(mimeMessage,true);
			messageHelper.setFrom("hemanthkuma406@gmail.com");
			messageHelper.setTo(emailDetails.getReciepent());
			messageHelper.setText(emailDetails.getMsgBody());
			messageHelper.setSubject(emailDetails.getSubject());
			
			//Adding Attachment
			
			FileSystemResource file = new FileSystemResource(
					new File(emailDetails.getAttachment()));
			
			messageHelper.addAttachment(file.getFilename(), file);
			
			//Sending The Mail
			javaMailSender.send(mimeMessage);
			
			return "Mail Sent SuccessFully";
		}catch (Exception e) {
		
			return "Error While Sending Mail!!";
		}
	}

}
