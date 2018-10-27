package com.lee.validate.code;

import com.lee.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-10-26 21:14
 **/
@Component
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidCode>{
	@Autowired
	private SmsCodeSender smsCodeSender;
	@Override
	public void send(ServletWebRequest request, ValidCode validCode) throws Exception {
		String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");//发送
		smsCodeSender.send(mobile, validCode.getCode());
	}
}
