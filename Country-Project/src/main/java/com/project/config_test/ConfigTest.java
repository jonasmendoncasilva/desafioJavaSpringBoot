package com.project.config_test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.model.Country;
import com.project.repository.CountryRepository;

@Configuration
public class ConfigTest implements CommandLineRunner {

	@Autowired
	private CountryRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
	
		Country c1 = new Country(null, "Brasil", "Brasilia","South","Latin", 100000);
		Country c2 = new Country(null, "USA", "Washinton","North","Mid-North", 100001);
		Country c3 = new Country(null, "Russia", "Moscou","North","East-North", 200000);

		repository.saveAll(Arrays.asList(c1,c2,c3));
	}
}
