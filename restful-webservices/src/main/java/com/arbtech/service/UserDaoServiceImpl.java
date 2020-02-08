package com.arbtech.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.arbtech.model.User;
import com.arbtech.vo.UserVO;

@Component
public class UserDaoServiceImpl implements IUserDaoService {

	private static List<User> users = new ArrayList<User>();
	static int usersCount = 3;
	static {
		users.add(new User("Aniket", 1, new Date()));
		users.add(new User("Sachin", 2, new Date()));
		users.add(new User("Samarath", 3, new Date()));
	}
	
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
	public String deleteUser(int userId) {
		String result = "User with userId:"+userId+" not found!";
		for(User user : users) {
			if(user.getId().intValue() == userId) {
				users.remove(user);
				usersCount--;
				result = "Deleted userID: "+userId+" successfully!\nTotal userCount: "+usersCount;
				break;
			}
		}
		return result;
	}

	@Override
	public String createUser(User p_user) {
		String result = "User already present!";
		if(!users.contains(p_user)) {
			p_user.setId(++usersCount);
			users.add(p_user);
			result = "User created successfully!\nTotal userCount: "+usersCount;
		} 
		return result;
	}

	@Override
	public String updateUser(int p_userId, User p_user) {
		String result = "User not found!";
		for (User user : users) {
			if (user.getId().intValue() == p_userId) {
				if (user.getName() != p_user.getName())
					user.setName(p_user.getName());
				if (user.getBirthDate() != p_user.getBirthDate())
					user.setBirthDate(p_user.getBirthDate());
				result = "User updated successfully for userId: " + p_userId;
				break;
			}
		}
		return result;
	}

}