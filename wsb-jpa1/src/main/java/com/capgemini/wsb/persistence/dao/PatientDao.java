package com.capgemini.wsb.persistence.dao;

import java.util.List;

import com.capgemini.wsb.persistence.entity.PatientEntity;

public interface PatientDao extends Dao<PatientEntity, Long> {

    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> getPatientWithMoreThanXVisits(int x);

    List<PatientEntity> findByStillAlive(boolean stillAlive);
    
}
