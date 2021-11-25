package com.felipesalles.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesalles.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
}
