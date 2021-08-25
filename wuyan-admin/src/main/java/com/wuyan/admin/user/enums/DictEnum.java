/*
 * Copyright (c) 2020, wangguodong194@163.com. All rights reserved.
 */

package com.wuyan.admin.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.business.system.user.enums.DictEnums
 * @description 字典枚举类
 * @date v1
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@AllArgsConstructor
@Getter
public enum DictEnum {
	/**
	 * 有效
	 */
	VALID(1, "是"),
	/**
	 * 无效
	 */
	INVALID(0, "否"),
	/**
	 * 男
	 */
	MAN(0, "男"),
	/**
	 * 女
	 */
	WOMAN(1, "女");

	private Integer code;
	private String value;
}
