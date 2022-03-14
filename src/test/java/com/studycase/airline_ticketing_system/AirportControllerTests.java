package com.studycase.airline_ticketing_system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.entities.Airport;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@SpringBootTest
class AirportControllerTests {

	@Autowired
	private EntityService<Airport> airportService;
	
	@Test
	public void getallAirportsTest(){
		DataResult<List<Airport>> companies=this.airportService.getAll();
		
		assertNotNull(companies);
		assertTrue(companies.isSuccess());
		assertNotNull(companies.getData());		
	}
	@Test
	public void addAirportTest(){
		Airport Airport=new Airport("Test Airport");
		Result result=this.airportService.add(Airport);
		
		assertTrue(result.isSuccess());
	}
	@Test
	public void search(){
		String airport="Test Airport";
		DataResult<Airport> result= this.airportService.search(airport);
		
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertNotNull(result.getData());
	}
}
