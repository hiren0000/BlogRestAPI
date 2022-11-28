package com.rebel.blogJwt.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rebel.blogJwt.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
	Optional<User> findByuEmail(String uEmail);
}
