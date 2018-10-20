package com.lee.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lee.properties.LoginType;
import com.lee.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: lee-security
 * @description: failehandler
 * @author: Jiliang.Lee
 * @create: 2018-10-20 10:04
 **/
@Component
public class LeeAuthenticationFaileHandler extends SimpleUrlAuthenticationFailureHandler{
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		log.info("login faile.");
		if (LoginType.JSON.equals(securityProperties.browser.getLoginType())) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(objectMapper.writeValueAsString(exception));
		}else{
			super.onAuthenticationFailure(request, response, exception);
		}
	}
}
