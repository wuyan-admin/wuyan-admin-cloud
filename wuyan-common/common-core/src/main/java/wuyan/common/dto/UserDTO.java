package wuyan.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-03-25
 */
@Data
@Builder
public class UserDTO {


	private Long id;

	private String name;

	@ApiModelProperty(value = "是否管理员")
	private Boolean isAdmin;
}
