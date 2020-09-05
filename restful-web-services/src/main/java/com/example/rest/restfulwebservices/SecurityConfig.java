package com.example.rest.restfulwebservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		// dont authenticate this particular request
		.authorizeRequests().antMatchers(
				"/h2-console/**",
				"/swagger-ui/**",
				"/v2/api-docs",
				"/v3/api-docs",
				"/swagger-resources/**").permitAll().
		// all other requests need to be authenticated
		anyRequest().authenticated().and()
		.formLogin().and()
		.httpBasic().and()
		.headers().frameOptions().sameOrigin().and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
