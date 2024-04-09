package com.javatechie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.entity.UserInfo;
import com.javatechie.service.ProductService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ProductService service;

	@PostMapping("/createuser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

}
