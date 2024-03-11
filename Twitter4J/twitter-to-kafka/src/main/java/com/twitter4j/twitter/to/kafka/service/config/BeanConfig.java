package com.twitter4j.twitter.to.kafka.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Configuration
public class BeanConfig {
	
	
	@Bean
	public TwitterStream twitterStream() {
	    return new TwitterStreamFactory().getInstance();
	}

}
