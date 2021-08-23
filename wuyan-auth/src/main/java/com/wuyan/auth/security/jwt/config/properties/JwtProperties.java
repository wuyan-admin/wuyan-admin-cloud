/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security.jwt.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wuyan
 * @since v1
 */
@Getter
@Component
@ConfigurationProperties(prefix = "wuyan.jwt")
public class JwtProperties {
	/**
	 * 私钥路径 只支持classpath
	 */
	private String privateKeyPath = "jwt.jks";

	/**
	 * 密码
	 */
	private String password = "wuyan.admin";

	/**
	 * 别名
	 */
	private String alias = "jwt";
}
