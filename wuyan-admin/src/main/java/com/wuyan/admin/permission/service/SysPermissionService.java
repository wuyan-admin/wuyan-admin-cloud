package com.wuyan.admin.permission.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyan.admin.permission.entity.SysPermission;
import com.wuyan.admin.permission.vo.SysPermissionVo;
import com.wuyan.admin.permission.vo.TreeNode;
import com.wuyan.admin.user.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
public interface SysPermissionService extends IService<SysPermission> {
	/**
	 * 获取用户下的所有的菜单
	 *
	 * @param sysUser
	 * @return
	 */
	List<SysPermissionVo> getMenu(SysUser sysUser);

	/**
	 * 获取用户下的权限集合
	 *
	 * @param sysUser
	 * @return
	 */
	List<SysPermissionVo> getPermissionList(SysUser sysUser);

	/**
	 * 获取分页菜单
	 *
	 * @param vo
	 * @return
	 */
	IPage<SysPermissionVo> getPageList(SysPermissionVo vo);

	/**
	 * 菜单树集合
	 *
	 * @param sysUser
	 * @return
	 */
	List<TreeNode> treeList(SysUser sysUser);

	/**
	 * 更新菜单
	 *
	 * @param sysPermission
	 * @return
	 */
	Boolean update(SysPermission sysPermission);

	/**
	 * 删除菜单
	 *
	 * @param sysPermission
	 * @return
	 */
	Boolean delete(SysPermission sysPermission);

	/**
	 * 通过角色id获取菜单
	 *
	 * @param roleId
	 * @return
	 */
	List<SysPermissionVo> getPermissionByRoleId(Long roleId);

	/**
	 * 通过角色id获取菜单标签,用于角色列表展示
	 *
	 * @param roleId
	 * @return
	 */
	List<SysPermissionVo> getTagPermissionByRoleId(Long roleId);
}
