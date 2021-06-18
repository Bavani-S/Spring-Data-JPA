package org.cts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.cts.exception.InvalidTraineeDataException;
import org.cts.model.Trainee;
import org.cts.repository.TraineeRepo;
import org.cts.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeDAOImpl implements TraineeDAO {
	private static final Logger LOGGER=LoggerFactory.getLogger(TraineeDAOImpl.class);
	Validator valid;
	@Autowired
	private TraineeRepo traineeRepo;
	public TraineeDAOImpl() {
		new ArrayList<>();
	}
	
	@Override
	@Transactional
	public void registerTrainee(int empId, String name, String email, String cohortCode) {
		// TODO Auto-generated method stub
		valid=new Validator();
		try {
			if(valid.checkEmpId(empId) &&
			valid.checkName(name) &&
			valid.checkEmail(email) &&
			valid.checkCohortCode(cohortCode)) {
				Trainee trainee = new Trainee(empId,name,email,cohortCode);
				LOGGER.info(trainee.toString());
				traineeRepo.save(trainee);
				//list.add(trainee);
				LOGGER.info("Trainee added Successfully");
			}else {
				LOGGER.info("Trainee registration failed!");
			}
		} catch (InvalidTraineeDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public void removeTrainee(int empId) {
		traineeRepo.deleteById(empId);
		LOGGER.info("Trainee detail removed successfully");
	}

	@Override
	@Transactional
	public Trainee findByName(String name) {
		// TODO Auto-generated method stub
		Trainee traineeFound=null;
		List<Trainee> traineeList=traineeRepo.findAll();
		
			
				for(Trainee trainee : traineeList) {
					if(trainee.getName().equals(name)) {
						traineeFound=traineeRepo.findById(trainee.getEmpId()).get();
						return traineeFound;
					}
				}
		return traineeFound;
	}

	@Override
	@Transactional
	public List<Trainee> findAll() {
		List<Trainee> traineeList=traineeRepo.findAll();
		return traineeList;
	}

}
