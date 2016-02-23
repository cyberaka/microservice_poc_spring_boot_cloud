package com.globomart.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GlobomartEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobomartEurekaServerApplication.class, args);
	}
}
