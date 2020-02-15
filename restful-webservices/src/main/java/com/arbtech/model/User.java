package com.arbtech.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Model Entity: User
 * 
 * @author Aniket Bharsakale
 */
@ApiModel(description = "The User Model/POJO used in the application.")
@Entity
public class User {
	@Size(min = 2, message = "Name should be more than 2 characters")
	@ApiModelProperty(notes = "Name should be more than 2 characters")
	private String name;

	@ApiModelProperty(notes = "The auto-generated identifier by system for an user.")
	@Id
	@GeneratedValue
	private Integer id;

	@ApiModelProperty(notes = "Birthdate cannot be a future/present date.")
	@Past(message = "Birthdate cannot be a future/present date.")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public User() {
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User(@Size(min = 2, message = "Name should be more than 2 characters") String name, Integer id,
			@Past(message = "Birthdate cannot be a future/present date.") Date birthDate, List<Post> posts) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
		this.posts = posts;
	}

}
