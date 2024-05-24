package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public PatientTO addPatient(PatientTO patient) throws Exception {
        if (patient == null) {
            throw new Exception("Patient cannot be null");
        }
        final PatientEntity entity = patientDao.save(PatientMapper.mapToEntity(patient));
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public PatientTO updatePatient(PatientTO patient) throws Exception {
        PatientEntity patientEntity = patientDao.findOne(patient.getId());
        if (patientEntity == null) {
            throw new Exception("Patient cannot be null");
        }
        final PatientEntity entity = patientDao.update(PatientMapper.mapToEntity(patient));
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public boolean deletePatient(Long id) {
        try {
            patientDao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
