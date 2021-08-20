/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.application;

import com.wuyan.auth.domain.entity.OauthClientDetails;
import com.wuyan.auth.domain.service.impl.OauthClientDetailsServiceImpl;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

/**
 * @author wuyan
 * @since v1
 */
public class WuYanClientDetailsService extends OauthClientDetailsServiceImpl implements ClientDetailsService {
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClientDetails clientDetails = this.getByClientId(clientId);
		BaseClientDetails baseClientDetails = new BaseClientDetails(clientDetails.getClientId(), clientDetails.getResourceIds(), clientDetails.getScope(), clientDetails.getAuthorizedGrantTypes(), clientDetails.getAuthorities(), clientDetails.getWebServerRedirectUri());
		return baseClientDetails;
	}
}
