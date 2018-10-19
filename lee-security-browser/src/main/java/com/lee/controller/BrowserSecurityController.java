package com.lee.controller;

import com.lee.properties.SecurityProperties;
import com.lee.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: springsecurity
 * @description: spring security class
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:25
 **/
@RestController
public class BrowserSecurityController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private RequestCache requestCache=new HttpSessionRequestCache();

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


	@Autowired
	private SecurityProperties securityProperties;


	/**
	 * 当需要认证时跳转到这里
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/authentication/require")
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest != null) {
			String target = savedRequest.getRedirectUrl();
			logger.info("引发跳转的请求是: "+ target);
			if (StringUtils.endsWithIgnoreCase(target, ".html")) {
				redirectStrategy.sendRedirect(request, response, securityProperties.browser.getLoginPage());
			}
		}
		return new SimpleResponse("访问的服务器需要身份认证,请引导用户到登录页.");
	}
}
