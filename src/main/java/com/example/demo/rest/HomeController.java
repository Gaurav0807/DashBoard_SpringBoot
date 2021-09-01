package com.example.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
 * Author :Gaurav Rawat
 */
@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/forget")
	public String forget()
	{
		return "forget";
	}

	@GetMapping("/reset")
	public String reset()
	{
		return "reset_password";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	
	
}
