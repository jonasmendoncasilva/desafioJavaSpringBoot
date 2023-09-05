package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.DTO.CountryUpdateDTO;
import com.project.exceptions.EntityNotFoundException;
import com.project.exceptions.EntityWithSameCapitalException;
import com.project.exceptions.EntityWithSameNameException;
import com.project.exceptions.KeywordNotFoundException;
import com.project.model.Country;
import com.project.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;
	
	public Country postCountry(Country country) {
		if(repository.findByName(country.getName()) == true) {
			throw new EntityWithSameNameException();
		}
		if(repository.findByName(country.getName()) == true) {
			throw new EntityWithSameCapitalException();
		}	
		return repository.save(country);
	}
	
	public Country findById(Long id){
		return checkCountry(id);
	}

	public List<Country> findAll (){
		return repository.findAll();
	}

	public List<Country> findByKeyword(String fieldSearch){
		if (!fieldSearch.equals("NAME") || !fieldSearch.equals("CAPITAL")  || !fieldSearch.equals("REGION")  ||
				!fieldSearch.equals("SUBREGION")  || !fieldSearch.equals("AREA")  ) {
			throw new KeywordNotFoundException();
		}
		
		Sort sort = Sort.by(fieldSearch).ascending();
		return repository.findAll(sort);
	}
	
	public void updateCountry(CountryUpdateDTO countryDTO){
		Country country = checkCountry(countryDTO.id());
		
		country.setName(countryDTO.name());
		country.setCapital(countryDTO.capital());
		country.setRegion(countryDTO.region());
		country.setSubRegion(countryDTO.subRegion());
		country.setArea(countryDTO.area());
		repository.save(country);
	}

	public void deleteCountry(Long id){
		repository.deleteById(id);
	}
	
	public Country checkCountry(Long id){
		Optional<Country> country = repository.findById(id);
		return country.orElseThrow(() -> new EntityNotFoundException(id));
	}
}
