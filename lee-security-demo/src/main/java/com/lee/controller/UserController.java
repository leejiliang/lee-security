package com.lee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: lee-security
 * @description: usercontroller
 * @author: Jiliang.Lee
 * @create: 2018-10-19 21:18
 **/
@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public String getUser() {
		return "success";
	}

}
