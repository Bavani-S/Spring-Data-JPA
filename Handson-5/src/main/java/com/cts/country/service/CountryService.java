package com.cts.country.service;

import java.util.List;
//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.country.model.Country;
import com.cts.country.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries(){
		return countryRepository.findAll();
	}
}
