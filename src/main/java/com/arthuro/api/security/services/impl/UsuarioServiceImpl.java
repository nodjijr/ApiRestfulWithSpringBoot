package com.arthuro.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthuro.api.security.entities.User;
import com.arthuro.api.security.repositories.UserRepository;
import com.arthuro.api.security.services.UserService;

@Service
public class UsuarioServiceImpl implements UserService {
	
	@Autowired
	private UserRepository usuarioRepository;
	
	public Optional<User> buscarPorEmail(String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
