package com.arthuro.api.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arthuro.api.security.JwtUserFactory;
import com.arthuro.api.security.entities.User;
import com.arthuro.api.security.services.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> funcionario = usuarioService.buscarPorEmail(username);

		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
