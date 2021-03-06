package com.rayvision;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@MapperScan(basePackages = "com.rayvision.mapper")
@ComponentScan(basePackages="com.rayvision")
public class SecurityAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityAdminApplication.class, args);
	}
}
