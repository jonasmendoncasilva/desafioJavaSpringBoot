package com.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DTO.CountryUpdateDTO;
import com.project.model.Country;
import com.project.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;
	
	public Country postCountry(Country country) {
		return repository.save(country);
	}
	
	public Country findById(Long id) throws Exception  {
		return checkCountry(id);
	}

	public List<Country> findAll (){
		return repository.findAll();
	}

	public void updateCountry(CountryUpdateDTO countryDTO) throws Exception{
		Country country = checkCountry(countryDTO.id());
		
		country.setName(countryDTO.name());
		country.setCapital(countryDTO.capital());
		country.setRegion(countryDTO.region());
		country.setSubRegion(countryDTO.subRegion());
		country.setArea(countryDTO.area());
		repository.save(country);
	}

	public void deleteCountry(Long id) throws Exception{
		checkCountry(id);
		repository.deleteById(id);
	}
	
	public Country checkCountry(Long id) throws Exception {
		Country country = repository.getReferenceById(id);
		if (country == null) {
			throw new Exception ("Usuário não encontrado");
		}
		else {
			return country;
		}
	}
}
