package com.wuyan.admin.role.vo;

import base.BaseQuery;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wuyan.admin.role.entity.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value = "SysRoleVo对象", description = "角色表")
public class SysRoleVo extends BaseQuery {

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

	public static SysRoleVo create(SysRole role) {
		SysRoleVo vo = new SysRoleVo();
		BeanUtil.copyProperties(role, vo);
		return vo;
	}
}
