package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SupplierRepository;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Purchase purchase) {
		model.addAttribute("purchases" , purchaseRepository.findAll());
		model.addAttribute("employees" , employeeRepository.findAll());
		model.addAttribute("suppliers" , supplierRepository.findAll());
		model.addAttribute("_method" , "post");
		return "purchase";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id , Model model) {
		model.addAttribute("purchase" ,  purchaseRepository.findById(id));
		model.addAttribute("purchases" , purchaseRepository.findAll());
		model.addAttribute("employees" , employeeRepository.findAll());
		model.addAttribute("suppliers" , supplierRepository.findAll());
		model.addAttribute("_method" , "PUT");	
		return "purchase";
	}
	
}
