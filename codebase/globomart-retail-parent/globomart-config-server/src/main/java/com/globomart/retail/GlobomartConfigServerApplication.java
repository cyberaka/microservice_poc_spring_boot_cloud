package com.globomart.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class GlobomartConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobomartConfigServerApplication.class, args);
	}
}
