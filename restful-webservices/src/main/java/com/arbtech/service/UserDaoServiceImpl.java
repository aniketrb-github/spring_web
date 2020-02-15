package com.arbtech.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arbtech.model.User;
import com.arbtech.vo.UserVO;

/**
 * Service layer class for UserDAO
 * 
 * @author Aniket Bharsakale
 */
@Component
public class UserDaoServiceImpl implements IUserDaoService {

	private static List<User> users = new ArrayList<User>();
	static int usersCount = 3;
	/*
	 * static { users.add(new User("Aniket", 1, new Date())); users.add(new
	 * User("Sachin", 2, new Date())); users.add(new User("Samarath", 3, new
	 * Date())); }
	 */
	
	@Override
	public UserVO getUser(int userId) {
		UserVO userVO = null;
		for(User user : users) {
			if(user.getId().intValue() == userId) {
				userVO = new UserVO(Arrays.asList(user));
				break;
			}
		}
		return userVO;
	}

	@Override
	public UserVO getAllUsers() {
		return new UserVO(users);
	}

	@Override
	public Boolean deleteUser(int userId) {
		boolean isDeleted = Boolean.FALSE;
		for(User user : users) {
			if(user.getId().intValue() == userId) {
				users.remove(user);
				usersCount--;
				isDeleted = Boolean.TRUE;
				break;
			}
		}
		return isDeleted;
	}

	@Override
	public User createUser(User p_user) {
		Optional<User> user = null;
		if(!users.contains(p_user)) {
			p_user.setId(++usersCount);
			users.add(p_user);
		
			user = users.stream().
		    filter(p -> p.getId().intValue() == p_user.getId().intValue()).
		    findFirst();
		} 
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public User updateUser(int p_userId, User p_user) {
		User l_user = null;
		for (User user : users) {
			if (user.getId().intValue() == p_userId) {
				if (user.getName() != p_user.getName())
					user.setName(p_user.getName());
				if (user.getBirthDate() != p_user.getBirthDate())
					user.setBirthDate(p_user.getBirthDate());
				l_user = user;
				break;
			}
		}
		return l_user;
	}

}
