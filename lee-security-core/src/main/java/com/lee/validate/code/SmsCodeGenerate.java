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
import java.util.concurrent.CountDownLatch;

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
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getValidCode().getSmsCodeProterties().getLength());
		return new ValidateCode(code, securityProperties.getValidCode().getSmsCodeProterties().getExpireIn());
	}

	/**
	 * 生成随机背景条纹
	 *
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
