package com.lee.validate.code;

import com.lee.properties.SecurityProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: lee-security
 * @description: validateCodeIController
 * @author: Jiliang.Lee
 * @create: 2018-10-21 00:30
 **/
@Getter
@Setter
public class SmsValidateCodeFilter extends OncePerRequestFilter {
	Logger log = LoggerFactory.getLogger(getClass());
	private AuthenticationFailureHandler authenticationFailureHandler;
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	private SecurityProperties securityProperties;
	private Set<String> urls = new HashSet<>();
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	@Override
	public void afterPropertiesSet() throws ServletException {
		super.afterPropertiesSet();
		String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getValidCode().getSmsCodeProterties().getUrl(), ",");
		if (configUrls != null && configUrls.length > 0) {
			urls.addAll(Arrays.asList(configUrls));
		}
		urls.add("/authentication/mobile");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		boolean present = urls.stream().filter(item -> antPathMatcher.match(item, request.getRequestURI())).findAny().isPresent();
		if (present) {
			try {
				validate(new ServletWebRequest(request));
			} catch (ValidateCodeException e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return;
			}
		}
		filterChain.doFilter(request, response);
	}

	private void validate(ServletWebRequest servletWebRequest)throws ServletRequestBindingException{
		ValidCode codeInSession = (ValidCode) sessionStrategy.getAttribute(servletWebRequest, AbstractValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
		String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "smsCode");
		if (StringUtils.isBlank(codeInRequest)) {
			throw new ValidateCodeException("验证码的值不能为空.");
		}
		if (codeInSession == null) {
			throw new ValidateCodeException("验证码不存在");
		}
		if (!codeInSession.getCode().equals(codeInRequest)) {
			log.info("codeInRequest:"+codeInRequest);
			log.info("codeInSession:"+codeInSession.getCode());
			throw new ValidateCodeException("验证码不匹配");
		}
		sessionStrategy.removeAttribute(servletWebRequest,AbstractValidateCodeProcessor.SESSION_KEY_PREFIX+"SMS");
	}
}
