package com.lee.code;

import com.lee.validate.code.ImageCode;
import com.lee.validate.code.ValidateCodeGenerate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-21 16:05
 **/
//@Component("imageCodeGenerate")
public class DemoImageCodeGenerate implements ValidateCodeGenerate {
	@Override
	public ImageCode generate(ServletWebRequest request) {
		System.out.println("更高级的图样");
		return null;
	}
}
