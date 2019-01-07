package com.lee.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public Authentication getUser(Authentication authentication) {
		return authentication;
	}

	@GetMapping("/me")
	public UserDetails getUser(@AuthenticationPrincipal UserDetails user) {
		return user;
	}



}
