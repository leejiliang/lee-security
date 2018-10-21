package com.lee.validate.code.sms;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-21 19:28
 **/
public class DefaultSmsCodeSender implements SmsCodeSender {
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile +"发送短信验证码."+code);
	}
}
