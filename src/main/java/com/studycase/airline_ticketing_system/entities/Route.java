package com.studycase.airline_ticketing_system.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "route")
@AllArgsConstructor
@NoArgsConstructor
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "departure")
	@Getter @Setter
	private String departure;
	
	@Column(name="landing")
	@Getter @Setter
	private String landing;
	
	@OneToMany(mappedBy = "route")
	private List<Flight> flights;
}
