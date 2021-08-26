package com.wuyan.admin.role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import wuyan.common.base.BaseEntity;

/**
 * <p>
 * 角色权限映射表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_permission")
@ApiModel(value = "SysRolePermission对象", description = "角色权限映射表")
public class SysRolePermission extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "权限id")
	private Long permissionId;

	@ApiModelProperty(value = "角色id")
	private Long roleId;


}
