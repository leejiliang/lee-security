package com.lee.social.qq.config;

import com.lee.properties.QQProperties;
import com.lee.properties.SecurityProperties;
import com.lee.social.qq.factory.QQConnectionFacroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-26 20:17
 **/
@Configurable
@ConditionalOnProperty(prefix = "lee.security.social.qq",name = "app.id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		QQProperties qqProperties = securityProperties.getSocialProperties().getQqProperties();
		return new QQConnectionFacroty(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
	}
}
