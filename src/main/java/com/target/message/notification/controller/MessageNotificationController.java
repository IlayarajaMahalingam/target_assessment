package com.target.message.notification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.target.message.notification.bo.MessagePayload;
import com.target.message.notification.channel.EmailClient;
import com.target.message.notification.channel.SlackClient;

@RestController
public class MessageNotificationController {

	private static final Logger log = LoggerFactory.getLogger(MessageNotificationController.class);

	@Autowired
	EmailClient emailClient;

	@Autowired
	SlackClient slackClient;

	@PostMapping("/notify")
	public String notifyUsers(@RequestBody MessagePayload payload) {

		try {
			emailClient.sendEmail(payload.getMailSender(), payload.getMailReceiver(), payload.getMailSubject(),
					payload.getMessage());

			slackClient.sendMessage(payload.getSlackWebhookUrl(), payload.getMessage());

		} catch (Exception e) {
			log.info("Exception while notifying the users:" + e);
			return "Could not notify the users due to some internal issues";
		}

		return "Notified the users successfully";
	}
}
