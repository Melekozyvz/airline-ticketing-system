package com.studycase.airline_ticketing_system.dataAccess.concrete;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studycase.airline_ticketing_system.entities.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer> {

	Flight getByFlightNumber(String flightNumber);

}
