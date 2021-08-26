package com.wuyan.admin.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wuyan.admin.user.entity.SysUser;
import com.wuyan.admin.user.service.SysUserService;
import com.wuyan.admin.user.vo.SysUserVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统人员表 前端控制器
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-03-25
 */
@RestController
@RequestMapping("/system/user")
@AllArgsConstructor
public class SysUserController {

	private SysUserService sysUserService;

	/**
	 * 分页
	 *
	 * @param userPage
	 * @return
	 */
	@PostMapping("/pageList")
	public IPage<SysUser> list(@RequestBody SysUserVo userPage) {
		return sysUserService.getPageList(userPage);
	}

	/**
	 * 获取用户信息
	 *
	 * @return
	 */
	@PostMapping("/getUserInfo")
	public SysUserVo getUserInfo() {
		// TODO 获取当前用户信息
		return sysUserService.getUserInfo(1L);
	}

	@PostMapping("/getOne")
	public SysUser getOne(@RequestBody SysUser sysUser) {
		return sysUserService.getById(sysUser.getId());
	}

	@PostMapping("/add")
	public Boolean add(@RequestBody SysUser sysUser) {
		// todo 先默认密码
		sysUser.setPassword("$2a$10$D2Rm1PlIDmtabFtR/yumYezXkzCUl3VljsCrgMniJvWBz9zQd44U6");
		return sysUserService.save(sysUser);
	}


	@PostMapping("/remove")
	public Boolean delete(@RequestBody SysUser sysUser) {
		return sysUserService.delete(sysUser);
	}


	@PostMapping("/edit")
	public Boolean update(@RequestBody SysUser sysUser) {
		return sysUserService.update(sysUser);
	}

	@PostMapping("/getUserByAccount")
	public SysUser getUserByAccount(String account) {
		return sysUserService.getUserByAccount(account);
	}

}
