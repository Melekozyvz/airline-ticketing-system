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
import com.studycase.airline_ticketing_system.entities.AirlineCompany;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@RestController
@RequestMapping("/api/company/")
public class AirlineCompanyController {

	private EntityService<AirlineCompany> airlineCompanyService;
	@Autowired
	public AirlineCompanyController(EntityService<AirlineCompany> airlineCompanyService) {
		this.airlineCompanyService=airlineCompanyService;
	}
	@GetMapping("getall")
	public DataResult<List<AirlineCompany>> getall(){
		return this.airlineCompanyService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody AirlineCompany airlineCompany){
		
		return this.airlineCompanyService.add(airlineCompany);
	}
	@PostMapping("search")
	public Result search(@RequestParam String companyName){
		return this.airlineCompanyService.search(companyName);
	}
}
