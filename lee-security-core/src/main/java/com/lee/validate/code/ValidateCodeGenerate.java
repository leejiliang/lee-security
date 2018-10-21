package com.lee.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: lee-security
 * @description: 验证码生成逻辑
 * @author: Jiliang.Lee
 * @create: 2018-10-21 15:35
 **/
public interface ValidateCodeGenerate {
	ImageCode generate(ServletWebRequest request);
}
