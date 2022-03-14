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
import com.studycase.airline_ticketing_system.business.abstracts.FlightService;
import com.studycase.airline_ticketing_system.entities.Flight;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@RestController
@RequestMapping("/api/flight/")
public class FlightController {

	private FlightService flightService;
	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService=flightService;
	}
	@GetMapping("getall")
	public DataResult<List<Flight>> getall(){
		return this.flightService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Flight airlineCompany){
		
		return this.flightService.add(airlineCompany);
	}
	@PostMapping("search")
	public Result search(@RequestParam String fligth){
		return this.flightService.search(fligth);
	}
	
	@PostMapping("quotaincrease")
	public Result quotaincrease(@RequestParam String flightNumber,@RequestParam int ratio){
		return this.flightService.addQuotaIncrease(flightNumber,ratio);
	}
}
