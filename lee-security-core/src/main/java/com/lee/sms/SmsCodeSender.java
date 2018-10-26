package com.lee.sms;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-26 19:51
 **/
public interface SmsCodeSender {
	void send(String mobile, String code);
}
