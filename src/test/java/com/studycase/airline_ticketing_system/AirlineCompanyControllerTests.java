package com.studycase.airline_ticketing_system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.entities.AirlineCompany;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@SpringBootTest
class AirlineCompanyControllerTests {

	@Autowired
	private EntityService<AirlineCompany> airlineCompanyService;
	
	@Test
	public void getallCompanyTest(){
		DataResult<List<AirlineCompany>> companies=this.airlineCompanyService.getAll();
		
		assertNotNull(companies);
		assertTrue(companies.isSuccess());
		assertNotNull(companies.getData());		
	}
	@Test
	public void addCompanyTest(){
		AirlineCompany airlineCompany=new AirlineCompany( "Asiana Airlines",new Date(System.currentTimeMillis()));
		Result result=this.airlineCompanyService.add(airlineCompany);
		
		assertTrue(result.isSuccess());
	}
	@Test
	public void search(){
		String companyName="Turkish Airlines";
		DataResult<AirlineCompany> result= this.airlineCompanyService.search(companyName);
		
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertNotNull(result.getData());
	}
}
