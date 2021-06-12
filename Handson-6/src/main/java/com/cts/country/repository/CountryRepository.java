package com.cts.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.country.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
