package com.wuyan.admin.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyan.admin.user.entity.SysUserRole;
import com.wuyan.admin.user.vo.SysUserRoleVo;

import java.util.List;

/**
 * <p>
 * 用户角色映射表 服务类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since v1
 */
public interface SysUserRoleService extends IService<SysUserRole> {
	/**
	 * 查看用户拥有的角色
	 *
	 * @param userId
	 * @return
	 */
	List<SysUserRoleVo> haveRole(Long userId);

	/**
	 * 给用户添加权限
	 *
	 * @param list
	 * @return
	 */
	Boolean addUserRole(List<SysUserRole> list);

	/**
	 * 根据用户id删除
	 *
	 * @param userId
	 * @return
	 */
	Boolean deleteByUserId(Long userId);
}
