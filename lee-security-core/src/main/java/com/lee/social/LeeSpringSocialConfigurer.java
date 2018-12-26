package com.lee.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-27 20:01
 **/
public class LeeSpringSocialConfigurer extends SpringSocialConfigurer {
	private String filterProcessUrl;

	public LeeSpringSocialConfigurer(String filterProcessUrl) {
		this.filterProcessUrl = filterProcessUrl;
	}
	@Override
	protected <T> T postProcess(T object) {
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
		filter.setFilterProcessesUrl(filterProcessUrl);
		return (T) filter;
	}
}
