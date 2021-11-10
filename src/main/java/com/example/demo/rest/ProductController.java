package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Category;
import com.example.demo.model.SubCategory;
import com.example.demo.model.User1;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.SubCategoryRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private SubCategoryRepository subcategoryRepo;
	
	
	@GetMapping("/addCategory")
	private String addcategory(Model m)
	{
		m.addAttribute("category", new Category());
		return "Category";
	}

	
	@PostMapping("/add_category1")
	public String addUser1(@ModelAttribute("category") Category category,BindingResult result1)
	{
		if(result1.hasErrors())
		{
			System.out.println("Error Page");
		}
		
		System.out.println(category);
		categoryRepo.save(category);
		return "dashboard";
	}
	
	@GetMapping("/subcategory")
	private String addsubCategory(Model m)
	{
		m.addAttribute("subcategory", new SubCategory());
		return "SubCategory";
	}
	
	
	@PostMapping("/sub_category1")
	public String addUser1(@ModelAttribute("subcategory") SubCategory subcategory,BindingResult result1)
	{
		if(result1.hasErrors())
		{
			System.out.println("Error Page");
		}
		
		System.out.println(subcategory);
		subcategoryRepo.save(subcategory);
		return "dashboard";
	}
	
	
	
	
	
}
