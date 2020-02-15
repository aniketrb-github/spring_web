package com.arbtech.zrestws.dynamicFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * Dynamic Filtering for Restful web-services
 * The class level annotation with value 'HumanDynamicFilter' is or actual filter in HumanController
 *  * 
 * @author Aniket Bharsakale
 */
@JsonFilter("HumanDynamicFilter")
public class Human {

	private String firstName;
	private String lastName;
	private String gender;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Human(String firstName, String lastName, String gender, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	public Human() {
		super();
	}

}
