package com.example.demo.rest;

import java.util.List;

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

import com.example.demo.model.Role_master;
import com.example.demo.model.User1;
import com.example.demo.repo.RoleMasterRepo;

/*
 * Author :Gaurav Rawat
 */

@Controller
public class RoleController {
	
	
	@Autowired
	private RoleMasterRepo repo;
	
	
	@GetMapping("/roleMaster")
	public String RoleMaster(Model m)
	{
		m.addAttribute("role1",new Role_master());
		return "role_master";
	}
	
	@PostMapping("/add_roleMaster")
	public String addroleMaster(@ModelAttribute("role1") Role_master role1,BindingResult result1)
	{
		if(result1.hasErrors())
		{
			System.out.println("Error Page");
		}
		
		System.out.println(role1);
		repo.save(role1);
		
		return "dashboard";
	}
	
	
	@GetMapping("/viewRoleMaster")
	public String viewroleMaster(Model m)
	{
		List<Role_master> role1 = repo.findAll();
		m.addAttribute("role1", role1);
		return "view_roleM";
	}
	
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteRoleMaster(@PathVariable("id") int id)
	{
		
		System.out.println("Integer id"+id);
		repo.deleteById(id);
		return "dashboard";
	}
	
	
	@GetMapping("/edit1/{id}")
	public String editRoleMaster(@PathVariable("id") int id,Model m)
	{
		Role_master role1 = this.repo.findById(id).get();
		m.addAttribute("role1", role1);
		System.out.println(role1);
		return "edit_roleM";
	}
	
	@RequestMapping(value="/update1/{id}",method=RequestMethod.POST)
	public String updateRoleMaster(@PathVariable("id") int id,Role_master role1)
	{
		repo.save(role1);
		return "dashboard";
	}
}












