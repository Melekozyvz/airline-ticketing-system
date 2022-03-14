package com.studycase.airline_ticketing_system.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String message) {
		super(true,message);
	}
}
