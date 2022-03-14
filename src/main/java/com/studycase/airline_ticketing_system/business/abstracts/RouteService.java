package com.studycase.airline_ticketing_system.business.abstracts;

import com.studycase.airline_ticketing_system.entities.Route;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;

public interface RouteService extends EntityService<Route> {

	DataResult<Route> search(String departure,String landing);

}
