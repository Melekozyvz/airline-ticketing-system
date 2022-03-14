package com.studycase.airline_ticketing_system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studycase.airline_ticketing_system.business.abstracts.FlightService;
import com.studycase.airline_ticketing_system.entities.AirlineCompany;
import com.studycase.airline_ticketing_system.entities.Flight;
import com.studycase.airline_ticketing_system.entities.Route;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@SpringBootTest
class FlightControllerTests {

	@Autowired
	private FlightService fligthService;
	
	@Test
	public void getallFlightsTest(){
		DataResult<List<Flight>> companies=this.fligthService.getAll();
		
		assertNotNull(companies);
		assertTrue(companies.isSuccess());
		assertNotNull(companies.getData());		
	}
	@Test
	public void addFlightTest(){
		Flight flight=new Flight(1,"123456789",new Date(System.currentTimeMillis()),300,
				new AirlineCompany("Pegasus Airlines", new Date(System.currentTimeMillis())),
						new Route(),null);
		Result result=this.fligthService.add(flight);
		
		assertTrue(result.isSuccess());
	}
	@Test
	public void search(){
		String flightNumber="123456789";
		DataResult<Flight> result= this.fligthService.search(flightNumber);
		
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertNotNull(result.getData());
	}
	
}
