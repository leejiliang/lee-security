package com.lee.controller;

import com.lee.properties.SecurityProperties;
import com.lee.sms.SmsCodeSender;
import com.lee.validate.code.ImageCode;
import com.lee.validate.code.ValidCode;
import com.lee.validate.code.ValidateCodeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
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
	private ValidateCodeGenerate imageCodeGenerate ;

	@Autowired
	private SmsCodeSender smsCodeSender;
	/**
	 * 生成图形验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/code/image")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ImageCode imageCode = (ImageCode) imageCodeGenerate.generate(new ServletWebRequest(request));
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
		ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
	}

	/**
	 * 发送短信验证码
	 * @param request
	 * @throws IOException
	 */
	@GetMapping("/code/sms")
	public String createSmsCode(HttpServletRequest request) throws Exception{
		ValidCode validCode = imageCodeGenerate.generate(new ServletWebRequest(request));//生成
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, validCode);//保存进session
		//短信服务商发送到用户的手机
		String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");//发送
		smsCodeSender.send(mobile, validCode.getCode());
		return "发送成功.";
	}

}
