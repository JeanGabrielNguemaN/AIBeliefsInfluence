package org.jgnn.study.web.securejpa.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan("org.jgnn.study.web.securejpa")

//Importar as classes de configuração
@Import({ MvcConfig.class,BeansConfig.class, WebSecurityConfig.class})
public class ApplicationConfig {


}
//https://stackoverflow.com/questions/38795287/webapplicationcontextutils-getwebapplicationcontextservletcontext-returns-null