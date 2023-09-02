package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.CountryPostDTO;
import com.project.model.Country;
import com.project.services.CountryService;

@RestController
@RequestMapping("/countrys")
public class CountryController {

	@Autowired
	private CountryService service;
	
	@PostMapping
	public ResponseEntity<Country> postCountry(@RequestBody CountryPostDTO countryDTO) {
		Country country = service.postCountry(new Country(countryDTO));
		return ResponseEntity.ok().body(country);
	}

	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Country> findById(@PathVariable Long id) throws Exception{
		Country country = service.findById(id);
		return ResponseEntity.ok().body(country);
	}
}
