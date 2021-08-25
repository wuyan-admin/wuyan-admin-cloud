package com.wuyan.admin.role.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wuyan.admin.role.entity.SysRole;
import com.wuyan.admin.role.service.SysRoleService;
import com.wuyan.admin.role.vo.SysRoleVo;
import com.wuyan.admin.user.entity.SysUserRole;
import com.wuyan.admin.user.service.SysUserRoleService;
import com.wuyan.admin.user.vo.SysUserRoleVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@RestController
@AllArgsConstructor
@RequestMapping("/system/role")
public class SysRoleController {

	private final SysRoleService sysRoleService;

	private final SysUserRoleService sysUserRoleService;

	/**
	 * 分页
	 *
	 * @param sysRoleVo
	 * @return
	 */
	@PostMapping("/pageList")
	public IPage<SysRoleVo> pageList(@RequestBody SysRoleVo sysRoleVo) {
		return sysRoleService.pageList(sysRoleVo);
	}

	/**
	 * 用于人员赋权时穿梭框数据
	 *
	 * @param sysRoleVo
	 * @return
	 */
	@PostMapping("/list")
	public List<SysRoleVo> list(@RequestBody SysRoleVo sysRoleVo) {
		return sysRoleService.all(sysRoleVo);
	}

	/**
	 * 查询当前人员拥有的角色 用于穿梭框
	 *
	 * @return
	 */
	@PostMapping("/haveRole")
	public List<SysUserRoleVo> haveRole(@RequestBody SysUserRoleVo sysUserRoleVo) {
		return sysUserRoleService.haveRole(sysUserRoleVo.getUserId());
	}

	/**
	 * 添加人员和角色映射关系
	 *
	 * @param userRole
	 * @return
	 */
	@PostMapping("/addUserRole")
	public Boolean addUserRole(@RequestBody List<SysUserRole> userRole) {
		return sysUserRoleService.addUserRole(userRole);
	}

	@PostMapping("/getOne")
	public SysRole getOne(@RequestBody SysRole sysRole) {
		return sysRoleService.getById(sysRole.getId());
	}

	@PostMapping("/addRole")
	public Boolean addRole(@RequestBody SysRole sysRole) {
		return sysRoleService.save(sysRole);
	}

	@PostMapping("/updateRole")
	public Boolean updateRole(@RequestBody SysRole sysRole) {
		return sysRoleService.updateRole(sysRole);
	}

	@PostMapping("/deleteRole")
	public Boolean deleteRole(@RequestBody SysRole sysRole) {
		return sysRoleService.deleteRole(sysRole);
	}
}
