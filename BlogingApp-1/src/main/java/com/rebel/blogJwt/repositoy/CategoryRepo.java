package com.rebel.blogJwt.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebel.blogJwt.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
