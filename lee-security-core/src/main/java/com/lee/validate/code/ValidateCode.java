package com.lee.validate.code;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @program: lee-security
 * @description: ImageCode
 * @author: Jiliang.Lee
 * @create: 2018-10-20 23:58
 **/
@Getter
@Setter
public class ValidateCode {
	private String code;
	private LocalDateTime expireTime;
	public ValidateCode(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	public ValidateCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}
}
