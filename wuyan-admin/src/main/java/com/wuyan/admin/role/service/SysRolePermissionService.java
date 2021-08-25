package com.wuyan.admin.role.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyan.admin.role.entity.SysRolePermission;

import java.util.List;

/**
 * <p>
 * 角色权限映射表 服务类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {

	/**
	 * 根据菜单删除
	 *
	 * @param permissionId
	 * @return
	 */
	Boolean deleteByPermissionId(Long permissionId);


	/**
	 * 增加角色和人员关系
	 *
	 * @param sysRolePermissions
	 * @return
	 */
	Boolean addRolePermission(List<SysRolePermission> sysRolePermissions);
}
