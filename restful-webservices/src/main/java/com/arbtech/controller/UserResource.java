package com.arbtech.controller;

import javax.validation.Valid;

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
	public ResponseEntity<?> getAllUsers() {
		UserVO userVO = userDaoService.getAllUsers();
		if (null != userVO && !userVO.getUsers().isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(userVO);
		else
			throw new UserNotFoundException("That's bizzare, No user's found in database!");
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getUser(@PathVariable int userId) {
		UserVO userVO = userDaoService.getUser(userId);
		if (null != userVO)
			return ResponseEntity.status(HttpStatus.OK).body(userVO);
		else
			throw new UserNotFoundException("userID: " + userId);
	}
	
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId) {
		Boolean isDeleted = userDaoService.deleteUser(userId);
		if (isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.value());
		else
			throw new UserNotFoundException("userID: " + userId);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody User p_user) {
		User user = userDaoService.createUser(p_user);
		if (null != user)
			return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED.value());
		else
			throw new UserNotFoundException(""+HttpStatus.EXPECTATION_FAILED);
	}
	
	@PutMapping(value = "/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody User p_user) {
		User user = userDaoService.updateUser(userId, p_user);
		if (null != user)
			return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.value());
		else
			throw new UserNotFoundException("userID: " + userId);
	}
}
