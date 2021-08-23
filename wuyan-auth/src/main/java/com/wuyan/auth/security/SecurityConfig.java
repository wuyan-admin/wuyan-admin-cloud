/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security;

import com.wuyan.auth.factory.PasswordEncoderFactories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wangguodong
 * @since 2021/8/4
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder(10);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sang")
				.password(passwordEncoder().encode("123"))
				.roles("admin").and().withUser("javaboy")
				.password(passwordEncoder().encode("123"))
				.roles("user");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().formLogin().loginPage("/login").loginProcessingUrl("/account-login");
	}
}
