package com.studycase.airline_ticketing_system.business.abstracts;

import java.util.List;

import com.studycase.airline_ticketing_system.utilities.results.DataResult;
import com.studycase.airline_ticketing_system.utilities.results.Result;

public interface EntityService<T> {
	Result add(T entity);
	
	DataResult<List<T>> getAll();
	
	DataResult<T> search(String text);
		
	Result delete(int id);
}
