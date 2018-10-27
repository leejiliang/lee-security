package com.lee.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: lee-security
 * @description: 校验码处理器, 封装不同校验码处理逻辑
 * @author: Jiliang.Lee
 * @create: 2018-10-26 20:37
 **/
public interface ValidateCodeProcessor {
	/**
	 * 验证码放入session中的key值
	 */
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";


	/**
	 * 生成验证码
	 * @param request
	 */
	void create(ServletWebRequest request) throws Exception;
}
