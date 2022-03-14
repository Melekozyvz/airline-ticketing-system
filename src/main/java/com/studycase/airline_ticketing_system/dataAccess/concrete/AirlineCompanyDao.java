package com.studycase.airline_ticketing_system.dataAccess.concrete;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studycase.airline_ticketing_system.entities.AirlineCompany;

public interface AirlineCompanyDao extends JpaRepository<AirlineCompany, Integer>{

	AirlineCompany getByCompanyName(String companyName);
}
