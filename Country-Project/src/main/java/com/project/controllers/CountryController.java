package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.CountryGetDTO;
import com.project.DTO.CountryPostDTO;
import com.project.DTO.CountryUpdateDTO;
import com.project.model.Country;
import com.project.services.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService service;
	
	@PostMapping
	@RequestMapping("/create")
	public ResponseEntity<Country> postCountry(@RequestBody CountryPostDTO countryDTO) {
		Country country = service.postCountry(new Country(countryDTO));
		return ResponseEntity.created(null).body(country);
	}

	@GetMapping
	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<CountryGetDTO> findById(@PathVariable Long id){
		Country country = service.findById(id);
		return ResponseEntity.ok().body(new CountryGetDTO(country));
	}

	@GetMapping
	@RequestMapping(value = "/get/all")
	public ResponseEntity<List<Country>> findAll(){
		List<Country> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	@RequestMapping(value = "/get/order/{fieldSearch}")
	public ResponseEntity<List<Country>> findByKeyword(@PathVariable String fieldSearch){
		List<Country> list = service.findByKeyword(fieldSearch.toLowerCase());
		return ResponseEntity.ok().body(list);
	}
	

	@PutMapping
	@RequestMapping(value = "/update")
	public ResponseEntity<Void> updateCountry(@RequestBody CountryUpdateDTO countryDTO){
		service.updateCountry(countryDTO);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	@RequestMapping(value = "/delete/{id}")
	public ResponseEntity<Void> deleteCountry(@PathVariable Long id){
		service.deleteCountry(id);
		return ResponseEntity.ok().build();
	}
}
