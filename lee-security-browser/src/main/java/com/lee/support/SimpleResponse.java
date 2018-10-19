package com.lee.support;

/**
 * @program: springsecurity
 * @description: 简单的返回支持
 * @author: Jiliang.Lee
 * @create: 2018-10-17 23:43
 **/
public class SimpleResponse {
	public SimpleResponse(Object content) {
		this.content=content;
	}
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
