
package base;


import dto.UserDTO;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.core.base.BaseController
 * @description
 * @date 2020-03-23
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class BaseController {

	public BaseController() {
	}

	protected Long getUserId() {
		return 1L;
	}

	protected UserDTO getUser() {
		return UserDTO.builder().build();
	}

	protected String getUserName() {
		return "";
	}

}
