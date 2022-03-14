package com.studycase.airline_ticketing_system.dataAccess.concrete;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studycase.airline_ticketing_system.entities.Airport;

public interface AirportDao extends JpaRepository<Airport, Integer>{

	Airport getByAirportName(String airportName);
}
