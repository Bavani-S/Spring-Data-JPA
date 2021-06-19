package com.cts.pis;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointment {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "int default 1")
	private int patientId;
	private String patientName;
	private int age;
	private String doctor;
	private Date DateOfAppointment;
}
