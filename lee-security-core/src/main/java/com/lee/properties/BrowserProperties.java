package com.lee.properties;

/**
 * @program: springsecurity
 * @description: browserpro
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:56
 **/
public class BrowserProperties {
	private String loginPage="/lee-login.html";

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
}
