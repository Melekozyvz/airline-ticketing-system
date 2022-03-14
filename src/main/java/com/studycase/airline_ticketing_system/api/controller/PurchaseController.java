package com.studycase.airline_ticketing_system.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.entities.Purchase;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@RestController
@RequestMapping("/api/purchase/")
public class PurchaseController {

	private EntityService<Purchase> purchaseService;
	@Autowired
	public PurchaseController(EntityService<Purchase> purchaseService) {
		this.purchaseService=purchaseService;
	}
	@GetMapping("getall")
	public DataResult<List<Purchase>> getall(){
		return this.purchaseService.getAll();
	}
	@PostMapping("buy")
	public Result add(@RequestBody Purchase purchase){
		
		return this.purchaseService.add(purchase);
	}
	
}
