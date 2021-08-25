/*
 * Copyright (c) 2020, wangguodong194@163.com. All rights reserved.
 */

package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.business.system.user.enums.AssertTestEnum
 * @description
 * @date 2020-06-11
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Getter
@AllArgsConstructor
public enum AssertEnum {

	NOT_NULL("参数列表不能为空！"),
	EXISTS("该数据已存在,无法继续添加！");

	String value;
}
