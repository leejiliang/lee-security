package com.lee.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-26 20:14
 **/
@Getter
@Setter
public class SocialProperties {
	private QQProperties qqProperties = new QQProperties();
	private String filterProcessesUrl = "/auth";
}
