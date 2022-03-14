package com.studycase.airline_ticketing_system.entities;

import java.util.Date;
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
@Table(name = "airline_companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AirlineCompany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "deleted_at")
	private Date deletedAt;
	
	@OneToMany(mappedBy = "airlineCompany")
	private List<Flight> flights;
	
	public AirlineCompany(String compnayName,Date createdDate) {
		this.companyName=compnayName;
		this.createdAt=createdDate;
	}

}
