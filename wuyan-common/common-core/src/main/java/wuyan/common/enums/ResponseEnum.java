

package wuyan.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.core.enums.ResponseEnum
 * @description
 * @date 2020-03-23
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

	SUCCESS(1, "请求成功"),

	FAIL(0, "系统内部异常"),

	PASSWORD_NOT_FOUND(2, "未查询到系统默认密码"),

	PASSWORD_IS_NULL(3, "密码不能为空"),

	SYSTEM_SERVICE_ERROR(503, "系统服务错误，请稍后再试!");


	private int code;
	private String msg;

}


