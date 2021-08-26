/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.admin.user.controller;

import com.wuyan.admin.application.dto.UserDto;
import com.wuyan.admin.application.manager.LoginManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuyan
 * @since v1
 */
@Controller
@AllArgsConstructor
public class LoginController {

	private final LoginManager loginManager;

	@RequestMapping("/accountLogin")
	public UserDto accountLogin(String account) {
		return loginManager.accountLogin(account);
	}
}
