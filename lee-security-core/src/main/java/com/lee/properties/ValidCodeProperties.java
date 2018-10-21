package com.lee.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: lee-security
 * @description: properties
 * @author: Jiliang.Lee
 * @create: 2018-10-21 14:51
 **/
@Getter
@Setter
public class ValidCodeProperties {
	private ImageCodeProterties imageCodeProterties = new ImageCodeProterties();
	private SmsCodeProterties smsCodeProterties = new SmsCodeProterties();

}
