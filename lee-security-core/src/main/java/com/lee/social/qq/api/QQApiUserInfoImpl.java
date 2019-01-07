package com.lee.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-15 19:28
 **/
@Getter
@Setter
@Slf4j
public class QQApiUserInfoImpl extends AbstractOAuth2ApiBinding implements QQApi {

	private String appId;
	private String openId;

	private static final String URL_GET_OPEN_ID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	public static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	private ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public QQUserInfo getUserInfo() {
		String url = String.format(URL_GET_USERINFO, appId, openId);
		String result = getRestTemplate().getForObject(url, String.class);
		System.out.println(result);
		try {
			return objectMapper.readValue(result, QQUserInfo.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QQApiUserInfoImpl(String accessToken, String appId) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.appId = appId;
		String url = String.format(URL_GET_OPEN_ID, accessToken);
		String result = getRestTemplate().getForObject(url, String.class);
		System.out.println(result);
		this.openId = StringUtils.substringBetween(result, "\"openId\":", "}");
	}
}
