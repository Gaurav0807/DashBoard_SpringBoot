package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User1;
import com.example.demo.repo.User1Repo;



/*
 * Author :Gaurav Rawat
 */

@Controller
public class UserController {
	
	
	@Autowired
	private User1Repo u1;
	
	@GetMapping("/add_user")
	public String addUser(Model m)
	{
		m.addAttribute("user1", new User1());
		return "add_user";
	}
	
	
	@PostMapping("/add_user1")
	public String addUser1(@ModelAttribute("user1") User1 user1,BindingResult result1)
	{
		if(result1.hasErrors())
		{
			System.out.println("Error Page");
		}
		if(user1.getRole()=="")
		{
			user1.setRole("Admin");
		}
		
		
		System.out.println(user1);
		u1.save(user1);
		return "dashboard";
	}

	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") int id,Model m)
	{
		
		User1 user1 = this.u1.findById(id).get();
		m.addAttribute("user1",user1);
		System.out.println(user1);	
		return "edit_user";
	}
	
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String updateUser(@PathVariable("id") int id,User1 user1)
	{
		
		u1.save(user1);
		return "dashboard";
		
	}
	
	
	@GetMapping("/view_user")
	public String viewUser(Model m)
	{
		List<User1> users1 = u1.findAll();
		m.addAttribute("users1", users1);
		return "view_user";
	}
	
	
	@GetMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id)
	{
		
		System.out.println("Integer id"+id);
		u1.deleteById(id);
		return "dashboard";
	}
	
}
