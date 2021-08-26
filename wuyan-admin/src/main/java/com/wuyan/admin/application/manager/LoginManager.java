/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.admin.application.manager;

import com.wuyan.admin.application.dto.UserDto;
import com.wuyan.admin.permission.service.SysPermissionService;
import com.wuyan.admin.permission.vo.SysPermissionVo;
import com.wuyan.admin.role.service.SysRoleService;
import com.wuyan.admin.user.entity.SysUser;
import com.wuyan.admin.user.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuyan
 * @since v1
 */
@Component
@AllArgsConstructor
public class LoginManager {

	private final SysUserService sysUserService;

	private final SysPermissionService sysPermissionService;

	private final SysRoleService sysRoleService;

	public UserDto accountLogin(String account) {
		SysUser user = sysUserService.getUserByAccount(account);
		List<SysPermissionVo> permissionList = sysPermissionService.getPermissionList(user);
		return UserDto.builder().account(user.getAccount()).password(user.getPassword()).authorities(permissionList.stream().map(item -> item.getPermission()).collect(Collectors.toList())).build();
	}
}
