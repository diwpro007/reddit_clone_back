package com.example.reddit_clone.reddit_clone_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditCloneBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCloneBackApplication.class, args);
	}

}
