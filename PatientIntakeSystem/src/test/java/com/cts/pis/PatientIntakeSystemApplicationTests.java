package com.cts.pis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.mysql.cj.exceptions.AssertionFailedException;

@SpringBootTest
class PatientIntakeSystemApplicationTests {

	private List<PatientAppointment> list=new ArrayList<>();
	@Test
	public void addPatientTest() {
		ClinicCalender calender=new ClinicCalender();
		PatientAppointment patient;
		try {
			patient=calender.addAppointment("prabhu", 23, "Dr.Blades-Surgeon", "23-09-2021", "08:00");
			assertNotNull(patient);
		} catch (InvalidDateFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void IsPatientAddedTest() {
		ClinicCalender calender=new ClinicCalender();
		PatientAppointment patient;
		try {
			patient=calender.addAppointment("prabhu", 23, "Dr.Blades-Surgeon", "23-09-2021", "08:00");
			list=calender.getAllAppointments();
			PatientAppointment newpatient=list.get(0);
			assertEquals(patient, newpatient, "both are same");
		} catch (InvalidDateFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void addPatientExceptionTest(){
		boolean thrown=false;
		ClinicCalender calender=new ClinicCalender();
		try {
			calender.addAppointment("prabhu", 23, "Dr.Blades-Surgeon", "23/09/2021", "08:00");
		} catch (InvalidDateFormatException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	
}