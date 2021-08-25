package com.wuyan.admin.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuyan.admin.permission.service.SysPermissionService;
import com.wuyan.admin.user.entity.SysUser;
import com.wuyan.admin.user.enums.DictEnum;
import com.wuyan.admin.user.mapper.SysUserMapper;
import com.wuyan.admin.user.service.SysUserRoleService;
import com.wuyan.admin.user.service.SysUserService;
import com.wuyan.admin.user.vo.SysUserVo;
import enums.AssertEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * <p>
 * 系统人员表 服务实现类
 * </p>
 *
 * @author wangguod194@163.com
 * @since v1
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private SysPermissionService sysPermissionService;

	private SysUserRoleService sysUserRoleService;

	@Override
	public SysUserVo getUserInfo(Long userId) {
		SysUser user = this.getById(userId);
		SysUserVo userVo = new SysUserVo();
		BeanUtils.copyProperties(user, userVo);
		userVo.setMenuList(sysPermissionService.getMenu(user));
		userVo.setPermissionList(sysPermissionService.getPermissionList(user));
		return userVo;
	}

	@Override
	public IPage<SysUser> getPageList(SysUserVo userPage) {
		IPage<SysUser> iPage = this.baseMapper.selectPage(userPage.toPage(), null);
		return iPage;
	}

	@Override
	public SysUser getUserByAccount(String account) {
		return this.baseMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getAccount, account).eq(SysUser::getStatus, DictEnum.VALID.getCode()));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean delete(SysUser sysUser) {
		Assert.notNull(sysUser.getId(), AssertEnum.NOT_NULL.getValue());
		this.removeById(sysUser.getId());
		return sysUserRoleService.deleteByUserId(sysUser.getId());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean update(SysUser sysUser) {
		SysUser version = this.getById(sysUser.getId());
		sysUser.setVersion(version.getVersion());
		return this.updateById(sysUser);
	}
}
