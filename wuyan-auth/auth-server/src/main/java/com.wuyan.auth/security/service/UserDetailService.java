/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security.service;

import com.wuyan.auth.client.user.client.UserClient;
import com.wuyan.auth.client.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.stream.Collectors;

/**
 * @author wuyan
 * @since v1
 */
@AllArgsConstructor
public class UserDetailService implements UserDetailsService, UserDetailsPasswordService {

	private UserClient userClient;

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
		UserDTO userDTO = userClient.accountLogin(username);
		return User
				.withUsername(userDTO.getAccount())
				.password(userDTO.getPassword())
				.authorities(userDTO.getAuthorities()
						.stream().map(item -> new SimpleGrantedAuthority(item))
						.collect(Collectors.toList()))
				.build();
	}
}
