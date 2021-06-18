package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Flight;
import com.cts.model.Passenger;

@SpringBootTest
class FlightManagementApplicationTests {

/*	@Test
	void addEconomyFlight() {
		Flight flight = new Flight(1,"economy",null);
		assertEquals("economy",flight.getFlightType());
	}
	@Test
	void addBusinessFlight() {
		Flight flight = new Flight(1,"business",null);
		assertEquals("business",flight.getFlightType());
	}
	@Test
	void addVipToEconomy() {
		Flight flight = new Flight();
		flight.setId(3);
		flight.setFlightType("economy");
		Passenger passenger = new Passenger("Sam", true);
		flight.addPassenger(passenger);
		assertNotEquals(1, flight.getPassengers().size());
	}
	
	@Test
	void addVipToBusiness() {
		Flight flight = new Flight();
		flight.setId(4);
		flight.setFlightType("business");
		Passenger passenger = new Passenger("Dean", true);
		flight.addPassenger(passenger);
		assertEquals(1, flight.getPassengers().size());
	}
	
	@Test
	void addNonVipToEconomy() {
		Flight flight = new Flight();
		flight.setId(5);
		flight.setFlightType("economy");
		Passenger passenger = new Passenger("Jacob", false);
		flight.addPassenger(passenger);
		assertEquals(1, flight.getPassengers().size());
	}
	
	@Test
	void addNonVipToBusiness() {
		Flight flight = new Flight();
		flight.setId(5);
		flight.setFlightType("business");
		Passenger passenger = new Passenger("Jacob", false);
		flight.addPassenger(passenger);
		assertEquals(0, flight.getPassengers().size());
	}
	@Test
	void RemoveVIPFromEconomy() {
		Flight flight = new Flight();
		flight.setId(7);
		flight.setFlightType("economy");
		Passenger passenger = new Passenger("Dean", true);
		flight.addPassenger(passenger);
		flight.removePassenger(passenger);
		assertEquals(0, flight.getPassengers().size());
	}
	@Test
	void RemoveVIPFromBusiness() {
		Flight flight = new Flight();
		flight.setId(7);
		flight.setFlightType("business");
		Passenger passenger = new Passenger("Dean", true);
		flight.addPassenger(passenger);
		flight.removePassenger(passenger);
		assertEquals(1, flight.getPassengers().size());
	}
	@Test
	void RemoveNonVIPFromEconomy() {
		Flight flight = new Flight();
		flight.setId(7);
		flight.setFlightType("economy");
		Passenger passenger = new Passenger("Dean", false);
		flight.addPassenger(passenger);
		flight.removePassenger(passenger);
		assertEquals(0, flight.getPassengers().size());
		
	}
	@Test
	void RemoveNonVIPFromBusiness() {
		Flight flight = new Flight();
		flight.setId(7);
		flight.setFlightType("business");
		Passenger passenger = new Passenger("Dean", false);
		flight.addPassenger(passenger);
		flight.removePassenger(passenger);
		assertEquals(0, flight.getPassengers().size());
	}
*/
}
