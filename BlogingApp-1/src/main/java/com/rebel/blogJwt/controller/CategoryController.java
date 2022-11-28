package com.rebel.blogJwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebel.blogJwt.payloads.ApiResponse;
import com.rebel.blogJwt.payloads.CategoryDto;
import com.rebel.blogJwt.services.CategoryService;


@RestController
@RequestMapping("/api/category/")
public class CategoryController 
{
	@Autowired
	private CategoryService catagoryService;
	
	
	//creating category
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addCat( @RequestBody CategoryDto catDto)
	{
		CategoryDto addedCata = this.catagoryService.createCategory(catDto);
		
		return new ResponseEntity<>(addedCata, HttpStatus.CREATED);
		
	}
	
	
	//updating category
	@PutMapping("/{cId}")
	public ResponseEntity<CategoryDto> updateCat(@RequestBody CategoryDto catDto, @PathVariable("cId") int cId)
	{
		CategoryDto updatedCat = this.catagoryService.updateCategory(catDto, cId);
		
		return ResponseEntity.ok(updatedCat);
		
	}
	
	
	//getting list of categories
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAll()
	{
		return ResponseEntity.ok(this.catagoryService.getAllCategories());
		
	}
	
	
	//get category by id
	@GetMapping("/{cId}")
	public ResponseEntity<CategoryDto> getSingleCatagory(@PathVariable("cId") int cId)
	{
		return ResponseEntity.ok(catagoryService.getCategoryById(cId));
		
	}
	
	
	//delete category
	@DeleteMapping("/{cId}")
	public ResponseEntity<ApiResponse> deleteCat(@PathVariable("cId") int cid)
	{
		this.catagoryService.deleteCategory(cid);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Catagory is suucessfully deleted", true),HttpStatus.OK);
	}

	
	
}
