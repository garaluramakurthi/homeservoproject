package com.jsp.HomeServo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HomeServoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeServoApplication.class, args);
	}
	
	@Bean
	public ModelMapper get() {
		return new ModelMapper();
	}
	
	@Configuration
	public class webConfig implements WebMvcConfigurer{
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET" , "POST" , "PUT" , "DELETE" , "PATCH");
		}
	}

}
