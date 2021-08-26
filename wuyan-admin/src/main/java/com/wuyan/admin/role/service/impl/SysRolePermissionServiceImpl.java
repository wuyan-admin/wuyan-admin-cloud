package com.wuyan.admin.role.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuyan.admin.role.entity.SysRolePermission;
import com.wuyan.admin.role.mapper.SysRolePermissionMapper;
import com.wuyan.admin.role.service.SysRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import wuyan.common.enums.AssertEnum;

import java.util.List;

/**
 * <p>
 * 角色权限映射表 服务实现类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean deleteByPermissionId(Long permissionId) {
		return this.remove(Wrappers.<SysRolePermission>lambdaQuery().eq(SysRolePermission::getPermissionId, permissionId));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean addRolePermission(List<SysRolePermission> sysRolePermissions) {
		Assert.isTrue(sysRolePermissions.size() > 0, AssertEnum.NOT_NULL.getValue());
		Assert.notNull(sysRolePermissions.get(0).getRoleId(), AssertEnum.NOT_NULL.getValue());
		// 删除角色相关权限
		this.remove(Wrappers.<SysRolePermission>lambdaQuery().eq(SysRolePermission::getRoleId, sysRolePermissions.get(0).getRoleId()));
		// 添加角色和权限映射关系
		return this.saveBatch(sysRolePermissions);
	}
}
