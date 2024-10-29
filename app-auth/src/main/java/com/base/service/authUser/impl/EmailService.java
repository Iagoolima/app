package com.base.service.authUser.impl;

import com.base.domain.BodyEmail;
import com.base.service.authUser.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.base.constants.MessageAuth;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService implements IEmailService {

	@Value("${smtp.host}")
	private String host;

	@Value("${smtp.port}")
	private String port;

	@Value("${smtp.username}")
	private String username;

	@Value("${smtp.password}")
	private String password;

	@Autowired
	private MessageAuth messageAuth;

	private Session configureSession() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		return Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	public void sendEmail(BodyEmail email) {

		try {
			Session session = configureSession();

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEmail()));
			message.setSubject(email.getTitle());
			message.setText(email.getMessage());

			Transport.send(message);
		}
		catch (Exception e) {
			throw new RuntimeException(messageAuth.ERROR_EMAIL_NOT_SEND, e);
		}
	}

}
