package com.rebel.blogJwt.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebel.blogJwt.model.Category;
import com.rebel.blogJwt.model.Post;
import com.rebel.blogJwt.model.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>
{
	List<Post> getPostByUser(User user);
	
	List<Post> getPostByCategory(Category category);

}
