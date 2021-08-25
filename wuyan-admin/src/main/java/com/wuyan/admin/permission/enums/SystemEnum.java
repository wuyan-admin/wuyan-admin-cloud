/*
 * Copyright (c) 2020, wangguodong194@163.com. All rights reserved.
 */

package com.wuyan.admin.permission.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.business.system.permission.enums.SystemEnum
 * @description
 * @date 2020-05-02
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Getter
@AllArgsConstructor
public enum SystemEnum {
	/**
	 * 菜单
	 */
	MENU("menu"),
	/**
	 * 操作
	 */
	ACTION("action");

	private String value;

}
