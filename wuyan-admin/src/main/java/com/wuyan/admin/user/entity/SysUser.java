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
 * 系统人员表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since v1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "系统人员表")
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = -366169109826796775L;

	@ApiModelProperty(value = "主键,自增")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "账号")
	private String account;

	@ApiModelProperty(value = "密码")
	private String password;

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


}
