package com.EmailSender.EmailSmtp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {

	private String reciepent;
	
	private String msgBody;
	
	private String subject;
	
	private String attachment;
	
}
