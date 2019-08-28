package com.arthuro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arthuro.api.entities.Company;
import com.arthuro.api.repositories.CompanyRepository;
import com.arthuro.api.utils.PassUtils;

@SpringBootApplication
public class ApiRestfulWithSpringBootApplication {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulWithSpringBootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("### Quantidade de elementos por pagina = " + this.qtdPorPagina);
			
			String passEncoded = PassUtils.generate("123456");
			System.out.println("pass encoded: " + passEncoded);
			
			passEncoded = PassUtils.generate("123456");
			System.out.println("pass encoded again: " + passEncoded);
			
			System.out.println("pass valid: " + PassUtils.passValid("123456", passEncoded));
			
			
			Company company = new Company();
			company.setCode("745645454");
			company.setDescription("Nodji IT");
			this.companyRepository.save(company);
			
			List<Company> companies = this.companyRepository.findAll();
			companies.forEach(System.out::println);
			
			Company companyDB = companyRepository.findByCode("745645454");
			System.out.println("empresa :" + companyDB.toString());
			companyDB.setCode("6554648546");
			this.companyRepository.save(companyDB);
			
			Company companyCNPJ = companyRepository.findByCode("6554648546");
			System.out.println("empresa :" + companyCNPJ.toString());
			companyCNPJ.setDescription("Nodji Ti e co.");
			this.companyRepository.save(companyCNPJ);
			
			companyCNPJ = companyRepository.findByCode("6554648546");
			System.out.println("empresa :" + companyCNPJ.toString());
			
			this.companyRepository.delete(companyCNPJ);
			companies = this.companyRepository.findAll();
			System.out.println(companies.size());

			
			
		};
	}

	
}
