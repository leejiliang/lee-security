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
@NoArgsConstructor
@Getter
@Setter
public class ImageCode extends ValidCode {
	private BufferedImage image;

	public ImageCode(String code, LocalDateTime expireTime, BufferedImage image) {
		super(code, expireTime);
		this.image = image;
	}

	public ImageCode(String code, int expireTime, BufferedImage image) {
		super(code, expireTime);
		this.image = image;
	}
}
