package org.jgnn.study.web.securejpa;

import java.util.HashSet;
import java.util.Set;

import org.jgnn.study.web.securejpa.config.ApplicationConfig;
import org.jgnn.study.web.securejpa.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan("org.jgnn.study.web.securejpa.controller")
@ImportAutoConfiguration(
		{ApplicationConfig.class})
public class SpringWebJPAAuthentionApplication  extends SpringBootServletInitializer{

	private static final Logger log = LoggerFactory.getLogger(SpringWebJPAAuthentionApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(SpringWebJPAAuthentionApplication.class, args);
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	/*
	@Bean
	public CommandLineRunner demo(UserService service) {
		return (args) -> {
			
			
		};
	}
	*/
}

