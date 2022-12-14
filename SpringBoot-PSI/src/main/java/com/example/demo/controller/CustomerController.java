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

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Customer customer) {
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "customer";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("customer" , customerRepository.findById(id));
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "customer";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("customer" , customerRepository.findById(id));
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "customer-edit";
	}
	
	@PutMapping("/")
	public String update(Model model , @ModelAttribute Customer customer) {
		customerRepository.save(customer);
		return "redirect:./";
	}
	
	@PutMapping("/update")
	public String updatePage(Model model , @ModelAttribute Customer customer) {
		customerRepository.save(customer);
		return "redirect:./";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute Customer customer) {
		customerRepository.save(customer);
		return"redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		customerRepository.deleteById(id);
		return"redirect:../";
	}
	
}
