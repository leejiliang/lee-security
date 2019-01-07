package com.lee.browser;

import com.lee.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-28 22:00
 **/
@Configuration
public class BrowserSecurityBeanConfig {
	@Autowired
	private SecurityProperties securityProperties;

}
