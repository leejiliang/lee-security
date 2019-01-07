package com.lee.config;

import com.lee.authentication.LeeLogoutSuccessHandler;
import com.lee.authentication.mobile.SmsCodeAuthenticationFilter;
import com.lee.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.lee.properties.SecurityProperties;
import com.lee.validate.code.SmsValidateCodeFilter;
import com.lee.validate.code.ValidateCodeFilter;
import com.sun.tools.corba.se.idl.constExpr.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @program: lee-security
 * @description: config
 * @author: Jiliang.Lee
 * @create: 2018-10-19 20:41
 **/
@Configuration
@EnableWebSecurity
public class BrowserConfig extends WebSecurityConfigurerAdapter {
	@Bean
	PasswordEncoder passwordEncoder() {//实现接口PasswordEncoder,用于加密用户注册的密码,登录时和用户输入的密码匹配.
		return new BCryptPasswordEncoder();
	}
	@Autowired

	private AuthenticationSuccessHandler leeAuthenticationSuccessHandler;

	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	@Autowired
	private AuthenticationFailureHandler leeAuthenticationFaileHandler;
	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private DataSource dataSource;

	@Autowired
	private LeeLogoutSuccessHandler leeLogoutSuccessHandler;

	@Autowired
	private SpringSocialConfigurer leeSocialSecurityConfig;
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(dataSource);
		return jdbcTokenRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {//表单登录(默认实现方式)
		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(leeAuthenticationFaileHandler);
		validateCodeFilter.setSecurityProperties(securityProperties);
		validateCodeFilter.afterPropertiesSet();

		SmsValidateCodeFilter smsValidateCodeFilter = new SmsValidateCodeFilter();
		smsValidateCodeFilter.setAuthenticationFailureHandler(leeAuthenticationFaileHandler);
		smsValidateCodeFilter.setSecurityProperties(securityProperties);
		smsValidateCodeFilter.afterPropertiesSet();


		http.addFilterBefore(smsValidateCodeFilter, UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
				.csrf().disable()//关闭攻击防护
				.formLogin()//表单登录
				.loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
				.successHandler(leeAuthenticationSuccessHandler)
				.failureHandler(leeAuthenticationFaileHandler)
				.and()
				.logout()
				.logoutUrl("/signout")
//				.logoutSuccessUrl("/logout.html")
				.logoutSuccessHandler(leeLogoutSuccessHandler)
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.browser.getRemeberMeSeconds())
				.userDetailsService(userDetailsService)
//		http.httpBasic()//内嵌验证,相当于在选择过滤器链路中选择相应的过滤器
				.and()
				.authorizeRequests()//对请求授权
				.antMatchers("/authentication/require", "/regist.html"
						, securityProperties.browser.getLoginPage(),"/auth/qq",
						"/code/*").permitAll()
				.anyRequest()//任何请求
				.authenticated()
				.and().apply(smsCodeAuthenticationSecurityConfig)
				.and().apply(leeSocialSecurityConfig);//需要身份认证

	}
}
