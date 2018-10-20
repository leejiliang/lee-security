package com.lee.properties;

import com.sun.tools.javac.file.Locations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;

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
