package com.wuyan.admin.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户角色映射表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Data
@ApiModel(value = "SysUserRoleVo对象", description = "用户角色映射表")
public class SysUserRoleVo {

	private Long id;

	@ApiModelProperty(value = "权限id")
	private Long userId;

	@ApiModelProperty(value = "角色id")
	private Long roleId;

}
