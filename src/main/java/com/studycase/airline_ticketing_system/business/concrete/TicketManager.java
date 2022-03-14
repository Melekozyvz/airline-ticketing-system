package com.studycase.airline_ticketing_system.business.concrete;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.dataAccess.concrete.TicketDao;
import com.studycase.airline_ticketing_system.entities.Route;
import com.studycase.airline_ticketing_system.entities.Ticket;
import com.studycase.airline_ticketing_system.utilities.messages.Messages;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorDataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;
import com.studycase.airline_ticketing_system.utilities.results.SuccessDataResult;
import com.studycase.airline_ticketing_system.utilities.results.SuccessResult;

@Service
public class TicketManager implements EntityService<Ticket> {

	private TicketDao ticketDao;
	public TicketManager(TicketDao ticketDao) {
		this.ticketDao=ticketDao;
	}
	@Override
	public Result add(Ticket entity) {
		if (entity != null) {
			Ticket ticket = ticketDao.save(entity);
			if (ticket != null)
				return new SuccessDataResult<Ticket>(ticket, Messages.entityAdded);
		}

		return new ErrorDataResult<Route>(Messages.entityCouldntAdd);
	}

	@Override
	public DataResult<List<Ticket>> getAll() {
		List<Ticket> tickets = this.ticketDao.findAll();
		if (tickets == null) {
			return new ErrorDataResult<List<Ticket>>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<List<Ticket>>(tickets, Messages.entitiesListed);
	}

	@Override
	public DataResult<Ticket> search(String ticketNumber) {
		Ticket ticket=this.ticketDao.getByticketNumber(ticketNumber);
		if (ticket == null) {
			return new ErrorDataResult<Ticket>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<Ticket>(ticket, Messages.entitiesListed);
	}

	@Override
	public Result delete(int id) {
		this.ticketDao.deleteById(id);
		return new SuccessResult(Messages.entityDeleted);
	}

	
}
