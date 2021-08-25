package com.wuyan.admin.user.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyan.admin.user.entity.SysUser;
import com.wuyan.admin.user.vo.SysUserVo;

/**
 * <p>
 * 系统人员表 服务类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since v1
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 获取用户信息
	 *
	 * @param userId
	 * @return
	 */
	SysUserVo getUserInfo(Long userId);

	/**
	 * 分页数据
	 *
	 * @param userPage
	 * @return
	 */
	IPage<SysUser> getPageList(SysUserVo userPage);

	/**
	 * 通过账号查询人员数据
	 *
	 * @param account 账号
	 * @return
	 */
	SysUser getUserByAccount(String account);

	/**
	 * 删除
	 *
	 * @param sysUser
	 * @return
	 */
	Boolean delete(SysUser sysUser);

	/**
	 * 修改
	 *
	 * @param sysUser
	 * @return
	 */
	Boolean update(SysUser sysUser);

}
