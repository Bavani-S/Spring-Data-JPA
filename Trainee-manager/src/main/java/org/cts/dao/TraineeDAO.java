package org.cts.dao;

import java.util.List;

import org.cts.model.Trainee;

public interface TraineeDAO {
	public void registerTrainee(int empId,String name,String email,String cohortCode);
	public void removeTrainee(int empId);
	public Trainee findByName(String name);
	public List<Trainee> findAll();
}
