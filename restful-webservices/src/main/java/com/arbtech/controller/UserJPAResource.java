package com.arbtech.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import com.arbtech.dao.IPostRepository;
import com.arbtech.dao.IUserRepository;
import com.arbtech.exception.UserNotFoundException;
import com.arbtech.model.Post;
import com.arbtech.model.User;
import com.arbtech.vo.PostVO;
import com.arbtech.vo.UserVO;

@RestController
@RequestMapping(path = "/jpa/users")
public class UserJPAResource {

	@Autowired
	private IUserRepository userJPARepository;
	
	@Autowired
	private IPostRepository postJPARepository;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		List<User> users = userJPARepository.findAll();

		if (null != users && !users.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(new UserVO(users));
		else
			throw new UserNotFoundException("That's bizzare, No user's found in database!");
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getUser(@PathVariable int userId) {
		Optional<User> user = userJPARepository.findById(userId);
		if (user.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(new UserVO(Arrays.asList(user.get())));
		else
			throw new UserNotFoundException("userID: " + userId);
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		if (null != userId) {
			userJPARepository.deleteById(userId);
			return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.value());
		} else
			throw new UserNotFoundException("userID: " + userId);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody User p_user) {
		User user = userJPARepository.saveAndFlush(p_user);
		if (null != user)
			return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED.value());
		else
			throw new UserNotFoundException("" + HttpStatus.EXPECTATION_FAILED);
	}
	
	@PutMapping(value = "/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody User p_user) {
		User user = userJPARepository.save(p_user);
		if (null != user)
			return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.OK.value());
		else
			throw new UserNotFoundException("userID: " + userId);
	}
	
	@GetMapping(value = "/{userId}/posts")
	public ResponseEntity<?> getAllPostsOfGivenUser(@PathVariable Integer userId) {
		Optional<User> optionalUser = null;
		if (null != userId && userId.intValue() != 0) {
			optionalUser = userJPARepository.findById(userId);
			if (optionalUser.isPresent()) {
				List<Post> posts = optionalUser.get().getPosts();
				return ResponseEntity.status(HttpStatus.OK).body(new PostVO(posts));
			} else
				throw new UserNotFoundException("That's bizzare, No such user found in database!");
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserVO());
	}
	
	@PostMapping(value = "/{userId}/posts")
	public ResponseEntity<?> createPost(@PathVariable Integer userId, @Valid @RequestBody Post post) {
		Optional<User> optionalUser = null;
		if (null != userId && userId.intValue() != 0) {
			optionalUser = userJPARepository.findById(userId);
			if (optionalUser.isPresent()) {
				post.setUser(optionalUser.get());
				postJPARepository.save(post);
				return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED.value());
			} else
				throw new UserNotFoundException("That's bizzare! No such user found in database!");
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserVO());
	}

}
