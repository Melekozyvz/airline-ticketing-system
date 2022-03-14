package com.studycase.airline_ticketing_system.business.concrete;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studycase.airline_ticketing_system.business.abstracts.EntityService;
import com.studycase.airline_ticketing_system.dataAccess.concrete.AirlineCompanyDao;
import com.studycase.airline_ticketing_system.entities.AirlineCompany;
import com.studycase.airline_ticketing_system.utilities.messages.Messages;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorDataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;
import com.studycase.airline_ticketing_system.utilities.results.SuccessDataResult;
import com.studycase.airline_ticketing_system.utilities.results.SuccessResult;

@Service
public class AirlineCompanyManager implements EntityService<AirlineCompany> {

	private AirlineCompanyDao airlineCompanyDao;

	@Autowired
	public AirlineCompanyManager(AirlineCompanyDao airlineCompanyDao) {
		this.airlineCompanyDao = airlineCompanyDao;
	}

	@Override
	public Result add(AirlineCompany entity) {
		if (entity.getCompanyName() != null) {
			entity.setCreatedAt(new Date(System.currentTimeMillis()));
			AirlineCompany company = airlineCompanyDao.save(entity);
			if (company != null)
				return new SuccessDataResult<AirlineCompany>(company, Messages.entityAdded);
		}

		return new ErrorDataResult<AirlineCompany>(Messages.entityCouldntAdd);

	}

	@Override
	public DataResult<List<AirlineCompany>> getAll() {
		List<AirlineCompany> categories = this.airlineCompanyDao.findAll();
		if (categories == null) {
			return new ErrorDataResult<List<AirlineCompany>>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<List<AirlineCompany>>(this.airlineCompanyDao.findAll(), Messages.entitiesListed);
	}

	@Override
	public Result delete(int id) {
		this.airlineCompanyDao.deleteById(id);
		return new SuccessResult(Messages.entityDeleted);
	}

	@Override
	public DataResult<AirlineCompany> search(String companyName) {
		AirlineCompany company = airlineCompanyDao.getByCompanyName(companyName);
		if (company != null)
			return new SuccessDataResult<AirlineCompany>(company, Messages.entitiesListed);

		return new ErrorDataResult<AirlineCompany>(Messages.entitiesCouldntListed);

	}
}
