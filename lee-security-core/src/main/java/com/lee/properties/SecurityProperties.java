package com.lee.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springsecurity
 * @description: BrowerSer
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:54
 **/

@ConfigurationProperties(prefix = "lee.security")
@Getter
@Setter
@Component
public class SecurityProperties {
	public BrowserProperties browser = new BrowserProperties();
	private ValidCodeProperties validCode = new ValidCodeProperties();
	private SocialProperties socialProperties = new SocialProperties();
}
