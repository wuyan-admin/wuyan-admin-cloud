package com.wuyan.admin.permission.vo;


import cn.hutool.core.bean.BeanUtil;
import com.wuyan.admin.permission.entity.SysPermission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wuyan.common.base.BaseQuery;

import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysPermissionVo对象", description = "角色表")
public class SysPermissionVo extends BaseQuery {

	private Long id;

	@ApiModelProperty(value = "权限名称")
	private String permissionName;

	@ApiModelProperty(value = "权限编码")
	private String permissionCode;

	@ApiModelProperty(value = "权限url")
	private String permissionUrl;

	@ApiModelProperty(value = "权限图标")
	private String permissionIcon;

	@ApiModelProperty(value = "父级id")
	private Long parentId;

	@ApiModelProperty(value = "权限,用于前台查询出权限后进行比对,主要是对按钮级进行控制")
	private String permission;

	@ApiModelProperty(value = "权限状态,0失效,1有效")
	private String status;

	@ApiModelProperty(value = "排序")
	private Integer displayOrder;

	@ApiModelProperty(value = "菜单类型,menu代表菜单action代表操作")
	private String permissionType;

	@ApiModelProperty(value = "组件")
	private String component;

	@ApiModelProperty(value = "重定向的路径")
	private String redirect;

	@ApiModelProperty(value = "子级菜单")
	private List<SysPermissionVo> children;


	public static SysPermissionVo create(SysPermission sysPermission) {
		SysPermissionVo vo = new SysPermissionVo();
		BeanUtil.copyProperties(sysPermission, vo);
		return vo;
	}
}
