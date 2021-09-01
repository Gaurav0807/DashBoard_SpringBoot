package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_master")
public class Role_master {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String role_name;
	
	private String landing_page;
	
	private int active;
	
	
	public Role_master()
	{
		
	}

	public Role_master(int id, String role_name, String landing_page, int active) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.landing_page = landing_page;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getLanding_page() {
		return landing_page;
	}

	public void setLanding_page(String landing_page) {
		this.landing_page = landing_page;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Role_master [id=" + id + ", role_name=" + role_name + ", landing_page=" + landing_page + ", active="
				+ active + "]";
	}
	
	
	

	
	

}
