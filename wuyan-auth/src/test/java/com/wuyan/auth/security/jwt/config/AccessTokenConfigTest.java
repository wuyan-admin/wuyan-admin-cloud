package com.wuyan.auth.security.jwt.config;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessTokenConfigTest {


	/**
	 * 获取相对路径
	 */
	@Test
	public void getRelativePrivateKeyFile() {
		ClassPathResource classPathResource = new ClassPathResource("jwt.jks");
		assertEquals(classPathResource.exists(), true);
	}
}