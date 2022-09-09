package com.example.demo.testing.create;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Purchase;
import com.example.demo.entity.PurchaseItem;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SupplierRepository;

@SpringBootTest
public class CreatePurchase {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
	@Test
	public void test() {
		Purchase p1 = new Purchase();
	    p1.setDate(new Date());
	    p1.setEmployee(employeeRepository.findById(4L).get());
	    p1.setSupplier(supplierRepository.findById(1L).get());
	    purchaseRepository.save(p1); 
	    
	    PurchaseItem pi1 = new PurchaseItem();
	    pi1.setAmount(20);
	    pi1.setProduct(productRepository.findById(1L).get());
	    pi1.setPurchase(p1);
	    purchaseItemRepository.save(pi1);
	    
	    PurchaseItem pi2 = new PurchaseItem();
	    pi2.setAmount(10);
	    pi2.setProduct(productRepository.findById(2L).get());
	    pi2.setPurchase(p1);
	    purchaseItemRepository.save(pi2);
	    
	   
	}
	
}
