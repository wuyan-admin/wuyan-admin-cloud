package com.wuyan.admin.user.entity;

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
 * 用户角色映射表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since v1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel(value = "SysUserRole对象", description = "用户角色映射表")
public class SysUserRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "权限id")
	private Long userId;

	@ApiModelProperty(value = "角色id")
	private Long roleId;


}
