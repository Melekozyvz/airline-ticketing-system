package com.studycase.airline_ticketing_system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "month")
	private int month;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "security_code")
	private int SecurityCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_id", referencedColumnName = "id")
	private Ticket ticket;
}
