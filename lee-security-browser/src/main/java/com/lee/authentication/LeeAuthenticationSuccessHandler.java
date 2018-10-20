package com.lee.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lee.properties.LoginType;
import com.lee.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: lee-security
 * @description: authentication
 * @author: Jiliang.Lee
 * @create: 2018-10-20 09:34
 **/
@Component
public class LeeAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SecurityProperties securityProperties;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		log.info("login success.");
		if (LoginType.JSON.equals(securityProperties.browser.getLoginType())) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(objectMapper.writeValueAsString(authentication));
		} else {
			super.onAuthenticationSuccess(request,response,authentication);
		}
	}
}
