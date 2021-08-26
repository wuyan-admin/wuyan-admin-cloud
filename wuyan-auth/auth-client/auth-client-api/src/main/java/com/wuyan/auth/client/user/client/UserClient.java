package com.wuyan.auth.client.user.client;/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */


import com.wuyan.auth.client.user.dto.UserDTO;

/**
 * @author wuyan
 * @since v1
 */
public interface UserClient {
	/**
	 * 通过账号获取用户
	 *
	 * @param account
	 * @return
	 */
	UserDTO accountLogin(String account);
}
