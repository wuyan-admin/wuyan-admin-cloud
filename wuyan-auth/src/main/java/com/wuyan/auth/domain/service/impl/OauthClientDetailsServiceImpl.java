package com.wuyan.auth.domain.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuyan.auth.domain.entity.OauthClientDetails;
import com.wuyan.auth.domain.mapper.OauthClientDetailsMapper;
import com.wuyan.auth.domain.service.IOauthClientDetailsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wuyan
 * @since v1
 */
@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements IOauthClientDetailsService {

	@Override
	public OauthClientDetails getByClientId(String clientId) {
		return this.getOne(Wrappers.<OauthClientDetails>lambdaQuery().eq(OauthClientDetails::getClientId, clientId));
	}
}
