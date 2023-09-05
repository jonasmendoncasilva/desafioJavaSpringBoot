package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

	boolean findByName(String name);
	boolean findByCapital(String capital);
}
