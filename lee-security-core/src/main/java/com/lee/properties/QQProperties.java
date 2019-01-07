package com.lee.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-11-26 20:12
 **/
@Getter
@Setter
public class QQProperties extends SocialProperties {
	private String providerId = "qq";
}
