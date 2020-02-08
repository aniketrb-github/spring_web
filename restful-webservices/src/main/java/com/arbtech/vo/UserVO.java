package com.arbtech.vo;

import java.util.List;

import com.arbtech.model.User;

public class UserVO {
	private List<User> users;

	public UserVO(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
