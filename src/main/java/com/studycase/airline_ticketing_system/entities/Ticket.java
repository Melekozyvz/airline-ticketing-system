package com.studycase.airline_ticketing_system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Getter
	private int id;
	
	@Column(name = "ticket_number")
	@Getter @Setter
	private String ticketNumber;
	
	@Column(name = "price")
	@Getter @Setter
	private double price;
	
	@ManyToOne()
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
    @OneToOne(mappedBy = "ticket")
	private Purchase purchase;
}
