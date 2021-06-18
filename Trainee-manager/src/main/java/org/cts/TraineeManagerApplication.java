package org.cts;

import java.util.List;
import java.util.Scanner;

import org.cts.dao.TraineeDAOImpl;
import org.cts.model.Trainee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class TraineeManagerApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger(TraineeManagerApplication.class);
	@Autowired
	private static TraineeDAOImpl traineeDAOImpl;
	private static Scanner sc;
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(TraineeManagerApplication.class, args);
		traineeDAOImpl=context.getBean(TraineeDAOImpl.class);
		sc = new Scanner(System.in);
		LOGGER.info("Select an option:");
		int choice=1;
		while(choice!=5) {
			LOGGER.info("\n1. Register a trainee" + "\n2. remove trainee"+"\n3. Find trainee by name"+"\n4. Find all the trainees"+"\n5. Exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1: sc.nextLine();
			LOGGER.info("Enter trainee employee id: ");
			int empId = sc.nextInt();
			sc.nextLine();
			LOGGER.info("Enter name: ");
			String name = sc.nextLine();
			LOGGER.info("Enter email: ");
			String email = sc.nextLine();
			LOGGER.info("Enter cohort code");
			String cohortCode = sc.nextLine();
			traineeDAOImpl.registerTrainee(empId, name, email, cohortCode);
			LOGGER.info("Do you want to continue(y/n)");
			if((sc.nextLine().equals("n")||sc.nextLine().equals("N"))) {
				choice=5;
			}
			break;
			case 2:
				LOGGER.info("Enter trainee id to remove");
				int id = sc.nextInt();
				traineeDAOImpl.removeTrainee(id);
				LOGGER.info("Do you want to continue(y/n)");
				if((sc.nextLine().equals("n")||sc.nextLine().equals("N"))) {
					choice=5;
				}
				break;
				
			case 3: 
				LOGGER.info("Enter trainee name to find");
				String traineeName = sc.next();
				Trainee trainee=traineeDAOImpl.findByName(traineeName);	
				if(trainee==null) {
					LOGGER.error("Trainee not found");
				}else {
				LOGGER.info(trainee.toString());
				}
				LOGGER.info("Do you want to continue(y/n)");
				if((sc.nextLine().equals("n")||sc.nextLine().equals("N"))) {
					choice=5;
				}
				break;
			
			case 4:
				LOGGER.info("Trainees Details:");
				List<Trainee> list=traineeDAOImpl.findAll();
				
				for(Trainee itr: list) {
					LOGGER.info(itr.toString());
					}
				LOGGER.info("Do you want to continue(y/n)");
				if((sc.nextLine().equals("n")||sc.nextLine().equals("N"))) {
					choice=5;
				}
				break;
			case 5:
				return;
			default:
				LOGGER.error("Enter choice properly!!");
				break;
			
			}
		}
		LOGGER.info("Exitted Successfully");
	}

}
