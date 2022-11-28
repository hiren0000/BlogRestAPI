package com.rebel.blogJwt.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.rebel.blogJwt.model.Category;
import com.rebel.blogJwt.payloads.CategoryDto;
import com.rebel.blogJwt.repositoy.CategoryRepo;
import com.rebel.blogJwt.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired 
	private ModelMapper mapper;

	//creating cat
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.mapper.map(categoryDto, Category.class);
		
		Category createCat = this.categoryRepo.save(cat);
		
		return this.mapper.map(createCat, CategoryDto.class);
	}

	//fetching all cats
	@Override
	public List<CategoryDto> getAllCategories() {
		
		List<Category> cates = this.categoryRepo.findAll();
		
		List<CategoryDto> dto = cates.stream()
		 					.map(category -> this.mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return dto;
	}
	

	//updating cats
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer cId) {
		
		Category category = this.categoryRepo.findById(cId)
									.orElseThrow(() -> new ResourceAccessException("Category not foudn with Id"+" "+cId));
		
		category.setcTitle(categoryDto.getcTitle());
		category.setcDescrp(categoryDto.getcDescrp());
		
		Category updatedCategory =this.categoryRepo.save(category);
		
		return this.mapper.map(updatedCategory, CategoryDto.class);
	}

	//deleting cat by id
	@Override
	public void deleteCategory(Integer cId) {
		Category category = this.categoryRepo.findById(cId)
				.orElseThrow(() -> new ResourceAccessException("Category not foudn with Id"+" "+cId));
		
		this.categoryRepo.delete(category);
	}

	//fetching cat by id
	@Override
	public CategoryDto getCategoryById(Integer cId) {
		
		Category category = this.categoryRepo.findById(cId)
				.orElseThrow(() -> new ResourceAccessException("Category not foudn with Id"+" "+cId));
		
		return this.mapper.map(category, CategoryDto.class);
	}
	

}
