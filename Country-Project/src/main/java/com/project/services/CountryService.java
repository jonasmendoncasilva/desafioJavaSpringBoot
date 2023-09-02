package com.project.services;

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
}
