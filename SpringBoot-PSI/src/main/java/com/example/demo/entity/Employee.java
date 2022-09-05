package com.example.demo.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min = 2 , max = 5 , message = "名字長度至少2")
	private String name; // 員工姓名
	
	@ManyToOne
	@JoinColumn(name="department_id" , referencedColumnName = "id") // 外鍵(部門序號)
	@OrderBy("id ASC")
	private Department department;
	
	@OneToMany(mappedBy = "employee")
	@OrderBy("id ASC")
	private List<Order> orders = new LinkedList<>();
	
	
	
}
