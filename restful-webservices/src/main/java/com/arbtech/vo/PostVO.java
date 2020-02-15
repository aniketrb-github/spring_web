package com.arbtech.vo;

import java.util.List;

import com.arbtech.model.Post;
/**
 * PostVO is the View object for the client side representation/abstraction
 * 
 * @author Aniket Bharsakale
 */
public class PostVO {
	private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public PostVO(List<Post> posts) {
		super();
		this.posts = posts;
	}

	public PostVO() {
		super();
	}

}
