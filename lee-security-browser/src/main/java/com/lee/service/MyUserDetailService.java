package com.lee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: springsecurity
 * @description: userService
 * @author: Jiliang.Lee
 * @create: 2018-10-16 20:06
 **/
@Component
public class MyUserDetailService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

	@Autowired
	private PasswordEncoder passwordEncoder;//加密,匹配服务类
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//根据用户名查找用户信息
		log.info(username);
		log.info(passwordEncoder.encode("123456"));
		User user= new User(username,passwordEncoder.encode("123456"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		//包含其他认证信息
		User userDetails=new User(username,"123456", true, true,true,false,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		return user;
	}
}
