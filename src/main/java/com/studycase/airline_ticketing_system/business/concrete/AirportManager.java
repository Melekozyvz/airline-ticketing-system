package com.studycase.airline_ticketing_system.business.concrete;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.dataAccess.concrete.AirportDao;
import com.studycase.airline_ticketing_system.entities.Airport;
import com.studycase.airline_ticketing_system.utilities.messages.Messages;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorDataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;
import com.studycase.airline_ticketing_system.utilities.results.SuccessDataResult;
import com.studycase.airline_ticketing_system.utilities.results.SuccessResult;

@Service
public class AirportManager implements EntityService<Airport> {
	
	private AirportDao airportDao;

	@Autowired
	public AirportManager(AirportDao airportDao) {
		this.airportDao = airportDao;
	}

	@Override
	public Result add(Airport entity) {
		if (entity.getAirportName() != null) {
			entity.setCreatedAt(new Date(System.currentTimeMillis()));
			Airport airport = airportDao.save(entity);
			if (airport != null)
				return new SuccessDataResult<Airport>(airport, Messages.entityAdded);
		}

		return new ErrorDataResult<Airport>(Messages.entityCouldntAdd);

	}

	@Override
	public DataResult<List<Airport>> getAll() {
		List<Airport> categories = this.airportDao.findAll();
		if (categories == null) {
			return new ErrorDataResult<List<Airport>>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<List<Airport>>(this.airportDao.findAll(), Messages.entitiesListed);
	}


	@Override
	public Result delete(int id) {
		this.airportDao.deleteById(id);
		return new SuccessResult(Messages.entityDeleted);
	}

	@Override
	public DataResult<Airport> search(String airportName) {
		Airport airport = airportDao.getByAirportName(airportName);
		if (airport != null)
			return new SuccessDataResult<Airport>(airport, Messages.entityAdded);

		return new ErrorDataResult<Airport>(Messages.entityCouldntAdd);

	}
	
}
