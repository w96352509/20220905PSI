package com.example.demo.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
public class CreateEmployee {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		Department d1 = departmentRepository.findById(1L).get();
		Department d2 = departmentRepository.findById(2L).get();
		Department d3 = departmentRepository.findById(3L).get();
		
		Employee e1 = new Employee();
		e1.setName("John");
		e1.setDepartment(d1);
		
		Employee e2 = new Employee();
		e2.setName("Mary");
		e2.setDepartment(d2);
		
		Employee e3 = new Employee();
		e3.setName("Helen");
		e3.setDepartment(d3);
		
		Employee e4 = new Employee();
		e4.setName("Bob");
		e4.setDepartment(d3);
		
		employeeRepository.save(e1);
		employeeRepository.save(e2);
		employeeRepository.save(e3);
		employeeRepository.save(e4);
	}
	
}
