package com.github.xuyuanzhi.template.core.intergration.email;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Profile({ "dev", "test", "prod", "mac" })
@Component
public class EmailSender {

	protected static Logger logger = LoggerFactory.getLogger(EmailSender.class);
	
	private static EmailSender emailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.from}")
	private String from;
	
	@PostConstruct
	public void init() {
		emailSender = this;
	}
	
	private boolean send0(String to, String subject, String content) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			
			javaMailSender.send(helper.getMimeMessage());
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return false;
		}
	}
	
	public static boolean send(String to, String subject, String content) {
		return emailSender.send0(to, subject, content);
	}
}
