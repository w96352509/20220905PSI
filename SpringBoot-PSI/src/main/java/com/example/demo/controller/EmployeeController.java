package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Employee employee) {
		model.addAttribute("employees" , employeeRepository.findAll());
		model.addAttribute("_method" , "POST");
		model.addAttribute("departments" , departmentRepository.findAll());
		return "employee";
	}
	
	@GetMapping("/{id}")
	public String get(Model model , @PathVariable("id") Long id) {
		model.addAttribute("employee" , employeeRepository.findById(id));
		model.addAttribute("_method" , "PUT");
		model.addAttribute("departments" , departmentRepository.findAll());
		model.addAttribute("employees" , employeeRepository.findAll());
		return "employee";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model , @PathVariable("id") Long id) {
		model.addAttribute("employee" , employeeRepository.findById(id));
		model.addAttribute("_method" , "PUT");
		model.addAttribute("departments" , departmentRepository.findAll());
		model.addAttribute("employees" , employeeRepository.findAll());
		return "employee-edit";
	}
	
	@PostMapping("/")
	public String add(Model model ,@Valid @ModelAttribute Employee employee , BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("employees" , employeeRepository.findAll());
			model.addAttribute("_method" , "POST");
			model.addAttribute("departments" , departmentRepository.findAll());
			return "employee";
		}
		employeeRepository.save(employee);
		return "redirect:./";
	}
	
	@PutMapping("/")
	public String update(Model model , @Valid @ModelAttribute Employee employee , BindingResult result)  {
		if(result.hasErrors()) {
			model.addAttribute("_method" , "PUT");
			model.addAttribute("departments" , departmentRepository.findAll());
			model.addAttribute("employees" , employeeRepository.findAll());
			return "employee";
		}
		    employeeRepository.save(employee);
		    return "redirect:./";
	}
	
	@PutMapping("/update")
	public String updatePage(Model model , @Valid @ModelAttribute Employee employee , BindingResult result)  {
		if(result.hasErrors()) {
			model.addAttribute("_method" , "PUT");
			model.addAttribute("departments" , departmentRepository.findAll());
			model.addAttribute("employees" , employeeRepository.findAll());
			return "employee-edit";
		}
		    employeeRepository.save(employee);
		    return "redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		 employeeRepository.deleteById(id);
		 return "redirect:../";
	}
}