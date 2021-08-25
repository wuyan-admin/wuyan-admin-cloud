/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.wuyan.auth.security.service;

import com.wuyan.auth.domain.entity.OauthClientDetails;
import com.wuyan.auth.domain.service.impl.OauthClientDetailsServiceImpl;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.Arrays;

/**
 * @author wuyan
 * @since v1
 */
public class WuYanClientDetailsService extends OauthClientDetailsServiceImpl implements ClientDetailsService {
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClientDetails clientDetails = this.getByClientId(clientId);
		BaseClientDetails baseClientDetails = new BaseClientDetails(clientDetails.getClientId(), clientDetails.getResourceIds(), clientDetails.getScope(), clientDetails.getAuthorizedGrantTypes(), clientDetails.getAuthorities(), clientDetails.getWebServerRedirectUri());
		baseClientDetails.setClientSecret(clientDetails.getClientSecret());
		baseClientDetails.setAutoApproveScopes(Arrays.asList(clientDetails.getAutoapprove()));
		return baseClientDetails;
	}
}
