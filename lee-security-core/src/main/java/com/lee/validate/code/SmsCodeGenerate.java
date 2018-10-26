package com.lee.validate.code;

import com.lee.properties.SecurityProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @program: lee-security
 * @description: dd
 * @author: Jiliang.Lee
 * @create: 2018-10-21 15:37
 **/
@Getter
@Setter
@Component
public class SmsCodeGenerate implements ValidateCodeGenerate {

	@Autowired
	private SecurityProperties securityProperties;
	@Override
	public ValidCode generate(ServletWebRequest request) {
		String random = RandomStringUtils.randomNumeric(securityProperties.getValidCode().getSmsCodeProterties().getLength());
		return new ValidCode(random, securityProperties.getValidCode().getSmsCodeProterties().getExpireIn());
	}
}
