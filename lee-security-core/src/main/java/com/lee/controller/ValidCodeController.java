package com.lee.controller;

import com.lee.properties.SecurityProperties;
import com.lee.validate.code.ImageCode;
import com.lee.validate.code.ImageCodeGenerate;
import com.lee.validate.code.ValidateCodeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: lee-security
 * @description: validCodeController
 * @author: Jiliang.Lee
 * @create: 2018-10-21 00:04
 **/
@RestController
public class ValidCodeController {

	public static final String SESSION_KEY = "SESSION_KEY_IMAGE-CODE";
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private ValidateCodeGenerate imageCodeGenerate ;
	@GetMapping("/code/image")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ImageCode imageCode = imageCodeGenerate.generate(new ServletWebRequest(request));
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
		ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
	}
}
