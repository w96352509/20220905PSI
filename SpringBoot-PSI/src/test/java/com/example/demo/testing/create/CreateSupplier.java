package com.example.demo.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;

@SpringBootTest
public class CreateSupplier {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Test
	public void test() {
		Supplier s1 = new Supplier();
		s1.setName("立頓");
		supplierRepository.save(s1);
		
		Supplier s2 = new Supplier();
		s2.setName("可不可");
		supplierRepository.save(s2);
		
		Supplier s3 = new Supplier();
		s3.setName("統一");
		supplierRepository.save(s3);
		
		
	}
	
}
