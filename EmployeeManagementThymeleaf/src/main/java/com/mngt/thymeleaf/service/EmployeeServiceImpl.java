package com.mngt.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mngt.thymeleaf.dao.EmployeeDAO;
import com.mngt.thymeleaf.entity.Employee;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface{

	@Autowired
   private EmployeeDAO dao;
	
	public List<Employee> getEmployeedetails() {
		
		return dao.findAll();
	}
		
	public void save(Employee emp) {
	
		 dao.save(emp);
	}
	
		public void delete(Employee emp) {
			dao.deleteById(emp.getId());
		}

		
		

		public Employee findById(int empId) {
			java.util.Optional<Employee> o=dao.findById(empId);
			Employee employee=null;
			if(o.isPresent())
				employee=o.get();
			return employee;
		}

	
}

