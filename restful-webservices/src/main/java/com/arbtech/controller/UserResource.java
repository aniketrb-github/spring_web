package com.arbtech.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arbtech.model.User;
import com.arbtech.vo.UserVO;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public UserVO getAllUsers() {
		return new UserVO( Arrays.asList(new User("Ravan", 1, new Date()), new User("Ravan", 2, new Date())) );
	}
	
	@GetMapping(value = "/{userId}")
	public User getUser(@PathVariable int userId) {
		return new User("Ravan", userId, new Date());
	}
}
