package com.wuyan.auth.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyan.auth.domain.entity.OauthClientDetails;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wuyan
 * @since v1
 */
public interface IOauthClientDetailsService extends IService<OauthClientDetails> {

	/**
	 * 通过 client id 获取详情
	 *
	 * @param clientId
	 * @return
	 */
	OauthClientDetails getByClientId(String clientId);
}
