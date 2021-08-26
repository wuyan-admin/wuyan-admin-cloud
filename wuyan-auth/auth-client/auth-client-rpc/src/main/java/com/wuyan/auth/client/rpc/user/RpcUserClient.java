/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.client.rpc.user;

import com.wuyan.auth.client.user.client.UserClient;
import com.wuyan.auth.client.user.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuyan
 * @since v1
 */
@FeignClient(value = "wuyan-admin")
public interface RpcUserClient extends UserClient {


	/**
	 * 账号登录
	 *
	 * @param account
	 * @return
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, value = "/system/user/getUserByAccount")
	UserDTO accountLogin(@RequestParam String account);
}
