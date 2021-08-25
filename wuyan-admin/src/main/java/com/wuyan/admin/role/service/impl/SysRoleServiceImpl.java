package com.wuyan.admin.role.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuyan.admin.role.entity.SysRole;
import com.wuyan.admin.role.mapper.SysRoleMapper;
import com.wuyan.admin.role.service.SysRoleService;
import com.wuyan.admin.role.vo.SysRoleVo;
import com.wuyan.admin.user.entity.SysUserRole;
import com.wuyan.admin.user.service.SysUserRoleService;
import enums.AssertEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

	private final SysUserRoleService sysUserRoleService;

	@Override
	public List<SysRoleVo> all(SysRoleVo sysRoleVo) {
		return super.list().stream().map(SysRoleVo::create).collect(Collectors.toList());
	}

	@Override
	public IPage<SysRoleVo> pageList(SysRoleVo sysRoleVo) {
		IPage<SysRole> page = this.page(sysRoleVo.toPage(), Wrappers.<SysRole>lambdaQuery()
				.like(StrUtil.isNotBlank(sysRoleVo.getRoleName()),
						SysRole::getRoleName, sysRoleVo.getRoleName())
				.like(StrUtil.isNotBlank(sysRoleVo.getRoleCode()),
						SysRole::getRoleCode, sysRoleVo.getRoleCode())
				.eq(null != sysRoleVo.getStatus()
						, SysRole::getStatus, sysRoleVo.getStatus()));
		return page.convert(SysRoleVo::create);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean updateRole(SysRole sysRole) {
		Assert.notNull(sysRole.getId(), AssertEnum.NOT_NULL.getValue());
		SysRole version = this.getById(sysRole.getId());
		sysRole.setVersion(version.getVersion());
		return this.updateById(sysRole);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean deleteRole(SysRole sysRole) {
		Assert.notNull(sysRole.getId(), AssertEnum.NOT_NULL.getValue());
		this.removeById(sysRole.getId());
		return sysUserRoleService.remove(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getRoleId, sysRole.getId()));
	}
}
