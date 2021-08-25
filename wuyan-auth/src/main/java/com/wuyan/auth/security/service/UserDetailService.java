/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author wuyan
 * @since v1
 */
public class UserDetailService implements UserDetailsService, UserDetailsPasswordService {

	/**
	 * 升级密码
	 *
	 * @param user
	 * @param newPassword
	 * @return
	 */
	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		return null;
	}

	/**
	 * 加载用户
	 *
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
