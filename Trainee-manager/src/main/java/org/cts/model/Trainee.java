package org.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {
	@Id
	@Column(name="empid")
	private int empId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="cohort_code")
	private String cohortCode; 
}
