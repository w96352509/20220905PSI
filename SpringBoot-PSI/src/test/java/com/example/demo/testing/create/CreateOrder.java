package com.example.demo.testing.create;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class CreateOrder {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CustomerRepository customerRepository; 
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void test() {
		Order o1 = new Order();
	    o1.setCustomer(customerRepository.findById(1L).get());
	    o1.setEmployee(employeeRepository.findById(1L).get());
	    o1.setDate(new Date());
	    
	    OrderItem oi1 = new OrderItem();
	    oi1.setAmount(10);
	    oi1.setProduct(productRepository.findById(1L).get());
	    oi1.setOrder(o1);
	    
	    OrderItem oi2 = new OrderItem();
	    oi2.setProduct(productRepository.findById(2L).get());
	    oi2.setOrder(o1);
	 
	    orderRepository.save(o1);
	    orderItemRepository.save(oi1);
	    orderItemRepository.save(oi2);
	}
	
}
