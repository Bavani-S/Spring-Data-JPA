package com.cts.country.service;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.country.model.Country;
import com.cts.country.repository.CountryRepository;
import com.cts.country.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Transactional
	public void addCountry(Country country)
	{
		countryRepository.save(country);
		System.out.println("Country detail saved successfully!!!");
	}
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent())
			throw new CountryNotFoundException();
		Country country = result.get();
		return country;
	}
}
