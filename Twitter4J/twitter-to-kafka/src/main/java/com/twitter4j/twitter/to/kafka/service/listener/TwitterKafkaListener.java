package com.twitter4j.twitter.to.kafka.service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.StatusAdapter;


@Component
public class TwitterKafkaListener extends StatusAdapter{
	
	private final Logger logger = LoggerFactory.getLogger(TwitterKafkaListener.class);
	
	@Override
	public void onStatus(Status status) {
		logger.info("Twitter Status with text {} ",status.getText());
	}
}
