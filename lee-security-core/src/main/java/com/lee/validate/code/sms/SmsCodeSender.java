package com.lee.validate.code.sms;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-21 19:28
 **/
public interface SmsCodeSender {
	void send(String mobile, String code);
}
