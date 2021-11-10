package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {

}
