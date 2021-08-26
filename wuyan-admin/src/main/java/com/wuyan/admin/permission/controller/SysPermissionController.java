package com.wuyan.admin.permission.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wuyan.admin.permission.entity.SysPermission;
import com.wuyan.admin.permission.service.SysPermissionService;
import com.wuyan.admin.permission.vo.SysPermissionVo;
import com.wuyan.admin.permission.vo.TreeNode;
import com.wuyan.admin.user.entity.SysUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wuyan.common.base.BaseController;

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
@RequestMapping("/system/permission")
public class SysPermissionController extends BaseController {

	private SysPermissionService sysPermissionService;

	/**
	 * 获取菜单列表
	 *
	 * @return
	 */
	@PostMapping("/getMenu")
	public List<SysPermissionVo> getMenu() {
//		TODO 待修改 需要获取当前用户
		return sysPermissionService.getMenu(new SysUser());
	}

	/**
	 * 分页
	 *
	 * @param vo
	 * @return
	 */
	@PostMapping("/pageList")
	public IPage<SysPermissionVo> list(@RequestBody SysPermissionVo vo) {
		return sysPermissionService.getPageList(vo);
	}

	/**
	 * 获取单条信息
	 *
	 * @param permission
	 * @return
	 */
	@PostMapping("/getOneById")
	public SysPermission getOneById(@RequestBody SysPermission permission) {
		return sysPermissionService.getById(permission.getId());
	}


	/**
	 * 菜单树
	 *
	 * @return
	 */
	@PostMapping("/treeList")
	public List<TreeNode> treeList() {
		//		TODO 待修改 需要获取当前用户
		return sysPermissionService.treeList(new SysUser());
	}

	@PostMapping("/add")
	public Boolean add(@RequestBody SysPermission permission) {
		return sysPermissionService.save(permission);
	}

	@PostMapping("/update")
	public Boolean update(@RequestBody SysPermission permission) {
		return sysPermissionService.update(permission);
	}

	@PostMapping("/delete")
	public Boolean delete(@RequestBody SysPermission sysPermission) {
		return sysPermissionService.delete(sysPermission);
	}

}
