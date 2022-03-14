package com.studycase.airline_ticketing_system.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studycase.airline_ticketing_system.business.abstracts.FlightService;
import com.studycase.airline_ticketing_system.dataAccess.concrete.FlightDao;
import com.studycase.airline_ticketing_system.dataAccess.concrete.TicketDao;
import com.studycase.airline_ticketing_system.entities.Flight;
import com.studycase.airline_ticketing_system.entities.Ticket;
import com.studycase.airline_ticketing_system.utilities.messages.Messages;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorDataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;
import com.studycase.airline_ticketing_system.utilities.results.SuccessDataResult;
import com.studycase.airline_ticketing_system.utilities.results.SuccessResult;

@Service
public class FlightManager implements FlightService {

	private FlightDao flightDao;
	private TicketDao ticketDao;
	
	@Autowired
	public FlightManager(FlightDao flightDao,TicketDao ticketDao) {
		this.flightDao=flightDao;
		this.ticketDao=ticketDao;
	}
	@Override
	public Result add(Flight entity) {
		if (entity!= null) {
			
			Flight flight= flightDao.save(entity);
			if (flight != null)
				return new SuccessDataResult<Flight>(flight, Messages.entityAdded);
		}

		return new ErrorDataResult<Flight>(Messages.entityCouldntAdd);
	}

	@Override
	public DataResult<List<Flight>> getAll() {
		List<Flight> flights = this.flightDao.findAll();
		if (flights == null) {
			return new ErrorDataResult<List<Flight>>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<List<Flight>>(flights, Messages.entitiesListed);
	}

	@Override
	public DataResult<Flight> search(String text) {
		Flight flight=this.flightDao.getByFlightNumber(text);
		if (flight != null)
			return new SuccessDataResult<Flight>(flight, Messages.entitiesListed);

		return new ErrorDataResult<Flight>(Messages.entitiesCouldntListed);
	}

	@Override
	public Result delete(int id) {
		this.flightDao.deleteById(id);
		return new SuccessResult(Messages.entityDeleted);
	}
	
	@Override
	public Result addQuotaIncrease(String flightNumber,int ratio) {
		Flight flight=this.flightDao.getByFlightNumber(flightNumber);
		flight.setQuota(flight.getQuota()+flight.getQuota()*ratio/100);
		Flight saved=this.flightDao.save(flight);
		
		List<Ticket> tickets=this.ticketDao.getByFlight_Id(flight.getId());
		for (Ticket ticket : tickets) {
			
			ticket.setPrice(ticket.getPrice()+ticket.getPrice()*ratio/100);
		}
		List<Ticket> savedTickets=this.ticketDao.saveAll(tickets);
		if (saved!=null&&savedTickets!=null) {
			return  new SuccessResult(Messages.entityAdded);
		}
		return new ErrorResult(Messages.entityCouldntAdd);
	}

}
