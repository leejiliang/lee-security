package com.lee.validate.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-26 21:11
 **/
@Component
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode>{
	@Override
	public void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}
}
