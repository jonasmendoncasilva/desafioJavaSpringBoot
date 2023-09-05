package com.project.DTO;

import com.project.model.Country;

public record CountryGetDTO
	(Long id,
	String name,
	String capital,
	String region,
	String subRegion,
	Integer area) {
	
	public CountryGetDTO(Country country) {
		this(country.getId(),country.getName(),country.getCapital(),country.getRegion(),country.getSubRegion(),country.getArea());
	}
}


