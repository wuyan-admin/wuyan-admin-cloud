package com.wuyan.admin.role.controller;


import com.wuyan.admin.permission.service.SysPermissionService;
import com.wuyan.admin.permission.vo.SysPermissionVo;
import com.wuyan.admin.role.entity.SysRolePermission;
import com.wuyan.admin.role.service.SysRolePermissionService;
import com.wuyan.admin.role.vo.SysRoleVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色权限映射表 前端控制器
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@RestController
@RequestMapping("/system/rolePermission")
@AllArgsConstructor
public class SysRolePermissionController {

	private SysPermissionService sysPermissionService;

	private SysRolePermissionService sysRolePermissionService;

	/**
	 * 用于角色列表展示菜单标签
	 *
	 * @param sysRoleVo
	 * @return
	 */
	@PostMapping("/getTagPermissionByRoleId")
	public List<SysPermissionVo> getTagPermissionByRoleId(@RequestBody SysRoleVo sysRoleVo) {
		return sysPermissionService.getTagPermissionByRoleId(sysRoleVo.getId());
	}


	/**
	 * 通过角色id获取所有的菜单
	 *
	 * @param sysRoleVo
	 * @return
	 */
	@PostMapping("/getPermissionByRoleId")
	public List<SysPermissionVo> getPermissionByRoleId(@RequestBody SysRoleVo sysRoleVo) {
		return sysPermissionService.getPermissionByRoleId(sysRoleVo.getId());
	}

	/**
	 * 增加角色和权限映射
	 *
	 * @param sysRolePermissions
	 * @return
	 */
	@PostMapping("/addRolePermission")
	public Boolean addRolePermission(@RequestBody List<SysRolePermission> sysRolePermissions) {
		return sysRolePermissionService.addRolePermission(sysRolePermissions);
	}
}
