package com.lee.properties;

/**
 * @program: springsecurity
 * @description: browserpro
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:56
 **/
public class BrowserProperties {
	private String loginPage="/lee-login.html";
	private LoginType loginType=LoginType.JSON;
	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		System.out.println(loginPage);
		this.loginPage = loginPage;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
}
