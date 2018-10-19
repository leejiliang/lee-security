package com.lee.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @program: springsecurity
 * @description: BrowerSer
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:54
 **/
@ConfigurationProperties(prefix = "lee.security")
@Service
public class SecurityProperties {
	public BrowserProperties browser = new BrowserProperties();
}
