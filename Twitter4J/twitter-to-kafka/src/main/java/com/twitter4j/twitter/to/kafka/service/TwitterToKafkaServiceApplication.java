package com.twitter4j.twitter.to.kafka.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sanjay.config.TwitterToKafkaConfigData;
import com.twitter4j.twitter.to.kafka.service.runner.StreamRunner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sanjay.microservice", "com.sanjay.config"})
public class TwitterToKafkaServiceApplication implements CommandLineRunner{
	
	private final Logger logger = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);
	
	@Autowired
	private TwitterToKafkaConfigData toKafkaConfigData;
	
	@Autowired
	private StreamRunner streamRunner;
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaServiceApplication.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("App Starts..");
		logger.info(Arrays.toString(toKafkaConfigData.getTwitterKeywords().toArray(new String[] {})));
		logger.info(toKafkaConfigData.getEnableMockTweets().toString());
		streamRunner.start();
	}
	
	
	
}
