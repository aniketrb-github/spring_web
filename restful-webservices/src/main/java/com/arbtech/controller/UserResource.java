package com.arbtech.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arbtech.exception.UserNotFoundException;
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
		UserVO userVO = userDaoService.getUser(userId);
		if (null != userVO)
			return userVO;
		else
			throw new UserNotFoundException("userID: " + userId);
	}
	
	@DeleteMapping(value = "/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return userDaoService.deleteUser(userId);
	}
	
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody User p_user) {

		User user = userDaoService.createUser(p_user);

		//
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody User p_user) {
		userDaoService.updateUser(userId, p_user);
		return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.value());
	}
}
