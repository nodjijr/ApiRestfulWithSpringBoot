package com.arthuro.api.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthuro.api.dtos.CompanyDto;
import com.arthuro.api.responses.Response;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@PostMapping
	public ResponseEntity<Response<CompanyDto>> insert(@Valid @RequestBody CompanyDto company, BindingResult result) {
		Response<CompanyDto> response = new Response<CompanyDto>();
		
		response.setData(company);
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.getData().setId(UUID.randomUUID());
		
		return ResponseEntity.ok(response);
	}
	
}
