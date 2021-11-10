package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String pname;
	
	private String pbrand;
	
	private String pdescription;
	
	 @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Category> CategoryList = new ArrayList<>();
	
	 @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<SubCategory> SubCategoryList = new ArrayList<>();
	
	private String pbuild;
	
	private String color;
	
	private String size;
	
	private String pweight;
	
	private String price;
	
	private String discount;
	
	private String active;
	
	public Product()
	{
		
	}

	
	public Product(int id, String pname, String pbrand, String pdescription, List<Category> categoryList,
			List<SubCategory> subCategoryList, String pbuild, String color, String size, String pweight, String price,
			String discount, String active) {
		super();
		this.id = id;
		this.pname = pname;
		this.pbrand = pbrand;
		this.pdescription = pdescription;
		CategoryList = categoryList;
		SubCategoryList = subCategoryList;
		this.pbuild = pbuild;
		this.color = color;
		this.size = size;
		this.pweight = pweight;
		this.price = price;
		this.discount = discount;
		this.active = active;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPbrand() {
		return pbrand;
	}

	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public List<Category> getCategoryList() {
		return CategoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		CategoryList = categoryList;
	}

	public List<SubCategory> getSubCategoryList() {
		return SubCategoryList;
	}

	public void setSubCategoryList(List<SubCategory> subCategoryList) {
		SubCategoryList = subCategoryList;
	}

	public String getPbuild() {
		return pbuild;
	}

	public void setPbuild(String pbuild) {
		this.pbuild = pbuild;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPweight() {
		return pweight;
	}

	public void setPweight(String pweight) {
		this.pweight = pweight;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	
	
	
	
}
