package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    @Description("Lab3 - Zad1")
    public void testShouldReturnPatientWhenPassedLastName()
    {
        //given
        final String lastNameSearchingPatient = "Doe";
        final Long expectedPatientId = 1L;
        final String expectedPatientName = "John";
        //when
        PatientEntity patientEntity = patientDao.findByLastName(lastNameSearchingPatient).get(0);
        //then
        assertEquals(expectedPatientId, patientEntity.getId());
        assertEquals(expectedPatientName, patientEntity.getFirstName());
        assertEquals(patientDao.findOne(1L), patientEntity);
    }
    @Transactional
    @Test
    @Description("Lab3 - Zad3")
    public void testShouldReturnListOfPatientsWithMoreVisitsThanParameter()
    {
        //given
        final int numberOfVisits = 2;
        final int expectedNumberOfPatients = 5;
        //when
        List<PatientEntity> listOfPatients = patientDao.getPatientWithMoreThanXVisits(numberOfVisits);
        //then
        assertEquals(expectedNumberOfPatients, listOfPatients.size());
    }
    @Transactional
    @Test
    @Description("Lab3 - Zad4")
    public void testShouldReturnListOfPatientsWithLessPeselNumber()
    {
        //given
        final int expectedNumberOfPatients = 1;
        // when
        List<PatientEntity> listOfPatients = patientDao.findByStillAlive(false);
        //then
        assertEquals(expectedNumberOfPatients, listOfPatients.size());
    }
}