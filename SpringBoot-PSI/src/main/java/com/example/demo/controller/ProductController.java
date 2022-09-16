package com.example.demo.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.LineNotify;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private  ProductRepository productRepository;
	
	@Autowired
	private LineNotify lineNotify;
	
	@GetMapping("/")
	public String index(Model model , @ModelAttribute Product product) {
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("_method" , "POST");
		return "product";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("product", productRepository.findById(id));
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "product";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model ) {
		model.addAttribute("product", productRepository.findById(id));
		model.addAttribute("products", productRepository.findAll());
		model.addAttribute("_method" , "PUT");
		return "product-edit";
	}
	
	@PutMapping("/")
	public String update(Model model , @ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:./";
	}
	
	@PutMapping("/update")
	public String updatePage(Model model , @ModelAttribute Product product) {
		productRepository.save(product);
		return "redirect:./";
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute Product product ) {
		productRepository.save(product);
		return"redirect:./";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		productRepository.deleteById(id);
		return"redirect:../";
	}
	
	@GetMapping("/line/{id}")
    public String line(@PathVariable("id") Long id  , Model model , RedirectAttributesModelMap modelMap) throws IOException {
		try {
			// lineNotify.send(productRepository.findById(id).get());
			lineNotify.sendImage(productRepository.findById(id).get(), "紅.jpg");
			modelMap.addFlashAttribute("resultMsg", "Line訊息傳送成功");
	        return "redirect:../";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("product", new Product());
			model.addAttribute("products", productRepository.findAll());
			model.addAttribute("_method" , "POST");
			return "product";
		}
        
    }
	
}
