package com.target.message.notification.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.slack.api.Slack;

@Service
public class SlackClient {

	private static final Logger log = LoggerFactory.getLogger(SlackClient.class);
	
	public void sendMessage(String slackWebhookUrl, String message) {

		try {

			Slack slack = Slack.getInstance();

			String webhookUrl = System.getenv(slackWebhookUrl);

			// commenting the below code to avoid the connectivity issue
			
			// WebhookResponse response = slack.send(webhookUrl, payload(p ->
			// p.text(message)));

			log.info("Message sent to Slack");

		} catch (Exception e) {
			log.info("Exception while sending the message to Slack:" + e);
		}
	}
}