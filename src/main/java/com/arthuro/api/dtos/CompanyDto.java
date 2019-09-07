package com.arthuro.api.dtos;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public class CompanyDto {
	private UUID id;
	private String description;
	private String code;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	@NotEmpty(message = "Code is null.")
	@CNPJ(message = "Code invalid.")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@NotEmpty(message = "Description is null.")
	@Length(min = 5, max = 200, message = "Description range 5 and.")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", description=" + description + ", code=" + code + "]";
	}

}
