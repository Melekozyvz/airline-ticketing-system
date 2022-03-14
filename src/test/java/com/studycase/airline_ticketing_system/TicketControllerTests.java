package com.studycase.airline_ticketing_system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.entities.Ticket;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

@SpringBootTest
class TicketControllerTests {

	@Autowired
	private EntityService<Ticket> ticketService;
	
	@Test
	public void getallTicketsTest(){
		DataResult<List<Ticket>> tickets=this.ticketService.getAll();
		
		assertNotNull(tickets);
		assertTrue(tickets.isSuccess());
		assertNotNull(tickets.getData());		
	}
	@Test
	public void addTicketTest(){
		Ticket ticket=new Ticket(1, "123456", 356, null, null);
		Result result=this.ticketService.add(ticket);
		
		assertTrue(result.isSuccess());
	}
	@Test
	public void search(){
		String ticketNumber="123456";
		DataResult<Ticket> result= this.ticketService.search(ticketNumber);
		
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertNotNull(result.getData());
	}
	
	@Test
	public void deleteWithTicketNumber(){
		String ticketNumber="123456";
		DataResult<Ticket> result1= this.ticketService.search(ticketNumber);
		Result result= this.ticketService.delete(result1.getData().getId());	
		
		assertNotNull(result);
		assertTrue(result.isSuccess());
		assertNotNull(result1.getData());
	}
}
