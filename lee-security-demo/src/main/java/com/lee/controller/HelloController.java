package com.lee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: lee-security
 * @description:
 * @author: Jiliang.Lee
 * @create: 2018-12-10 13:46
 **/
@Controller
public class HelloController {
	@RequestMapping("/")
	public String hello() {
		return "index";
	}

}
