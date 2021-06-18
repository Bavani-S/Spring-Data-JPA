package org.cts.repository;

import org.cts.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Integer> {

}
