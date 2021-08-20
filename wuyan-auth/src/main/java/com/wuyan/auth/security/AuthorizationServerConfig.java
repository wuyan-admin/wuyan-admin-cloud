/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security;

import com.wuyan.auth.application.WuYanClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author wangguodong
 * @since v1
 */
@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private final TokenStore tokenStore;

	private final ClientDetailsService clientDetailsService;

	private final AuthenticationManager authenticationManager;

	// 保存token
	@Bean
	AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices services = new DefaultTokenServices();
		services.setClientDetailsService(clientDetailsService);
		services.setSupportRefreshToken(true);
		services.setTokenStore(tokenStore);
		services.setAccessTokenValiditySeconds(60 * 60 * 2);
		services.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);
		return services;
	}


	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// 校验token访问
		security.checkTokenAccess("permitAll()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("javaboy")
				.secret(new BCryptPasswordEncoder().encode("123"))
				.resourceIds("res1")
				.authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
				.scopes("all")
				.autoApprove(true)
				.redirectUris("http://localhost:8082/index.html", "http://localhost:8082/simple-index.html");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// 授权码  账号密码模式
		endpoints.authenticationManager(authenticationManager)
				.tokenServices(tokenServices())
				.setClientDetailsService(clientDetailsService());
	}

	@Bean
	ClientDetailsService clientDetailsService() {
		return new WuYanClientDetailsService();
	}

	@Bean
	AuthorizationCodeServices authorizationCodeServices() {
		return new InMemoryAuthorizationCodeServices();
	}

}
