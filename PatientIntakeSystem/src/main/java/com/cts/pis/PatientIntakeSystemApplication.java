package com.cts.pis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PatientIntakeSystemApplication {
	public static final Logger LOGGER=LoggerFactory.getLogger(PatientIntakeSystemApplication.class);
	private static Scanner sc;
	private static PatientAppointment patient;
	private static ClinicCalender calender;

	public static void main(String[] args){
		ApplicationContext context =SpringApplication.run(PatientIntakeSystemApplication.class, args);
		calender=context.getBean(ClinicCalender.class);
		sc = new Scanner(System.in);
		List<PatientAppointment> appointmentList=new ArrayList<>();
		LOGGER.info("Patient Intake System");
		int choice = 0;
		 do{
			LOGGER.info("Choose an option");
			LOGGER.info("\n1. Add a patient appointment\n2. View all appointments\n3. Exit");
			choice= sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1://adding a patient
				LOGGER.info("Enter patient name:");
				String patientName=sc.nextLine();
				LOGGER.info("Enter patient age:");
				int age=sc.nextInt();
				sc.nextLine();
				LOGGER.info("Choose the doctor from the list for appointment:");
				Doctor[] list=Doctor.values();
				for(Doctor doctor: list) {
				LOGGER.info(doctor.toString());
				}
				String doctor=sc.nextLine();
				LOGGER.info("Enter the date of appointment:(dd-M-yyyy)");
				String date=sc.nextLine();
				LOGGER.info("Enter Time:(hh:mm)");
				String time=sc.nextLine();
				try {
					patient=calender.addAppointment(patientName,age,doctor,date,time);
				} catch (InvalidDateFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LOGGER.info("Appointment details:");
				LOGGER.info(patient.toString());
				break;
			case 2://view all appointments
				appointmentList=calender.getAllAppointments();
				for(PatientAppointment appointment : appointmentList) {
					LOGGER.info(appointment.toString());
				}
				break;
			case 3://exit case
				LOGGER.info("Do you want to exit?(y/n)");
				if(sc.next().equalsIgnoreCase("y")) {
					choice=4;
				}
				break;
			default: 
				LOGGER.info("Choose the option as given in the menu");
				break;
			
			}
		}while(choice!=4);
		 LOGGER.info("Process done");
		 System.exit(0);
	}

}
