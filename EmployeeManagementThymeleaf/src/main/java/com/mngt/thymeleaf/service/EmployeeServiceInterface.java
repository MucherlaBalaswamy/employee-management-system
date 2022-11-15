package com.mngt.thymeleaf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mngt.thymeleaf.entity.Employee;

@Service
public interface EmployeeServiceInterface {
	
	public List<Employee> getEmployeedetails();
	
	public void save(Employee emp);
	
	public void delete(Employee emp);
	
	public Employee findById(int empId);

	
	
}
