package com.example.demo.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/")
	public String index(Model model ) {
		List<User> users = Arrays.asList(
				new User(1,"John",19,new Date()),
				new User(2,"Mary",30,new Date()),
				new User(3,"Roes",20,new Date())
				);
		model.addAttribute("abc" , "1234");
		model.addAttribute("time" , new Date());
		model.addAttribute("user" , new User(2,"Mary",19,new Date()));
		model.addAttribute("users" , users);
		return "hello";
	}
	
}

class User{
	
	int id ; 
	String name;
	int age;
	Date birth;
	
	public User() {
		
	}
	
	public User(int id, String name, int age, Date birth) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
    	
}
