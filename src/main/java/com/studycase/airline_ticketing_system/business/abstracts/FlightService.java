package com.studycase.airline_ticketing_system.business.abstracts;

import com.studycase.airline_ticketing_system.entities.Flight;
import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

public interface FlightService extends EntityService<Flight> {

	Result addQuotaIncrease(String flightNumber,int ratio);
}
