package com.lee.social.qq.provider;

import com.lee.social.qq.api.QQApi;
import com.lee.social.qq.api.QQApiUserInfoImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-15 20:08
 **/
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQApi>{
	private static final String URL_AUTHORIZE="https://graph.qq.com/oauth2.0/authorize";
	private static final String URL_TOKEN="https://graph.qq.com/oauth2.0/token";

	String appid;
	@Override
	public QQApi getApi(String accessToken) {
		return new QQApiUserInfoImpl(accessToken,appid);
	}

	public QQServiceProvider(String appid,String appSecret) {
		super(new OAuth2Template(appid,appSecret,URL_AUTHORIZE,URL_TOKEN));
	}
}
