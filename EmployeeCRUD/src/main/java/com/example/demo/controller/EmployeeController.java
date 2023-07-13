package com.example.demo.controller;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.beans.*;

@RestController
public class EmployeeController {
	
	LinkedList<Employee> emps = new LinkedList<>();
	
	@GetMapping("/getall")
	public LinkedList<Employee> getAllEmployeeDetails()
	{
		return emps;
	}


	@GetMapping("/employee/{id}") 
	  public Employee getEmployeeDetailsById(@PathVariable int id) 
	  {
		 for(Employee emp:emps)
		 {
			 if(id==emp.getEmpNo())
			 {
				 return emp;
			 }
		 }
		  return null; 
	  }
	
	@PostMapping("/insert")
	public void addEmployee(@RequestBody Employee employee)
	{
		emps.add(employee);
	}
	
	 @PutMapping("/employee/{id}")
	    public Employee updateEmployeeDetailsById(@PathVariable int id, @RequestBody Employee updatedEmployee) {
	        for (Employee emp : emps) {
	            if (id == emp.getEmpNo()) {
	                emp.setName(updatedEmployee.getName());
	                emp.setDesignation(updatedEmployee.getDesignation());
	                emp.setSalary(updatedEmployee.getSalary());
	                return emp;
	            }
	        }
	        return null;
	    }

	    @DeleteMapping("/employee/{id}")
	    public boolean deleteEmployeeById(@PathVariable int id) {
	        Employee foundEmployee = null;
	        for (Employee emp : emps) {
	            if (id == emp.getEmpNo()) {
	                foundEmployee = emp;
	                break;
	            }
	        }
	        if (foundEmployee != null) {
	            emps.remove(foundEmployee);
	            return true;
	        }
	        return false;
	    }
}
