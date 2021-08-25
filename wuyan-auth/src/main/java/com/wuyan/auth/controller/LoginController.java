/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wuyan
 * @since v1
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(HttpServletResponse httpServletResponse) {
		return "login";
	}
}
