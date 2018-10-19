package com.lee.controller;

import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: lee-security
 * @description: com.lee.controller
 * @author: Jiliang.Lee
 * @create: 2018-10-19 20:27
 **/
@RestController
public class UserController {
	@Autowired
	private UserService userService;

}
