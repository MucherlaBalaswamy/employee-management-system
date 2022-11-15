package com.mngt.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mngt.thymeleaf.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
