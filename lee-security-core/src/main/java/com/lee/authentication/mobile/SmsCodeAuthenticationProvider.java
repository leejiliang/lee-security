package com.lee.authentication.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-28 14:11
 **/
public class SmsCodeAuthenticationProvider implements AuthenticationProvider{

	private UserDetailsService userDetailService;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SmsCodeAuthenticationToken smsCodeAuthenticationToken=(SmsCodeAuthenticationToken) authentication;
		log.info("mobile:  "+(String) smsCodeAuthenticationToken.getPrincipal());
		UserDetails userDetails = userDetailService.loadUserByUsername((String) smsCodeAuthenticationToken.getPrincipal());
		if (userDetails == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		SmsCodeAuthenticationToken authenticationToken = new SmsCodeAuthenticationToken(userDetails, userDetails.getAuthorities());
		authenticationToken.setDetails(authenticationToken.getDetails());
		return authenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
	}

	public UserDetailsService getUserDetailService() {
		return userDetailService;
	}

	public void setUserDetailService(UserDetailsService userDetailService) {
		this.userDetailService = userDetailService;
	}
}
