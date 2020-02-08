package com.arbtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arbtech.model.User;
import com.arbtech.service.IUserDaoService;
import com.arbtech.vo.UserVO;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
	
	@Autowired
	private IUserDaoService userDaoService;

	@RequestMapping(method = RequestMethod.GET)
	public UserVO getAllUsers() {
		return userDaoService.getAllUsers();
	}
	
	@GetMapping(value = "/{userId}")
	public UserVO getUser(@PathVariable int userId) {
		return userDaoService.getUser(userId);
	}
	
	@DeleteMapping(value = "/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return userDaoService.deleteUser(userId);
	}
	
	@PostMapping
	public String createUser(@RequestBody User p_user) {
		return userDaoService.createUser(p_user);
	}
	
	@PutMapping(value = "/{userId}")
	public String updateUser(@PathVariable int userId, @RequestBody User p_user) {
		return userDaoService.updateUser(userId, p_user);
	}
}
