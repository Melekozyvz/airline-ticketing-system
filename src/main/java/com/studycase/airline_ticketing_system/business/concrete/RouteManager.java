package com.studycase.airline_ticketing_system.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studycase.airline_ticketing_system.business.abstracts.RouteService;
import com.studycase.airline_ticketing_system.dataAccess.concrete.RouteDao;
import com.studycase.airline_ticketing_system.entities.Route;
import com.studycase.airline_ticketing_system.utilities.messages.Messages;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.ErrorDataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;
import com.studycase.airline_ticketing_system.utilities.results.SuccessDataResult;
import com.studycase.airline_ticketing_system.utilities.results.SuccessResult;

@Service
public class RouteManager implements RouteService{

	private RouteDao routeDao;
	@Autowired
	public RouteManager(RouteDao routeDao) {
		this.routeDao=routeDao;
	}
	@Override
	public Result add(Route entity) {
		if (entity != null) {
			Route route = routeDao.save(entity);
			if (route != null)
				return new SuccessDataResult<Route>(route, Messages.entityAdded);
		}

		return new ErrorDataResult<Route>(Messages.entityCouldntAdd);
	}

	@Override
	public DataResult<List<Route>> getAll() {
		List<Route> routes = this.routeDao.findAll();
		if (routes == null) {
			return new ErrorDataResult<List<Route>>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<List<Route>>(this.routeDao.findAll(), Messages.entitiesListed);
	}

	@Override
	public Result delete(int id) {
		this.routeDao.deleteById(id);
		return new SuccessResult(Messages.entityDeleted);
	}
	@Override
	public DataResult<Route> search(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DataResult<Route> search(String departure, String landing) {
		Route route=this.routeDao.getByDepartureAndLanding(departure, landing);
		if (route == null) {
			return new ErrorDataResult<Route>(Messages.entitiesCouldntListed);
		}
		return new SuccessDataResult<Route>(route, Messages.entitiesListed);
	}

}
