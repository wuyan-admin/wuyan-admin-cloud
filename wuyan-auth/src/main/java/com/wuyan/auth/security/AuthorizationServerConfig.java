/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security;

import com.wuyan.auth.security.service.WuYanClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 * @author wangguodong
 * @since v1
 */
@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private final TokenStore tokenStore;

	private final AuthenticationManager authenticationManager;

	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Bean
	AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices services = new DefaultTokenServices();
		services.setSupportRefreshToken(true);
		services.setTokenStore(tokenStore);
		services.setAccessTokenValiditySeconds(60 * 60 * 2);
		services.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		// token增强 jwt
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
		services.setTokenEnhancer(tokenEnhancerChain);
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
		clients.withClientDetails(wuYanClientDetailsService());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// 授权码  账号密码模式
		endpoints.authenticationManager(authenticationManager)
				.tokenServices(tokenServices());
	}

	@Bean
	ClientDetailsService wuYanClientDetailsService() {
		return new WuYanClientDetailsService();
	}

	@Bean
	AuthorizationCodeServices authorizationCodeServices() {
		return new InMemoryAuthorizationCodeServices();
	}

}
