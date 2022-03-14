package com.studycase.airline_ticketing_system.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studycase.airline_ticketing_system.business.abstracts.RouteService;
import com.studycase.airline_ticketing_system.entities.Route;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@RestController
@RequestMapping("/api/route/")
public class RouteController {

	private RouteService routeService;
	@Autowired
	public RouteController(RouteService routeService) {
		this.routeService=routeService;
	}
	@GetMapping("getall")
	public DataResult<List<Route>> getall(){
		return this.routeService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Route route){
		
		return this.routeService.add(route);
	}
	@PostMapping("search")
	public Result search(@RequestParam String departure,@RequestParam String landing){
		return this.routeService.search(departure,landing);
	}
	
}
