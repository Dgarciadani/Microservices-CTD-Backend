package com.example.musicaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MusicaServiceApplication {

	public static void main (String[] args) {
		SpringApplication.run(MusicaServiceApplication.class, args);
	}

}
