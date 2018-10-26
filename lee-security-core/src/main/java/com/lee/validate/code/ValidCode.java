package com.lee.validate.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class ValidCode {
	private String code;
	private LocalDateTime expireTime;

	public ValidCode(String code,int expireIn){
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
}
