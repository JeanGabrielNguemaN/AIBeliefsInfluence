package org.jgnn.study.web.securejpa.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			    .antMatchers("/*", "/home","/exp/*","/exp/*/*", "/exp/*/*/*","/register", "/register/*").permitAll()
			    .antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/hello")
				.permitAll()
				.and().logout()
				.logoutSuccessUrl("/login?logout=true")
	            .invalidateHttpSession(true)
	            .permitAll()
	            .and()
	            .csrf()
	            .disable();
		
		// http.csrf().disable();
	}

/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("jean")
				.password("03#SI$")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	*/

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
}
