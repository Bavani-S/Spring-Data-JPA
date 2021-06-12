package com.cts.country;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.country.model.Country;
import com.cts.country.service.CountryService;

@SpringBootApplication
public class CountryDetailsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryDetailsApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CountryDetailsApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries;
		try {
			countries = countryService.getAllCountries();
			for(Country country : countries) {
				System.out.println(country);
			LOGGER.debug("Country:{}", country);
			}
			LOGGER.info("End");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
