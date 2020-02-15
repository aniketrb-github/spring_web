package com.arbtech.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * User model class
 * 
 * @author Aniket Bharsakale
 */
@ApiModel(description = "The User Model/POJO used in the application.")
public class User {
	@Size(min = 2, message = "Name should be more than 2 characters")
	@ApiModelProperty(notes = "Name should be more than 2 characters")
	private String name;
	
	@ApiModelProperty(notes = "The auto-generated identifier by system for an user.")
	private Integer id;

	@ApiModelProperty(notes = "Birthdate cannot be a future/present date.")
	@Past(message = "Birthdate cannot be a future/present date.")
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
