package com.sanjay.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twitter-to-kafka.service")
public class TwitterToKafkaConfigData {
	private List<String>twitterKeywords;
	private Boolean enableMockTweets;
	private Long mockSleepMs;
	private Integer mockMinTweetLength;
    private Integer mockMaxTweetLength;
	
	public TwitterToKafkaConfigData() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getTwitterKeywords() {
		return twitterKeywords;
	}

	public void setTwitterKeywords(List<String> twitterKeywords) {
		this.twitterKeywords = twitterKeywords;
	}

	public Boolean getEnableMockTweets() {
		return enableMockTweets;
	}

	public void setEnableMockTweets(Boolean enableMockTweets) {
		this.enableMockTweets = enableMockTweets;
	}

	public Long getMockSleepMs() {
		return mockSleepMs;
	}

	public void setMockSleepMs(Long mockSleepMs) {
		this.mockSleepMs = mockSleepMs;
	}

	public Integer getMockMinTweetLength() {
		return mockMinTweetLength;
	}

	public void setMockMinTweetLength(Integer mockMinTweetLength) {
		this.mockMinTweetLength = mockMinTweetLength;
	}

	public Integer getMockMaxTweetLength() {
		return mockMaxTweetLength;
	}

	public void setMockMaxTweetLength(Integer mockMaxTweetLength) {
		this.mockMaxTweetLength = mockMaxTweetLength;
	}
	
	
}
