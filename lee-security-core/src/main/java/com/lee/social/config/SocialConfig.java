package com.lee.social.config;

import com.lee.properties.SecurityProperties;
import com.lee.properties.SocialProperties;
import com.lee.social.LeeSpringSocialConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-15 20:39
 **/
@Configuration
@EnableSocial//获取社交相关的信息
public class SocialConfig extends SocialConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SecurityProperties securityProperties;
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());//不加密
		jdbcUsersConnectionRepository.setTablePrefix("lee_");
		return jdbcUsersConnectionRepository;
	}

	@Bean
	public SpringSocialConfigurer leeSocialSecurityConfig() {
		SocialProperties socialProperties = securityProperties.getSocialProperties();
		LeeSpringSocialConfigurer leeSpringSocialConfigurer = new LeeSpringSocialConfigurer(socialProperties.getFilterProcessesUrl());
		return leeSpringSocialConfigurer;
	}

}
