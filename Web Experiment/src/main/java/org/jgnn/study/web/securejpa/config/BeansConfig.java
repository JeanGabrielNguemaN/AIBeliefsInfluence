package org.jgnn.study.web.securejpa.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
@ComponentScan(basePackages = "org.jgnn.study.web.securejpa.config")
public class BeansConfig {
	

	@Bean
	public LocaleResolver localeResolver() {
	    return new CookieLocaleResolver();
	}
	
	
	

}