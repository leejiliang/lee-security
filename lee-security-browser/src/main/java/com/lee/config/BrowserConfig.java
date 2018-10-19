package com.lee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

	@Override
	protected void configure(HttpSecurity http) throws Exception {//表单登录(默认实现方式)
		http.csrf().disable()//关闭攻击防护
				.formLogin()//表单登录
				.loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
//		http.httpBasic()//内嵌验证,相当于在选择过滤器链路中选择相应的过滤器
				.and()
				.authorizeRequests()//对请求授权
				.antMatchers("/authentication/require","/regist.html").permitAll()
				.anyRequest()//任何请求
				.authenticated();//需要身份认证
	}
}