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
import com.example.demo.entity.Supplier;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.SupplierRepository;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Supplier supplier) {
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "supplier";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("supplier" , supplierRepository.findById(id));
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "supplier";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("supplier" , supplierRepository.findById(id));
		model.addAttribute("suppliers", supplierRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "supplier-edit";
	}
	
	@PutMapping("/")
	public String update(Model model , @ModelAttribute Supplier supplier) {
		supplierRepository.save(supplier);
		return "redirect:./";
	}
	
	@PutMapping("/update")
	public String updatePage(Model model , @ModelAttribute Supplier supplier) {
		supplierRepository.save(supplier);
		return "redirect:./";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute Supplier supplier) {
		supplierRepository.save(supplier);
		return"redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		supplierRepository.deleteById(id);
		return"redirect:../";
	}
	
}
