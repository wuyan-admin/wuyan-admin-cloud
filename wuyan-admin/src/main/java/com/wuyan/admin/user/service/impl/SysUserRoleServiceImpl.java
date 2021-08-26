package com.wuyan.admin.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuyan.admin.user.entity.SysUserRole;
import com.wuyan.admin.user.mapper.SysUserRoleMapper;
import com.wuyan.admin.user.service.SysUserRoleService;
import com.wuyan.admin.user.vo.SysUserRoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import wuyan.common.enums.AssertEnum;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色映射表 服务实现类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

	@Override
	public List<SysUserRoleVo> haveRole(Long userId) {
		Assert.notNull(userId, AssertEnum.NOT_NULL.getValue());
		List<SysUserRole> list = this.list(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, userId));
		return list.stream().map(item -> {
			SysUserRoleVo vo = new SysUserRoleVo();
			BeanUtils.copyProperties(item, vo);
			return vo;
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean addUserRole(List<SysUserRole> list) {
		Assert.isTrue(list.size() > 0, AssertEnum.NOT_NULL.getValue());
		Long userId = list.get(0).getUserId();
		Assert.notNull(userId, AssertEnum.NOT_NULL.getValue());
		this.baseMapper.delete(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, userId));
		list.forEach(item -> item.setUserId(userId));
		return this.saveBatch(list);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean deleteByUserId(Long userId) {
		return this.remove(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, userId));
	}
}
