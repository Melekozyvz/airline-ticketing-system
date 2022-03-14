package com.studycase.airline_ticketing_system.dataAccess.concrete;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studycase.airline_ticketing_system.entities.Route;

public interface RouteDao extends JpaRepository<Route, Integer> {

	Route getByDeparture(String departure);
	
	Route getByLanding(String landing);

	Route getByDepartureAndLanding(String departure,String landing);

}
