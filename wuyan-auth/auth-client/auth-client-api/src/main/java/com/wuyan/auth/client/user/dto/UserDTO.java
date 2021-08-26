package com.wuyan.auth.client.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

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

	private String account;

	private String password;

	private List<String> authorities;

}
