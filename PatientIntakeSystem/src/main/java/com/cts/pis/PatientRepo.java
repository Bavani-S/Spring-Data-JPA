package com.cts.pis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepo extends JpaRepository<PatientAppointment, Integer> {

}
