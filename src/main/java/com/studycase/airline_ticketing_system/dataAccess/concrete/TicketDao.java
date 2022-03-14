package com.studycase.airline_ticketing_system.dataAccess.concrete;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studycase.airline_ticketing_system.entities.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

	Ticket getByticketNumber(String ticketNumber);
	
	List<Ticket> getByFlight_Id(int id);
}
