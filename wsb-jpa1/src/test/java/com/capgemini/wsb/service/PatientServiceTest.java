package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest
{
    @Autowired
    private VisitDao visitDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientService patientService;

    @Transactional
    @Test
    public void testShouldDeletePatient() {
        // given
        Long id = 1L;
        // when
        patientService.deletePatient(id);
        // then
        Assertions.assertThat(patientDao.findOne(id)).isNull();
    }

    @Transactional
    @Test
    public void testShouldDeletePatientVisits() {
        // given
        Long id = 2L;
        PatientEntity patientEntity = patientDao.findOne(id);
        // when
        patientService.deletePatient(id);
        // then
        patientEntity.getVisits().forEach((visit) -> Assertions.assertThat(visitDao.findOne(visit.getId())).isNull());
    }

    @Transactional
    @Test
    public void testShouldNotDeleteVisitsDoctors() {
        // given
        Long id = 3L;
        PatientEntity patientEntity = patientDao.findOne(id);
        // when
        patientService.deletePatient(id);
        // then
        patientEntity.getVisits().forEach((visit) -> Assertions.assertThat(doctorDao.findOne(visit.getDoctor().getId())).isNotNull());
    }

    @Transactional
    @Test
    public void testShouldReturnCorrectPatientStructure() {
        // given
        Long id = 1L;
        PatientEntity patientEntity = patientDao.findOne(id);

        PatientTO expectedPatientTo = PatientMapper.mapToTO(patientEntity);

        // when
        PatientTO patientTo = patientService.findById(id);

        // then
        Assertions.assertThat(patientTo.getVisitsID().size()).isEqualTo(expectedPatientTo.getVisitsID().size());
        Assertions.assertThat(patientTo).usingRecursiveComparison().isEqualTo(expectedPatientTo);
    }

    @Transactional
    @Test
    public void testShouldReturnAllPatientVisits() {
        // given
        Long id = 1L;
        int expectedVisitsNumber = 3;

        // when
        PatientTO patientTo = patientService.findById(id);

        // then
        Assertions.assertThat(patientTo.getVisitsID().size()).isEqualTo(expectedVisitsNumber);
    }
}