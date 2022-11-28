package com.rebel.blogJwt.services;

import java.util.List;

import com.rebel.blogJwt.payloads.CategoryDto;

public interface CategoryService 
{
	//create category
		CategoryDto createCategory(CategoryDto categoryDto);
		
		//get categories
		List<CategoryDto> getAllCategories();
		
		//update category
		CategoryDto updateCategory(CategoryDto categoryDto, Integer cId);
		
		//delete category
		void deleteCategory(Integer cId);
		
		//get category by id
		CategoryDto getCategoryById(Integer cId);

}
