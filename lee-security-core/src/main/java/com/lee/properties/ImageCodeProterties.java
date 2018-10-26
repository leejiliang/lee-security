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
public class ImageCodeProterties extends SmsCodeProterties{
	private int width=67;
	private int height=23;

	public ImageCodeProterties() {
		this.setLength(6);
	}

}
