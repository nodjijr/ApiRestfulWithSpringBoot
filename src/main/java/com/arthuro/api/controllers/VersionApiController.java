package com.arthuro.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersionApiController {

	@GetMapping(value = "/v1/hello/{name}")
	public ResponseEntity<String> helloNameV1(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API v1: hello %s", name));
	}

	@GetMapping(value = "/v2/hello/{name}")
	public ResponseEntity<String> helloNameV2(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API v2: hello %s", name));
	}
	
	@GetMapping(value = "/hello/{name}", headers = "X-API-Version=v1")
	public ResponseEntity<String> helloNameHeaderV1(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API Header v1: hello %s", name));
	}

	@GetMapping(value = "/hello/{name}", headers = "X-API-Version=v2")
	public ResponseEntity<String> helloNameHeaderV2(@PathVariable("name") String name) {
		return ResponseEntity.ok(String.format("API Header v2: hello %s", name));
	}

}
