package com.twitter4j.twitter.to.kafka.service.runner.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.sanjay.config.TwitterToKafkaConfigData;
import com.twitter4j.twitter.to.kafka.service.listener.TwitterKafkaListener;
import com.twitter4j.twitter.to.kafka.service.runner.StreamRunner;

import jakarta.annotation.PreDestroy;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Component
@ConditionalOnProperty(name = "twitter-to-kafka-service.enable-mock-tweets", havingValue = "false")
public class TwitterKafkaStreamRunner implements StreamRunner{
	
	private final Logger logger = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);
	
	@Autowired
	private TwitterToKafkaConfigData twitterToKafkaConfigData;
	
	@Autowired
	private TwitterKafkaListener twitterKafkaListener;
	
	@Autowired
	private TwitterStream twitterStream;

	@Override
	public void start() throws TwitterException {
		twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.addListener(twitterKafkaListener);
		addFilter();
	}
	
	@PreDestroy
	public void shutdown() {
		if(twitterStream!=null) {
			logger.info("Closing the stream");
			twitterStream.shutdown();
		}
	}

	private void addFilter() {
		String[] keywords = twitterToKafkaConfigData.getTwitterKeywords().toArray(new String[0]);
		FilterQuery fileFilterQuery = new FilterQuery(keywords);
		twitterStream.filter(fileFilterQuery);
		logger.info("Started filtering the data for query {} ", Arrays.toString(keywords));
	}
	
	

}
