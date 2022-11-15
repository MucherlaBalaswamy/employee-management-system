package com.mngt.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mngt.thymeleaf.dao.EmployeeDAO;
import com.mngt.thymeleaf.entity.Employee;
import com.mngt.thymeleaf.service.EmployeeServiceImpl;

@Controller
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	public EmployeeServiceImpl service;
    @Autowired
    public EmployeeDAO repo;
    Employee emp=new Employee();
    
    @GetMapping("list")
	public String getData(Model model)
	{
    	List<Employee> empList=service.getEmployeedetails();
    	model.addAttribute("info",empList);
    	model.addAttribute("EMPLOYEE",emp);
		return "Employee.html";
	}
	
         
        @RequestMapping("/save")
        public String save(@ModelAttribute("EMPLOYEE") Employee emp )
        {
        //	model.containsAttribute("EMPLOYEE");
        	
			service.save(emp);	
			return "redirect:/emp/list";
        }
        
       @PostMapping("/delete")
        public String delete(@ModelAttribute("EMPLOYEE") Employee emp ) {
        	
    	   
        	repo.deleteById(emp.getId());
    	  
			return "redirect:/emp/list";
        	
        }

       @GetMapping("showUpdateForm")
       public String updateForm(@RequestParam("empId") int empId,Model model)
       {
    	  Employee employee=service.findById(empId) ;
    	   model.addAttribute("updateEmp",employee);
		return "update.html";
    	   
       }
    
}

