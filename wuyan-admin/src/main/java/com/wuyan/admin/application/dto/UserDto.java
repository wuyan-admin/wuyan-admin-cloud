/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.admin.application.dto;

import lombok.Builder;

import java.util.List;

/**
 * @author wuyan
 * @since v1
 */
@Builder
public class UserDto {

	private String account;

	private String password;

	private List<String> authorities;
}
