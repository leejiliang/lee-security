package com.lee.sms;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-26 19:52
 **/
public class SmsCodeSenderImpl implements SmsCodeSender{
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机:" + mobile + "发送验证码:" + code);
	}
}
