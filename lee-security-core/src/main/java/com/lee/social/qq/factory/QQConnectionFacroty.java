package com.lee.social.qq.factory;

import com.lee.social.qq.adapter.QQAdapter;
import com.lee.social.qq.api.QQApi;
import com.lee.social.qq.provider.QQServiceProvider;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @program: lee-security
 * @description: 创建一个factory.参数通过配置文件补充完整.
 * @author: Jiliang.Lee
 * @create: 2018-11-15 20:35
 **/
public class QQConnectionFacroty extends OAuth2ConnectionFactory<QQApi> {

	public QQConnectionFacroty(String providerId, String appId,String appSecret) {
		super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
	}
}
