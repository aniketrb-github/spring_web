package com.arbtech.zrestws.staticFiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping(value = "/{empId}")
	public Employee getEmployee(@PathVariable String empId) {
		return new Employee("1812T", "Raju", 15000.0F, "Testing Dept");
	}
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return Arrays.asList(new Employee("1812T", "Raju", 15000.0F, "Testing Dept"), new Employee("1232T", "Podim", 15000.0F, "R&D Dept"));
	}
}
