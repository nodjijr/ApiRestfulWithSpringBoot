package com.arthuro.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exemple")
public class ExempleController {

	@GetMapping(value = "/{name}")
	public String exemple(@PathVariable("name") String name) {
		return "Helloooo..." + name;
	}
	
}
