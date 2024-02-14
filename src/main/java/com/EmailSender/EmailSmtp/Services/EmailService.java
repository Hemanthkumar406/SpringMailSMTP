package com.EmailSender.EmailSmtp.Services;

import com.EmailSender.EmailSmtp.Entity.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails emailDetails);
	
	String sendMailWithAttachment(EmailDetails emailDetails);
}
