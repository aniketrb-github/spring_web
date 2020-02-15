package com.arbtech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Created a Docket bean which will map all API's & end-points into the swagger UI in browser
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	
	/**
	 * This allows you to view the JSON representation of all your application end-points hosted currently
	 * > http://localhost:8888/v2/api-docs
	 * 
	 * This allows the client to view your applications end-point & it's meta-data as well in an intuitive way
	 * > http://localhost:8888/swagger-ui.html
	 */
}
