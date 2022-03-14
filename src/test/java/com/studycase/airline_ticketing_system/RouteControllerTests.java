package com.studycase.airline_ticketing_system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studycase.airline_ticketing_system.business.abstracts.RouteService;
import com.studycase.airline_ticketing_system.entities.Route;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@SpringBootTest
class RouteControllerTests {

	@Autowired
	private RouteService routeService;
	
	@Test
	public void getallRoutesTest(){
		DataResult<List<Route>> routes=this.routeService.getAll();
		
		assertNotNull(routes);
		assertTrue(routes.isSuccess());
		assertNotNull(routes.getData());		
	}
	@Test
	public void addRouteTest(){
		Route route=new Route(1, "istanbul", "antalya", null);
		Result result=this.routeService.add(route);
		
		assertTrue(result.isSuccess());
	}
	@Test
	public void search(){
		String departure="istanbul",landing="ankara";
		DataResult<Route> result= this.routeService.search(departure,landing);
		
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertNotNull(result.getData());
	}
}
