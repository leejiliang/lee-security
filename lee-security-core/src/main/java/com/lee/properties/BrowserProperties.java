package com.lee.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: springsecurity
 * @description: browserpro
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:56
 **/
@Getter
@Setter
public class BrowserProperties {
	private String loginPage="/lee-login.html";
	private LoginType loginType=LoginType.JSON;
	private int remeberMeSeconds=3600;
}
