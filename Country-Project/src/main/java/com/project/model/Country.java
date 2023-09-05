package com.project.model;

import java.io.Serializable;

import com.project.DTO.CountryPostDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countrys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	@Column(unique=true)
	private String capital;
	private String region;
	private String subRegion;
	private Integer area;

	public Country (CountryPostDTO countryDTO) {
		this.name = countryDTO.name();
		this.capital = countryDTO.capital();
		this.region = countryDTO.region();
		this.subRegion = countryDTO.subRegion();
		this.area = countryDTO.area();
	}
}
