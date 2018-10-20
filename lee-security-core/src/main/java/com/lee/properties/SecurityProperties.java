package com.lee.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springsecurity
 * @description: BrowerSer
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:54
 **/
@Component
@ConfigurationProperties(prefix = "lee.security")
public class SecurityProperties {
	public BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}
}
