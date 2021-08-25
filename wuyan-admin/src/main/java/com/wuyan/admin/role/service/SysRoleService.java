package com.wuyan.admin.role.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyan.admin.role.entity.SysRole;
import com.wuyan.admin.role.vo.SysRoleVo;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
public interface SysRoleService extends IService<SysRole> {

	/**
	 * 列表
	 *
	 * @param sysRoleVo
	 * @return
	 */
	List<SysRoleVo> all(SysRoleVo sysRoleVo);

	/**
	 * 分页
	 *
	 * @param sysRoleVo
	 * @return
	 */
	IPage<SysRoleVo> pageList(SysRoleVo sysRoleVo);

	/**
	 * 更新
	 *
	 * @param sysRole
	 * @return
	 */
	Boolean updateRole(SysRole sysRole);

	/**
	 * 删除
	 *
	 * @param sysRole
	 * @return
	 */
	Boolean deleteRole(SysRole sysRole);
}
