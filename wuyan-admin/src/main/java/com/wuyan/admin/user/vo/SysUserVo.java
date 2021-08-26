package com.wuyan.admin.user.vo;


import com.wuyan.admin.permission.vo.SysPermissionVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wuyan.common.base.BaseQuery;

import java.util.List;

/**
 * <p>
 * 系统人员表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysUserVo对象", description = "系统人员表")
public class SysUserVo extends BaseQuery {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键,自增")
	private Long id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "账号")
	private String account;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "手机号")
	private String mobilePhone;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "身份证")
	private String idCard;

	@ApiModelProperty(value = "是否管理员")
	private Boolean isAdmin;

	@ApiModelProperty(value = "状态,0失效,1有效")
	private String status;

	@ApiModelProperty(value = "菜单列表")
	private List<SysPermissionVo> menuList;

	@ApiModelProperty(value = "权限列表")
	private List<SysPermissionVo> permissionList;

}
