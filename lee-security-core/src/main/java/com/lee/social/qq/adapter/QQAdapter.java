package com.lee.social.qq.adapter;

import com.lee.social.qq.api.QQApi;
import com.lee.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @program: lee-security
 * @description: 适配器,将从授权服务器获取的信息设置到连接中,相当于一个转换器
 * @author: Jiliang.Lee
 * @create: 2018-11-15 20:23
 **/
public class QQAdapter implements ApiAdapter<QQApi> {
	@Override
	public boolean test(QQApi api) {
		return true;
	}

	@Override
	public void setConnectionValues(QQApi api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		values.setDisplayName(userInfo.getNickname());//昵称
		values.setImageUrl(userInfo.getFigureurl_1());//获取用户头像
		values.setProfileUrl(null);//社交系统.个人主页
		values.setProviderUserId(userInfo.getOpenId());
	}

	@Override
	public UserProfile fetchUserProfile(QQApi api) {//绑定解绑使用
		return null;
	}//绑定解绑可用

	@Override
	public void updateStatus(QQApi api, String message) {//社交状态,QQ不支持

	}
}
