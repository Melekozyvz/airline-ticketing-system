package com.studycase.airline_ticketing_system.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.entities.Airport;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@RestController
@RequestMapping("/api/airport/")
public class AirportController {

	private EntityService<Airport> airportService;
	@Autowired
	public AirportController(EntityService<Airport> airportService) {
		this.airportService=airportService;
	}
	@GetMapping("getall")
	public DataResult<List<Airport>> getall(){
		return this.airportService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Airport airlineCompany){
		
		return this.airportService.add(airlineCompany);
	}
	@PostMapping("search")
	public Result search(@RequestParam String companyName){
		return this.airportService.search(companyName);
	}
}
