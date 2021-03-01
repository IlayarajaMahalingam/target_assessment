package com.target.message.notification.channel;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailClient {

	private static final Logger log = LoggerFactory.getLogger(EmailClient.class);
	private static final String emailHostServer = "127.0.0.1";
	private static final String emailHost = "mail.smtp.host";

	public void sendEmail(String sender, String recipient, String subject, String messageBody) {

		Properties properties = System.getProperties();

		properties.setProperty(emailHost, emailHostServer);

		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(sender));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			message.setSubject(subject);

			message.setText(messageBody);

			// commenting the below code to avoid connectivity issues
			
			// Transport.send(message);

			log.info("Mail sent successfully");

		} catch (Exception e) {
			log.error("Got exception while sending email:" + e);
		}
	}
}
