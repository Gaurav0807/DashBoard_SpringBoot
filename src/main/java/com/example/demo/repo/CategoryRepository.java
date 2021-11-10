package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
