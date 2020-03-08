package com.myfirstrestfulservice.myFirstRestfulService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAuthorizationServer

public class MyFirstRestfulServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyFirstRestfulServiceApplication.class, args);

	}

}
