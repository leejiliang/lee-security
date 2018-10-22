package com.lee.config;

import com.lee.properties.SecurityProperties;
import com.lee.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

import javax.sql.DataSource;

/**
 * @program: lee-security
 * @description: cofnig
 * @author: Jiliang.Lee
 * @create: 2018-10-19 20:41
 **/
@Configuration
public class BrowserConfig extends WebSecurityConfigurerAdapter {
	@Bean
	PasswordEncoder passwordEncoder() {//实现接口PasswordEncoder,用于加密用户注册的密码,登录时和用户输入的密码匹配.
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private AuthenticationSuccessHandler leeAuthenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler leeAuthenticationFaileHandler;
	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private DataSource dataSource;
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(dataSource);
//		jdbcTokenRepository.setCreateTableOnStartup(true);
		return jdbcTokenRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {//表单登录(默认实现方式)
		ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
		validateCodeFilter.setAuthenticationFailureHandler(leeAuthenticationFaileHandler);
		validateCodeFilter.setSecurityProperties(securityProperties);
		validateCodeFilter.afterPropertiesSet();

		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
				.csrf().disable()//关闭攻击防护
				.formLogin()//表单登录
				.loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
				.successHandler(leeAuthenticationSuccessHandler)
				.failureHandler(leeAuthenticationFaileHandler)
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.browser.getRemeberMeSeconds())
				.userDetailsService(userDetailsService)
//		http.httpBasic()//内嵌验证,相当于在选择过滤器链路中选择相应的过滤器
				.and()
				.authorizeRequests()//对请求授权
				.antMatchers("/authentication/require","/regist.html"
						,securityProperties.browser.getLoginPage(),
						"/code/image").permitAll()
				.anyRequest()//任何请求
				.authenticated();//需要身份认证
	}
}
