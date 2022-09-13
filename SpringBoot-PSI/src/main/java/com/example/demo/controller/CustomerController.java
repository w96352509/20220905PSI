package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/")
	public String index(Model model , @ModelAttribute Customer customer) {
		return "customer";
	}
	
}
