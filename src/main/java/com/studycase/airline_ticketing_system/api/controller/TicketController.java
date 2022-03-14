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
import com.studycase.airline_ticketing_system.entities.Ticket;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@RestController
@RequestMapping("/api/ticket/")
public class TicketController {
	private EntityService<Ticket> ticketService;
	@Autowired
	public TicketController(EntityService<Ticket> ticketService) {
		this.ticketService=ticketService;
	}
	@GetMapping("getall")
	public DataResult<List<Ticket>> getall(){
		return this.ticketService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Ticket ticket){
		
		return this.ticketService.add(ticket);
	}
	@PostMapping("search")
	public Result search(@RequestParam String ticketNumber){
		return this.ticketService.search(ticketNumber);
	}
	@PostMapping("delete/{ticketNumber}")
	public Result delete(@RequestParam String ticketNumber){
		DataResult<Ticket> result= this.ticketService.search(ticketNumber);
		return this.ticketService.delete(result.getData().getId());
				
	}
}
