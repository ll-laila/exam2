package com.example.discavery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class DiscaveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscaveryApplication.class, args);
	}

}
