package com.studycase.airline_ticketing_system.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Getter
	private int id;
	
	@Column(name = "flight_number")
	@Getter @Setter
	private String flightNumber;
	
	@Column(name = "flight_date")
	@Getter @Setter
	private Date date;
	
	@Column(name = "quota")
	@Getter @Setter
	private int quota;

	@ManyToOne()
	@JoinColumn(name = "company_id")
	private AirlineCompany airlineCompany;
	
	@ManyToOne()
	@JoinColumn(name = "route_id")
	@Getter @Setter
	private Route route;
	
	@OneToMany(mappedBy = "flight")
	private List<Ticket> tickets;
	
}
