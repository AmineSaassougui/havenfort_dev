
package com.camp.havenfort_dev.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


//email : playhouse680@gmail.com
// password : 123456.1998
@Service
public class MailSendService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendEmail(String toEmail,String body,String subject) {
			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom("playhouse680@gmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);

			mailSender.send(message);
			System.out.println("Mail Send ...");}
}
