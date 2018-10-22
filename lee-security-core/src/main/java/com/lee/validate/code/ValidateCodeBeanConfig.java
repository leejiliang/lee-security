package com.lee.validate.code;

import com.lee.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-21 15:40
 **/
@Configuration
public class ValidateCodeBeanConfig {
	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean(name="imageCodeGenerate")
	public ValidateCodeGenerate imageCodeGenerate() {
		ImageCodeGenerate codeGenerate = new ImageCodeGenerate();
		codeGenerate.setSecurityProperties(securityProperties);
		return codeGenerate;
	}
}
