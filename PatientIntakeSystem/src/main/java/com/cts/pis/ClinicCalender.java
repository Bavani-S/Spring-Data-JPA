package com.cts.pis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicCalender {
private List<PatientAppointment> appointmentList=new ArrayList<>();
private PatientAppointment patient;
@Autowired
private PatientRepo patientRepo;
@Transactional
public List<PatientAppointment> getAllAppointments() {
	appointmentList=patientRepo.findAll();
	return appointmentList;
}
@Transactional
public PatientAppointment addAppointment(String patientName, int age, String doctor, String date, String time) throws InvalidDateFormatException {
	patient=new PatientAppointment();
	patient.setPatientName(patientName);
	patient.setAge(age);
	patient.setDoctor(doctor);
	try {
		Date dateformat=new SimpleDateFormat("dd-M-yyyy hh:mm").parse(date+" "+time);
		if(isWithinRange(dateformat)) {
			throw new InvalidDateFormatException("Date not valid (Date must be before 31-12-2021)");
		}
		patient.setDateOfAppointment(dateformat);
	} catch (ParseException e) {
		throw new InvalidDateFormatException("Invalid date/time format check again!!");
	}
	PatientAppointment currentPatient=patient;
	patientRepo.save(patient);
	appointmentList=getAllAppointments();
	for(PatientAppointment savedPatient: appointmentList) {
		if(savedPatient.getPatientName().equals(patient.getPatientName())) {
			currentPatient=savedPatient;
		}
	}
	return currentPatient;
}
boolean isWithinRange(Date testDate) throws InvalidDateFormatException {
	boolean flag=false;
	Date startDate=new Date();
	Date endDate;
	try {
		endDate = new SimpleDateFormat("dd-MM-yyyy hh:mm").parse("31-12-2021 23:59");
		flag=testDate.after(startDate)&& testDate.before(endDate);
	} catch (ParseException e) {
		throw new InvalidDateFormatException("Invalid date/time format check again!!");
	}
	return flag;
}
}
