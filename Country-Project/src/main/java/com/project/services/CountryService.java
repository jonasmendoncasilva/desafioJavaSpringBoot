package com.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Country;
import com.project.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;
	
	public Country postCountry(Country country) {
		return repository.save(country);
	}
	
	public Country findById(Long id) throws Exception {
		Optional<Country> country = repository.findById(id);
		return country.orElseThrow(() -> new Exception ("Usuário não encontrado"));
	}
}
