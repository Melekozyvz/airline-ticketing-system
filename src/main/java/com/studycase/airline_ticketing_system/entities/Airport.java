package com.studycase.airline_ticketing_system.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "airport")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "airport_name")
	private String airportName;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "deleted_at")
	private Date deletedAt;
	
	public Airport(String airportName) {
		this.airportName=airportName;
	}
}
