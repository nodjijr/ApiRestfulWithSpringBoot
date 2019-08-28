package com.arthuro.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthuro.api.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
	
	Company findByCode(String code);

}
