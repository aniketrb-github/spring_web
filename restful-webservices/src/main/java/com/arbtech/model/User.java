package com.arbtech.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * User model class
 * 
 * @author Aniket Bharsakale
 */
public class User {
	@Size(min=2, message="Name should be more than 2 characters")
	private String name;
	private Integer id;
	@Past(message="Birthdate cannot be a future/present date.")
	private Date birthDate;

	public User(String name, Integer id, Date birthDate) {
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
	}

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
	
}
