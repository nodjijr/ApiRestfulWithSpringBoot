package com.arthuro.api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.arthuro.api.security.entities.User;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
