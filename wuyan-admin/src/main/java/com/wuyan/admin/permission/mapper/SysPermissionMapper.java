package com.wuyan.admin.permission.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuyan.admin.permission.entity.SysPermission;
import com.wuyan.admin.role.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

	/**
	 * 通过角色查询权限
	 *
	 * @param roleList
	 * @return
	 */
	List<SysPermission> findPermission(List<SysRole> roleList);
}
