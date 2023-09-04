package com.project.DTO;

public record CountryUpdateDTO(
		Long id,
		String name,
		String capital,
		String region,
		String subRegion,
		Integer area) {}
