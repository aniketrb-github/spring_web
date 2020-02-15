package com.arbtech.zrestws.staticFiltering;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Static Filtering for Restful services
 * Either u can use the class level annotation & provide the hard coded attribute names or
 * You can annotate the attribute specifically which is the recommended way
 * 
 * @author Aniket Bharsakale
 */


// @JsonIgnoreProperties(value = {"id", "salary"})
public class Employee {
	@JsonIgnore
	private String id;
	private String name;

	@JsonIgnore
	private Float salary;
	private String department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee(String id, String name, Float salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public Employee() {
		super();
	}
}
