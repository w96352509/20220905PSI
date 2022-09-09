package com.example.demo.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class CreateProduct {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
		
		Product p1 = new Product();
		p1.setName("紅茶");
		p1.setCost(5);
		p1.setPrice(20);
		
		Product p2 = new Product();
		p2.setName("綠茶");
		p2.setCost(5);
		p2.setPrice(20);
		
		Product p3 = new Product();
		p3.setName("奶茶");
		p3.setCost(10);
		p3.setPrice(50);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		
	}
	
}
