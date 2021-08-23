/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security.jwt.config;

import com.wuyan.auth.security.jwt.config.properties.JwtProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author wuyan
 * @since v1
 */
@Configuration
@AllArgsConstructor
public class AccessTokenConfig {

	private final JwtProperties jwtProperties;

	@Bean
	TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setKeyPair(keyPair());
		return jwtAccessTokenConverter;
	}

	@Bean
	KeyPair keyPair() {
		char[] password = jwtProperties.getPassword().toCharArray();
		KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource(jwtProperties.getPrivateKeyPath()), password);
		KeyPair keyPair = factory.getKeyPair(jwtProperties.getAlias(), password);
		return keyPair;
	}
}
