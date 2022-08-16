package com.grego.mscourseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCourseServiceApplication.class, args);
	}

}
