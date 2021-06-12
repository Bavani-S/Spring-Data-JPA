package com.cts.country;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.country.model.Country;
import com.cts.country.service.CountryService;
import com.cts.country.service.exception.CountryNotFoundException;

@SpringBootApplication
public class CountryDetailsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryDetailsApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CountryDetailsApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testDeleteCountry();
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("KA");
		try {
			Country newCountry = countryService.findCountryByCode("KA");
			System.out.println(newCountry);
			LOGGER.debug("Country:{}", newCountry);
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
		LOGGER.info("Country detail deleted");
		LOGGER.info("End");
	}

}
