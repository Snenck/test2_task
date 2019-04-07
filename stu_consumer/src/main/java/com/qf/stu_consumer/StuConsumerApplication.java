package com.qf.stu_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
public class StuConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuConsumerApplication.class, args);
	}

}
