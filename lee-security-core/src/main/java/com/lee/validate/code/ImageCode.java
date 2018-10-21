package com.lee.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @program: lee-security
 * @description: ImageCode
 * @author: Jiliang.Lee
 * @create: 2018-10-20 23:58
 **/
public class ImageCode extends ValidateCode {
	private BufferedImage image;
	private String code;
	private LocalDateTime expireTime;



	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code,expireIn);
		this.image = image;
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code,expireTime);
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
}
