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
 * 角色表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role")
@ApiModel(value = "SysRole对象", description = "角色表")
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = -3254188675827301005L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "角色名称")
	private String roleName;

	@ApiModelProperty(value = "角色编码")
	private String roleCode;

	@ApiModelProperty(value = "角色状态,0失效,1有效")
	private String status;

	@ApiModelProperty(value = "排序")
	private Integer displayOrder;
}
