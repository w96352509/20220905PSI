package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Department department) {
		model.addAttribute("departments" , departmentRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "department";
	}

	@GetMapping("/{id}")
	public String get(Model model , @PathVariable("id") Long id) {
		model.addAttribute("department" , departmentRepository.findById(id));
		model.addAttribute("departments" , departmentRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "department";
	}
	
	// 跳頁
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Department department = departmentRepository.findById(id).get();
		model.addAttribute("department", department);
		model.addAttribute("_method" , "PUT");
		return "department-edit";
	}
	
	// 跳頁新增
	@PutMapping("/update")
	public String updatePage(Model model , @ModelAttribute Department department) {
		departmentRepository.save(department);
		return "redirect:./";
	}
	
	
	@PostMapping("/")
	public String add(Model model ,@ModelAttribute Department department) {
		departmentRepository.save(department);
		return "redirect:./";
	}
	
	@PutMapping("/{id}")
	public String update(Model model , @ModelAttribute Department department) {
	   departmentRepository.save(department);
	   return "redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model ,@PathVariable("id") Long id) {
		try {
			departmentRepository.deleteById(id);
			return "redirect:../";
		} catch (Exception e) {
			model.addAttribute("department" , new Department());
			model.addAttribute("message" ,String.format("%s尚有員工", departmentRepository.findById(id).get().getName()));
			model.addAttribute("departments" , departmentRepository.findAll());
			model.addAttribute("_method" , "POST");
			return "department";
		}
      }
	
}