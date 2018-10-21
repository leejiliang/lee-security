package com.lee.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @program: lee-security
 * @description: validateCodeException
 * @author: Jiliang.Lee
 * @create: 2018-10-21 00:37
 **/
public class ValidateCodeException extends AuthenticationException {
	public ValidateCodeException(String msg) {
		super(msg);
	}
}
