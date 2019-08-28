package com.arthuro.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthuro.api.entities.Company;
import com.arthuro.api.entities.Employer;

public interface EmployerRepository extends JpaRepository<Company, UUID> {
	
	Employer findByCode(String code);

}
