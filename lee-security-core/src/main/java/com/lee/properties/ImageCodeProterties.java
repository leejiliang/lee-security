package com.lee.properties;


import lombok.Getter;
import lombok.Setter;

/**
 * @program: lee-security
 * @description: properties
 * @author: Jiliang.Lee
 * @create: 2018-10-21 14:46
 **/
@Setter
@Getter
public class ImageCodeProterties {
	private int width=67;
	private int height=23;
	private int length=4;
	private int expireIn=60;
	private String url;
}
