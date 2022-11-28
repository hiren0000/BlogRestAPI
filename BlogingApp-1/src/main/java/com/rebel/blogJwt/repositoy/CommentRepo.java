package com.rebel.blogJwt.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebel.blogJwt.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>
{

}
